package de.lordfoxifly.Features.Raids;

import net.minecraft.village.raid.Raid;

public class RaidInstance {
    private  final RaidType raidType;
    private  final String raid;
    private RaidPhase raidPhase = RaidPhase.BEFORE;


    public RaidInstance(RaidType raidType, String raid){
        this.raidType = raidType;
        this.raid  = raid;
    }
}
