/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.FDP;


public class testTimeStamp {
    
    public static void main (String[] args) {
        System.out.println(FDP.getTimeStamp());
    }
    
    public static String getTimeStamp() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hmmssa");
        String formattedDate = sdf.format(date);

        return formattedDate;
    }

}
