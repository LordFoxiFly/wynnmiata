package de.lorfoxifly.Client;

import de.lorfoxifly.WynnMiata;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class Keybinds {


    private static final  Text CATAGORY = Text.translatable("key.category." + WynnMiata.MOD_ID );
    public static final KeyBinding Settings = new KeyBinding("key." + WynnMiata.MOD_ID + ".settings_key", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I, "key.category.wynnmiata" );


}
