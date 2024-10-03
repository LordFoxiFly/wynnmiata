package de.lorfoxifly;

import de.lorfoxifly.Client.Keybinds;
import de.lorfoxifly.Screens.SettingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;

public class WynnMiata implements ClientModInitializer {
	public static final String MOD_ID = "wynnmiata";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello Fabric world!");
		KeyBindingHelper.registerKeyBinding(Keybinds.Settings);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (Keybinds.Settings.isPressed()){
				client.setScreen(new SettingScreen());
			}
		});
	}
}