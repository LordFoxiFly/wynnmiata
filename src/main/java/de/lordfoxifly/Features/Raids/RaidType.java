package de.lordfoxifly.Features.Raids;

import de.lordfoxifly.Features.Raids.types.RaidTypes;
import net.minecraft.client.MinecraftClient;

public class RaidType {
    public RaidTypes getEnumRaidType() {
        return EnumRaidType;
    }

    private final RaidTypes EnumRaidType;
    public RaidType(RaidTypes raidType){
        this.EnumRaidType = raidType;
    }

    public  RaidType getRaidTypes () {
        return  getRaidTypes();
    }

}
