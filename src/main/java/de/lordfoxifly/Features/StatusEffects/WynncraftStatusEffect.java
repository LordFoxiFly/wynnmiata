package de.lordfoxifly.Features.StatusEffects;

public  class WynncraftStatusEffect {

    public boolean isPerc() {
        return perc;
    }

    public int getEffect() {
        return effect;
    }

    private final boolean perc;

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public WynncraftStatusEffectTypes getEffectTyp() {
        return effectTyp;
    }
    private int duration;
    private final int effect;
    private final WynncraftStatusEffectTypes effectTyp;

    public WynncraftStatusEffect(int duration,int effect, WynncraftStatusEffectTypes effecttype, boolean perc){
        this.duration = duration;
        this.effectTyp = effecttype;
        this.effect = effect;
        this.perc = perc;
    }
}
