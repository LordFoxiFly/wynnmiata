package de.lordfoxifly.mixin;

import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.Events.ScoreboardUpdateEvent;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardScore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(Scoreboard.class)
public class ScoreBoardMixin {

    /*
    @Inject(

            method = "getKnownScoreHolders",
            at = @At("RETURN")

    )
    public void getNameFromScoreboard(CallbackInfoReturnable<Collection<ScoreHolder>> cir){
        ScoreboardUpdateEvent.EVENT.invoker().update(cir.getReturnValue().stream().toList());
        Devutils.appendToFile("Event Triggered");
    }
    */
    @Inject(
            method = "updateScore",
            at = @At("HEAD")
    )
    public void updateScore(ScoreHolder scoreHolder, ScoreboardObjective objective, ScoreboardScore score, CallbackInfo ci){
        ScoreboardUpdateEvent.EVENT.invoker().update(scoreHolder.getNameForScoreboard());
        Devutils.appendToFile("Event Triggered");
    }
}
