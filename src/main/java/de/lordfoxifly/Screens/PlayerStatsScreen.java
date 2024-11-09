package de.lordfoxifly.Screens;

import de.lordfoxifly.Api.CharacterDataAPI.CharacterDataUtils;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListUtils;
import de.lordfoxifly.Api.MinecraftAPI;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.Screens.PlayerStats.PlayerStatsHelper;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.WynnMiataWidgets.ImageButtonWidget;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlayerStatsScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "playerstats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;

    public static Player getRequestedPlayer() {
        return requestedPlayer;
    }
    private List<ImageButtonWidget> classbuttons;
    private static boolean update = true;

    private static Player requestedPlayer;

    private TextFieldWidget textFieldWidget;
    private ButtonWidget addFriend;
    private ButtonWidget addGuild;
    private ButtonWidget addParty;

    public PlayerStatsScreen(Player requestedPlayer) {
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;
        PlayerStatsScreen.requestedPlayer = requestedPlayer;
    }

    public static void setPlayer(String username) {
        try {
            requestedPlayer = PlayerAPIHelper.getPlayer(RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/"+ MinecraftAPI.getPlayerUUID(username)));//MinecraftClient.getInstance().getSession().getUsername()));
            Map<String, CharacterListData> characterListDataMap = CharacterListUtils.getCharacterMap(RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/" +requestedPlayer.getUuid() +  "/characters"));
            requestedPlayer.setCharacters(characterListDataMap);
            requestedPlayer.setCharacterData(CharacterDataUtils.getCharacterDataFromCharacterUUIDList(CharacterListUtils.getCharacterUUID(characterListDataMap), requestedPlayer.getUuid(), requestedPlayer.isPublicProfile()));
            requestedPlayer.setActiveCharacterData(CharacterDataUtils.getActiveCharacter(requestedPlayer));
            requestedPlayer.setSelectedCharacterData(requestedPlayer.getActiveCharacterData());
            requestedPlayer.setSelectedCharacterUUID(requestedPlayer.getActiveCharacter());
            update = true;
            if (requestedPlayer.getUsername().equals( MinecraftClient.getInstance().getSession().getUsername())){
                WynnMiata.ClientPlayer = PlayerStatsScreen.getRequestedPlayer();
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            WynnMiata.LOGGER.error(e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void init() {
        super.init();
        update = true;
        if (requestedPlayer ==null){
            requestedPlayer = WynnMiata.ClientPlayer;
        }
        classbuttons = PlayerStatsHelper.getClassWidgets(leftpos, toppos, requestedPlayer);
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;
        textFieldWidget = TextFields.PlayerStatSearch(leftpos, toppos);
        addDrawableChild(textFieldWidget);
        addDrawableChild(TextFields.PLayerStatSearchEnter(leftpos,toppos,textFieldWidget));
        addDrawableChild(Buttons.DEFAULTSTATS(leftpos, toppos, true));
        addDrawableChild(Buttons.RAIDSTATS(leftpos,toppos));
        addDrawableChild(Buttons.PROFSTATS(leftpos,toppos));
        addDrawableChild(Buttons.ABILTYTREE(leftpos,toppos));
        addDrawableChild(Buttons.OTHERSTATS(leftpos,toppos));

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        renderPlayerStats(context);

    }

    private void renderPlayerStats(DrawContext context) {
        context.drawText(textRenderer, "Stats of : " + requestedPlayer.getUsername(), leftpos + 15, toppos + 35, 0xFFFFFFFF, true);
        context.drawText(textRenderer, "Online: ",leftpos + 15, toppos + 45, 0xFFFFFFFF, true);
        PlayerStatsHelper.renderOnlineWool(context, requestedPlayer.isOnline(), leftpos,toppos);
        context.drawText(textRenderer, "Rank: " + getSupportRank(requestedPlayer), leftpos + 15, toppos + 55, 0xFFFFFFFF, true);
        context.drawText(textRenderer, "Total Time Played : " + requestedPlayer.getPlaytime(), leftpos + 15, toppos + 65, 0xFFFFFFFF, true);
        //context.drawText(textRenderer, "Classes: "+ requestedPlayer.getCharacters().size(), leftpos + 15, toppos + 75, 0xFFFFFFFF,  true);
        context.drawText(textRenderer, "Active Class: "+ requestedPlayer.getActiveCharacterData().getType(), leftpos + 15, toppos + 85, 0xFFFFFFFF,  true);
        context.drawText(textRenderer, "First joined: " + requestedPlayer.getFirstJoin().substring(0, requestedPlayer.getFirstJoin().indexOf("T")), leftpos + 15, toppos + 95, 0xFFFFFF, true);
        context.drawText(textRenderer, "Last joined: " + requestedPlayer.getLastJoin().substring(0, requestedPlayer.getLastJoin().indexOf("T")), leftpos + 15, toppos + 105, 0xFFFFFF, true);
        //Guild
        context.drawText(textRenderer,  "Guild:", leftpos + 15 , toppos + 125, 0xFFFFFF, true);
        if (requestedPlayer.getGuild() != null){
            if (requestedPlayer.getGuild().getRankStars() !=null){
                context.drawText(textRenderer,  requestedPlayer.getGuild().getRankStars() + " " +requestedPlayer.getGuild().getRank() + " of " + requestedPlayer.getGuild().getName(), leftpos + 15 , toppos + 135, 0xFFFFFF, true);
            }
            else{
                context.drawText(textRenderer,  requestedPlayer.getGuild().getRank() + " of " + requestedPlayer.getGuild().getName(), leftpos + 15 , toppos + 135, 0xFFFFFF, true);
            }

        }
        else {
            context.drawText(textRenderer,  "No Guild", leftpos + 15 , toppos + 135, 0xFFFFFF, true);
        }

        //Right Side
        context.drawText(textRenderer, "Gamemodes:" , leftpos + 180, toppos + 35, 0xFFFFFF, true);
        int gamemodeyOffset = 10 * requestedPlayer.getSelectedCharacterData().getGamemode().size();
        renderGamemodes(context, 45);



        if(update){
            remove(addFriend);
            remove(addParty);
            remove(addGuild);
            for (ImageButtonWidget imageButtonWidget: classbuttons){
                remove(imageButtonWidget);
            }
            addFriend = Buttons.CommandButton(leftpos + 14, toppos+ 15, 65, 18, "friend add " +requestedPlayer.getUsername() , "Sends a Friend request to the Player", "gui." + WynnMiata.MOD_ID + ".playerstats.Button.AddFriend" );
            addParty =  Buttons.CommandButton(leftpos + 79, toppos+ 15, 65, 18, "party invite " + requestedPlayer.getUsername(), "Sends a Party invite", "gui." + WynnMiata.MOD_ID + ".playerstats.Button.AddParty" );
            addGuild = Buttons.CommandButton(leftpos + 144, toppos+ 15, 65, 18, "guild invite " + requestedPlayer.getUsername() , "Sends a Guild Invite", "gui." + WynnMiata.MOD_ID + ".playerstats.Button.AddGuild" );
            classbuttons = PlayerStatsHelper.getClassWidgets(leftpos,toppos,requestedPlayer);
            for (ImageButtonWidget imageButtonWidget: classbuttons ){
                addDrawableChild(imageButtonWidget);
            }
            addDrawableChild(addFriend);
            addDrawableChild(addParty);
            addDrawableChild(addGuild);
            update = false;
        }
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(PLAYERBACKGROUND_STATS,  leftpos, toppos + 15,0,0, 384,220, 384, 220);


    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    private void renderGamemodes(DrawContext context, int y){
        int yoffset = y;
        if (requestedPlayer.getSelectedCharacterData().getGamemode().isEmpty()){
            return;
        }
        for (Object gamemode : requestedPlayer.getSelectedCharacterData().getGamemode()){
            context.drawText(textRenderer, gamemode.toString(), leftpos + 180, toppos + yoffset, 0xFFFFFF, true);
            yoffset += 10;
        }
    }

    public String getSupportRank(Player player){
        if (player.getSupportRank() != null){
            return player.getSupportRank().toUpperCase();
        }
        else return  "Player";
    }
}
