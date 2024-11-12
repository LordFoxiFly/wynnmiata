package de.lordfoxifly.Events;

import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.Features.Professions.ProfessionTracking;

public class DisplayTextUpdateListener {

    public static void  onDisplayUpdate(){
        //Devutils.appendToFile(content, "wynnmiatadevlog.txt");
        DisplayTextUpdateEvent.EVENT.register(ProfessionTracking::updateProfProgress);
    }

}
