package de.lordfoxifly.WynnMiataUtils;

import java.util.ArrayList;

public class WynnMiataUtils {


    public static Boolean isNumeric(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    /**
     * Returns True if every Integer is Between begin & end in the List
     * @param list
     * @param begin
     * @param end
     * @return
     */
    public static Boolean isBetween(ArrayList<Integer> list, int begin , int end){
        if (list.isEmpty()){
            return  false;
        }
        boolean output = true;
        for(int i = 0; i<=list.size() -1 ; i++){
            if (list.get(i) >= begin && list.get(i) <= end){
                output = true;
            }
            else{
                output = false;
            }
        }
        return output;
    }

    public static String getUnformattedString(String string) {
        if (string == null){
            return null;
        }
        return string.replace( "§.", "");
    }
}
