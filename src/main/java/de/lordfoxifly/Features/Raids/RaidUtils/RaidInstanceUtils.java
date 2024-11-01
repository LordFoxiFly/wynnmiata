package de.lordfoxifly.Features.Raids.RaidUtils;

import de.lordfoxifly.Features.Raids.RaidPhase;
import de.lordfoxifly.Features.Raids.types.RaidTypes;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.render.Types.Box;
import de.lordfoxifly.render.WorldRender;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class RaidInstanceUtils {
    private static int tick = 0;
    private  static final BlockPos lava5 = new BlockPos(11645, 17, 3068);
    private  static final BlockPos lava4 = new BlockPos(11654, 20, 3075);
    private  static final BlockPos lava3 = new BlockPos(11667, 20, 3084);
    private  static final BlockPos lava2 = new BlockPos(11676, 20, 3086);
    private  static final BlockPos lava1 = new BlockPos(11685, 19, 3073);
    private static final Box lava5box = new Box(new Vec3d(11645, 16, 3068), new Vec3d(11646, 40, 3069), WynnMiata.CONFIG.getHighlightLavaColor(), false);
    private static final Box lava4box = new Box(new Vec3d(11654, 19, 3075), new Vec3d(11655, 40, 3076), WynnMiata.CONFIG.getHighlightLavaColor(), false );
    private static final Box lava3box = new Box(new Vec3d(11667, 19, 3084), new Vec3d(11668, 40, 3085) , WynnMiata.CONFIG.getHighlightLavaColor(),false);
    private static final Box lava2box = new Box(new Vec3d(11676, 19, 3086), new Vec3d(11677, 40, 3087) , WynnMiata.CONFIG.getHighlightLavaColor() ,false);
    private static final Box lava1box = new Box(new Vec3d(11685, 17, 3073), new Vec3d(11686, 40, 3074), WynnMiata.CONFIG.getHighlightLavaColor(),  false);

    public static void loadRaidFeatures(){

        if (WynnMiata.raidInstance != null){
            if (WynnMiata.raidInstance.getRaidType().getRaidTypes().equals(RaidTypes.TCC)) loadTCCFeatures();
        }
    }

    public static void loadTCCFeatures(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (WynnMiata.raidInstance != null){
                if (WynnMiata.CONFIG.isHighLightLavaBoolean() && WynnMiata.raidInstance.getRaidPhase().equals(RaidPhase.FIRSTROOM_TYPE_ONE)) {
                    if (tick >= 5) {
                        HighlightLava();
                        tick = 0;
                    } else {
                        tick++;
                    }
                }
            }
        });
    }

    public static void HighlightLava(){
        if (BlockUpdater.isBlockUpdated(lava1, Blocks.OBSIDIAN)) {
            WorldRender.addRenderable(lava1box);
        }
        else {
            WorldRender.removeRenderable(lava1box);}
        if (BlockUpdater.isBlockUpdated(lava2, Blocks.OBSIDIAN)) {
           WorldRender.addRenderable(lava2box);
        }
        else {
            WorldRender.removeRenderable(lava2box);        }
        if (BlockUpdater.isBlockUpdated(lava3, Blocks.OBSIDIAN)) {
            WorldRender.addRenderable(lava3box);
        }
        else {
            WorldRender.removeRenderable(lava3box);
        }
        if (BlockUpdater.isBlockUpdated(lava4, Blocks.OBSIDIAN)) {
            WorldRender.addRenderable(lava4box);
        }
        else {
            WorldRender.removeRenderable(lava4box);
        }
        if (BlockUpdater.isBlockUpdated(lava5, Blocks.OBSIDIAN)) {
            WorldRender.addRenderable(lava5box);
        }
        else {
            WorldRender.removeRenderable(lava5box);
        }

    }

    public static RaidTypes getRaidPType(String content){
        RaidTypes raidTypes = null;

        if (content.contains("The Canyon Colossus")){
            raidTypes = RaidTypes.TCC;
        }
        if (content.contains("Orphion's Nexus of Light")){
            raidTypes = RaidTypes.NOL;
        }
        if (content.contains("Nest of the Grootslangs")){
            raidTypes = RaidTypes.NOG;
        }
        if (content.contains("The Nameless Anomaly")){
            raidTypes = RaidTypes.TNA;
        }
        /*
        switch (content){
            case con -> raidTypes = RaidTypes.TCC;
            case null, default -> {
                raidTypes = null;
            }
        }
         */
        return  raidTypes;
    }

    public static RaidPhase getRaidPhaseTCC(String content, int phase) {
        String phaseString = Formatting.strip(content);
        RaidPhase raidPhase = null;
        switch (phaseString) {
            case "Prepare to raid..." -> raidPhase = RaidPhase.BEFORE;
            case "flows to raise" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_ONE;
            case "Hold the Upper and" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_TWO;
            case "Choose a buff or go" -> {
                switch (phase) {
                    case 1 -> raidPhase = RaidPhase.FIRSTBUFFS;
                    case 2 -> raidPhase = RaidPhase.SECONDBUFFS;
                    case 3 -> raidPhase = RaidPhase.THIRDBUFFS;
                }
            }
            case "Unknown" -> raidPhase = RaidPhase.SECONDROOM_TYPE_ONE;
            case "maze's exit." -> raidPhase = RaidPhase.SECONDROOM_TYPE_TWO;
            case "Activate 4 Binding" -> raidPhase = RaidPhase.THIRDROOM_TYPE_ONE;
            case "Great Protector." -> raidPhase = RaidPhase.BOSS;
            case "Too many players have", "Failed to Protect" -> raidPhase = RaidPhase.FAILED;
            case null, default -> raidPhase =  null;
        }
        return raidPhase;
    }
    public static RaidPhase getRaidPhaseNOG(String content, int phase) {
        String phaseString = Formatting.strip(content);
        RaidPhase raidPhase = null;
        switch (phaseString) {
            case "Prepare to raid..." -> raidPhase = RaidPhase.BEFORE;
            case "Hold the platform" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_ONE;
            case "Hold and defend" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_TWO;
            case "Choose a buff or go" -> {
                switch (phase) {
                    case 1 -> raidPhase = RaidPhase.FIRSTBUFFS;
                    case 2 -> raidPhase = RaidPhase.SECONDBUFFS;
                    case 3 -> raidPhase = RaidPhase.THIRDBUFFS;
                }
            }
            case "to construct the" -> raidPhase = RaidPhase.SECONDROOM_TYPE_ONE;
            case "Slay minibosses to" -> raidPhase = RaidPhase.THIRDROOM_TYPE_ONE;
            case "Heavy Hammer." -> raidPhase = RaidPhase.THIRDROOM_TYPE_TWO;
            case "Devourer." -> raidPhase = RaidPhase.BOSS;
            case "Too many players have" -> raidPhase = RaidPhase.FAILED;
            case null, default -> raidPhase =  null;
        }
        return raidPhase;
    }
    public static RaidPhase getRaidPhaseNOL(String content, int phase) {
        String phaseString = Formatting.strip(content);
        RaidPhase raidPhase = null;
        switch (phaseString) {
            case "Prepare to raid..." -> raidPhase = RaidPhase.BEFORE;
            case "Hold the tower" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_ONE;
            case "Choose a buff or go" -> {
                switch (phase) {
                    case 1 -> raidPhase = RaidPhase.FIRSTBUFFS;
                    case 2 -> raidPhase = RaidPhase.SECONDBUFFS;
                    case 3 -> raidPhase = RaidPhase.THIRDBUFFS;
                }
            }
            case "Kill all Crystalline" -> raidPhase = RaidPhase.SECONDROOM_TYPE_ONE;
            case "Collect 10 Light" -> raidPhase = RaidPhase.SECONDROOM_TYPE_TWO;
            case "Escort your party to" -> raidPhase = RaidPhase.THIRDROOM_TYPE_ONE;
            case "Guide the Crystal" -> raidPhase = RaidPhase.THIRDROOM_TYPE_TWO;
            case "Save him." -> raidPhase = RaidPhase.BOSS;
            case "Too many players have" -> raidPhase = RaidPhase.FAILED;
            case null, default -> raidPhase =  null;
        }
        return raidPhase;
    }
    public static RaidPhase getRaidPhaseTNA(String content, int phase) {
        String phaseString = Formatting.strip(content);
        RaidPhase raidPhase = null;
        switch (phaseString) {
            case "Prepare to raid..." -> raidPhase = RaidPhase.BEFORE;
            case "Hold the stump for" -> raidPhase = RaidPhase.FIRSTROOM_TYPE_ONE;
            case "the Berserker Berry." -> raidPhase = RaidPhase.FIRSTROOM_TYPE_TWO;
            case "Choose a buff or go" -> {
                switch (phase) {
                    case 1 -> raidPhase = RaidPhase.FIRSTBUFFS;
                    case 2 -> raidPhase = RaidPhase.SECONDBUFFS;
                    case 3 -> raidPhase = RaidPhase.THIRDBUFFS;
                }
            }
            case "tree." -> raidPhase = RaidPhase.SECONDROOM_TYPE_ONE;
            case "Collect 10 Light" -> raidPhase = RaidPhase.SECONDROOM_TYPE_TWO;
            case "Find and kill" -> raidPhase = RaidPhase.THIRDROOM_TYPE_ONE;
            case "Protect the Bulb" -> raidPhase = RaidPhase.THIRDROOM_TYPE_TWO;
            case "Survive." -> raidPhase = RaidPhase.BOSS;
            case "Too many players have" -> raidPhase = RaidPhase.FAILED;
            case null, default -> raidPhase =  null;
        }
        return raidPhase;
    }
    public static Integer getRaidChallange(RaidPhase raidPhase){
        int output = 7;
        switch (raidPhase) {
            case BEFORE, Que -> output = 0;
            case FIRSTBUFFS, FIRSTROOM_TYPE_ONE, FIRSTROOM_TYPE_TWO -> output = 1;
            case SECONDROOM_TYPE_TWO, SECONDBUFFS, SECONDROOM_TYPE_ONE -> output =  2;
            case THIRDBUFFS, THIRDROOM_TYPE_ONE, THIRDROOM_TYPE_TWO -> output = 3;
            case BOSS, Over -> output = 4;
            case null, default -> output = 7;
        }
        return  output;
    }
}
