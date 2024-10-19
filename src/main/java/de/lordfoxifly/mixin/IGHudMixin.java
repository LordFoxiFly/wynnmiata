package de.lordfoxifly.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;

import java.io.ObjectInputFilter;

@Mixin(InGameOverlayRenderer.class)
public class IGHudMixin {

    @WrapMethod(
            method =  "renderFireOverlay"
    )
    private static void renderFire(MinecraftClient client, MatrixStack matrices, Operation<Void> original){
        if (WynnMiata.CONFIG.isFireHudRenderingBoolean()) {
            return;
        }
        original.call(client, matrices);
    }


}
