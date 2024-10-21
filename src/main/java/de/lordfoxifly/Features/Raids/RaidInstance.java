package de.lordfoxifly.Features.Raids;

import de.lordfoxifly.Features.Raids.RaidUtils.RaidInstanceUtils;

public class RaidInstance {
    private  final RaidType raidType;

    public RaidType getRaidType() {
        return raidType;
    }

    public RaidPhase getRaidPhase() {
        return raidPhase;
    }

    private RaidPhase raidPhase = RaidPhase.Que;

    public Integer getRaidChallange() {
        return raidChallange;
    }

    public void setRaidChallange(Integer raidChallange) {
        this.raidChallange = raidChallange;
    }

    private Integer raidChallange = 0;

    public boolean isRaidCompleted() {
        return raidCompleted;
    }

    public void setRaidCompleted(boolean raidCompleted) {
        this.raidCompleted = raidCompleted;
    }

    private boolean raidCompleted = false;


    public RaidInstance(RaidType raidType){
        this.raidType = raidType;
    }

    public void setRaidPhase(RaidPhase raidPhase) {
        this.raidPhase = raidPhase;
    }

    public static RaidInstance createInstance(RaidType raidType){
        RaidInstance raidInstance = new RaidInstance(raidType);
        //RaidInstanceUtils.loadRaidFeatures(raidInstance);
        return raidInstance;
    }

    public RaidInstance deleteInstance(){
        return null;
    }
}
