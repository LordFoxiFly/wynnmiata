package de.lordfoxifly.Events;

import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.Features.Professions.ProfessionTracking;

public class DisplayTextUpdateListener {

    public static void  onDisplayUpdate(){
        DisplayTextUpdateEvent.EVENT.register( (content, pos) -> {
            //Devutils.appendToFile(content, "wynnmiatadevlog.txt");
            ProfessionTracking.updateProfProgress(content);
        });
    }

}
