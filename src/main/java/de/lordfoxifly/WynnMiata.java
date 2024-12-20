package de.lordfoxifly;

import com.mojang.brigadier.arguments.StringArgumentType;
import de.lordfoxifly.Api.CharacterDataAPI.CharacterDataUtils;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListUtils;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Client.Config.WynnMiataConfigData;
import de.lordfoxifly.Client.Keybinds;
import de.lordfoxifly.Commands.PlayerStatsCommand;
import de.lordfoxifly.Debug.DebugCommands;
import de.lordfoxifly.Debug.DevUtilsListeners;
import de.lordfoxifly.Events.WynnMiataEventLoader;
import de.lordfoxifly.Features.Raids.RaidInstance;
import de.lordfoxifly.Screens.PlayerStatsScreen;
import de.lordfoxifly.Screens.SettingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class WynnMiata implements ClientModInitializer {
	public static final String MOD_ID = "wynnmiata";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Player ClientPlayer;

	public static WynnMiataConfigData CONFIG;
	public static RaidInstance raidInstance;


	@Override
	public void onInitializeClient() {
        try {
           	ClientPlayer = setClientPlayer();
			//MinecraftClient.getInstance().getSession().getUsername()));
        } catch (URISyntaxException | IOException | InterruptedException e) {
			LOGGER.error(e.toString());
            throw new RuntimeException(e);
        }
        KeyBindingHelper.registerKeyBinding(Keybinds.Settings);
		KeyBindingHelper.registerKeyBinding(Keybinds.Player_PreView);
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(ClientCommandManager.literal("playerstats")
							.then(ClientCommandManager.argument("raid", StringArgumentType.string())
									.executes(PlayerStatsCommand::GetPlayerRaidStats)
									.then(ClientCommandManager.argument("playername", StringArgumentType.string())
											.executes(PlayerStatsCommand::GetPlayerRaidStats))));
		});
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(ClientCommandManager.literal("debug")
					.executes(DebugCommands::getScoreBoardString)
			);
		});
		CONFIG = WynnMiataConfig.loadConfigData();
		CONFIG.setRenderHudElements(true);


		WynnMiataEventLoader.load();
		DevUtilsListeners.load();


		//WorldRender.addRenderable(new Box(new Vec3d(1, 60, 0), new Vec3d(2, 65, 1), ColorUtils.hexStringToRed(WynnMiata.CONFIG.getHighLightLavaColor()), ColorUtils.hexStringToGreen(WynnMiata.CONFIG.getHighLightLavaColor()) , ColorUtils.hexStringToBlue(WynnMiata.CONFIG.getHighLightLavaColor()) ,255));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (Keybinds.Settings.isPressed()){
				client.setScreen(new SettingScreen());
			}
			while (Keybinds.Player_PreView.isPressed()){
				client.setScreen(new PlayerStatsScreen(null));
			}

		});
	}

	public Player setClientPlayer() throws URISyntaxException, IOException, InterruptedException {
		Player player = PlayerAPIHelper.getPlayer(RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/" + MinecraftClient.getInstance().getSession().getUuidOrNull()));
		if (player.getGlobalData() == null){
			return  null;
		}
		String  charactersrc = RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/" + MinecraftClient.getInstance().getSession().getUsername() +  "/characters");
		if (CharacterListUtils.getCharacterMap(charactersrc).isEmpty() || CharacterListUtils.getCharacterMap(charactersrc) == null){
			return null;
		}
		Map<String,CharacterListData> data = CharacterListUtils.getCharacterMap(charactersrc);
		player.setCharacters(data);
		player.setCharacterData(CharacterDataUtils.getCharacterDataFromCharacterUUIDList(CharacterListUtils.getCharacterUUID(data), MinecraftClient.getInstance().getSession().getUsername(), player.isPublicProfile()));
		player.setActiveCharacterData(CharacterDataUtils.getActiveCharacter(player));
		player.setSelectedCharacterData(player.getActiveCharacterData());
		player.setSelectedCharacterUUID(player.getActiveCharacter());
		return player;
	}
}