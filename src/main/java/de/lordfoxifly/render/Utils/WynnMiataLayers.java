package de.lordfoxifly.render.Utils;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;

public class WynnMiataLayers {

    private static final RenderPhase.Transparency DEFAULT_TRANSPARENCY = new RenderPhase.Transparency("default_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
    }, RenderSystem::disableBlend);

    public static final RenderLayer.MultiPhase FILLED =  RenderLayer.of("filled", VertexFormats.POSITION_COLOR, VertexFormat.DrawMode.TRIANGLE_STRIP, RenderLayer.CUTOUT_BUFFER_SIZE,
            false, true, RenderLayer.MultiPhaseParameters.builder()
                    .program(RenderPhase.COLOR_PROGRAM)
                    .cull(RenderPhase.Cull.DISABLE_CULLING)
                    .layering(RenderPhase.POLYGON_OFFSET_LAYERING)
                    .transparency(DEFAULT_TRANSPARENCY)
                    .depthTest(RenderPhase.DepthTest.LEQUAL_DEPTH_TEST)
                    .build(false));

}
