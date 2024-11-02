package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.*;
import de.lordfoxifly.Screens.Customize.CustomizeMenuScreen;
import de.lordfoxifly.Screens.Customize.CustomizeTypes;
import de.lordfoxifly.Screens.PlayerStats.Screens.AbilityTreeScreen;
import de.lordfoxifly.Screens.PlayerStats.Screens.OtherStatsScreen;
import de.lordfoxifly.Screens.PlayerStats.Screens.ProfStatScreen;
import de.lordfoxifly.Screens.PlayerStats.Screens.RaidStatScreen;
import de.lordfoxifly.Screens.Widgets.WynnMiataWidgets.ImageButtonWidget;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;



public class Buttons {

    private final static Identifier TOLRUNE = Identifier.of("wynnmiata", "textures/gui/runes/tolrune.png");
    private final static Identifier DEFAULTSTATS = Identifier.of("wynnmiata", "textures/gui/paper.png");
    private final static Identifier IRON_PICKAXE = Identifier.of("wynnmiata", "textures/gui/iron_pickaxe.png");
    private final static Identifier KNOWLEDGE_BOOK = Identifier.of("wynnmiata", "textures/gui/knowledge_book.png");
    private final static Identifier ABILITY_TREE = Identifier.of("wynnmiata", "textures/gui/wynncrafttexture/ability_shard.png");

    private  static final int leftBackGroundX = 6;
    private static final int topBackGroundY = 22;


    public static ButtonWidget NOLButton(int lefpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.NOL.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new NexusOfLightScreen());

        }).dimensions( lefpos + leftBackGroundX, toppos +  topBackGroundY + 20, 55, 20).tooltip(Tooltip.of(Text.of("Coming Soon"))).build();
    }

    public static   ButtonWidget MISCButton (int leftpos, int toppos){return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.MISC.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new MiscScreen());

    }).dimensions( leftpos + leftBackGroundX, toppos+  topBackGroundY+ 40, 55, 20).tooltip(Tooltip.of(Text.of("Misc Features"))).build();}

    public static   ButtonWidget RAIDSButton(int leftpos, int toppos){
        return  ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.RAIDS.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new RaidsScreen());

        }).dimensions(  leftpos + leftBackGroundX,  toppos+ topBackGroundY + 60, 55, 20).tooltip(Tooltip.of(Text.of("Raid Features"))).build();
    }


    public static ButtonWidget TTCButton(int leftpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new TheCanyonColossusScreen());

        }).dimensions( leftpos + leftBackGroundX, toppos + topBackGroundY, 55, 20).tooltip(Tooltip.of(Text.of("TCC Features"))).build();
    }


    public static ButtonWidget DebugButton(int leftpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Debug.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new DebugScreen());

        }).dimensions( leftpos + leftBackGroundX, toppos + topBackGroundY + 80, 55, 20).tooltip(Tooltip.of(Text.of("For Debugging/Testing Features"))).build();
    }
    public static ButtonWidget LayoutButton(int leftpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Layout.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new LayoutScreen());

        }).dimensions( leftpos + leftBackGroundX, toppos + topBackGroundY + 185, 55, 20).tooltip(Tooltip.of(Text.of("Change the Layout of Features"))).build();
    }
    public static ButtonWidget CustomizeButton(int leftpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Customize.Button.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new CustomizeScreen());

        }).dimensions( leftpos + leftBackGroundX, toppos + topBackGroundY + 165, 55, 20).tooltip(Tooltip.of(Text.of("Change the Settings of Features"))).build();
    }

    public static ButtonWidget LavaHighlight(int leftpos, int toppos){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".Customize.LavaHighlight.Open"), (btn) -> {
            MinecraftClient.getInstance().setScreen(new CustomizeMenuScreen(CustomizeTypes.LAVAHIGHLIGHT));

        }).dimensions( leftpos + leftBackGroundX, toppos + topBackGroundY, 55, 20).tooltip(Tooltip.of(Text.of("Change the Settings of Features"))).build();
    }


    public static ImageButtonWidget RAIDSTATS(int leftpos, int toppos){
        boolean selected = false;

        return new ImageButtonWidget(leftpos + 50 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.RaidStats"),TOLRUNE, selected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new RaidStatScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget RAIDSTATS(int leftpos, int toppos, boolean isSelected){
        return new ImageButtonWidget(leftpos + 50 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.RaidStats"),TOLRUNE, isSelected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new RaidStatScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget DEFAULTSTATS(int leftpos, int toppos) {
        boolean selected = false;
        return new ImageButtonWidget(leftpos + 15, toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID, "gui. " + WynnMiata.MOD_ID + "playerstats.Button.DefaultStats"), DEFAULTSTATS,selected ,(button) -> {
            MinecraftClient.getInstance().setScreen(new PlayerStatsScreen(PlayerStatsScreen.getRequestedPlayer()));
        } );
    }

    public static ImageButtonWidget DEFAULTSTATS(int leftpos, int toppos, boolean isSelected) {
        return new ImageButtonWidget(leftpos + 15, toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID, "gui. " + WynnMiata.MOD_ID + "playerstats.Button.DefaultStats"), DEFAULTSTATS, isSelected,(button) -> {
            MinecraftClient.getInstance().setScreen(new PlayerStatsScreen(PlayerStatsScreen.getRequestedPlayer()));
        } );
    }

    public static ImageButtonWidget PROFSTATS(int leftpos, int toppos){
        boolean selected = false;

        return new ImageButtonWidget(leftpos + 85 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.RaidStats"),IRON_PICKAXE, selected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new ProfStatScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget PROFSTATS(int leftpos, int toppos, boolean isSelected){
        return new ImageButtonWidget(leftpos + 85 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.RaidStats"),IRON_PICKAXE, isSelected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new ProfStatScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget ABILTYTREE(int leftpos, int toppos){
        boolean selected = false;
        return new ImageButtonWidget(leftpos + 120 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.AbilityTree"),ABILITY_TREE, selected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new AbilityTreeScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget ABILTYTREE(int leftpos, int toppos, boolean isSelected){
        return new ImageButtonWidget(leftpos + 120 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.AbiltyTree"),ABILITY_TREE, isSelected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new AbilityTreeScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget OTHERSTATS(int leftpos, int toppos){
        boolean selected = false;
        return new ImageButtonWidget(leftpos + 155 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.OtherStats"),KNOWLEDGE_BOOK, selected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new OtherStatsScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }

    public static ImageButtonWidget OTHERSTATS(int leftpos, int toppos, boolean isSelected){
        return new ImageButtonWidget(leftpos + 155 , toppos + 240, 20,20, Text.translatable(WynnMiata.MOD_ID,"gui. " + WynnMiata.MOD_ID + "playerstats.Button.OtherStats"),KNOWLEDGE_BOOK, isSelected,  (button) -> {
            MinecraftClient.getInstance().setScreen(new OtherStatsScreen(PlayerStatsScreen.getRequestedPlayer()));});
    }
}
