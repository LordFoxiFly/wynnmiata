package de.lorfoxifly.mixin;

import com.mojang.datafixers.types.templates.Check;
import de.lorfoxifly.Screens.Widgets.CheckBoxs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class IGHudMixin {

    @Inject(
            at = @At("HEAD"),
            method = "renderOverlay",
            cancellable = true
    )
    public void renderFire(DrawContext context, Identifier texture, float opacity, CallbackInfo ci){
        if (CheckBoxs.isFireHudRenderingBoolean() ){
            ci.cancel();
            //TODO Fix me
        }
    }


}
