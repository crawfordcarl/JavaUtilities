package product.and.packing.plan;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author carke
 */
public class useCalendar {
    
    static int[] current_date;
    
    public static void main(String[] args) {
        
        current_date = new int[3];
        
        // get an instance of the Calendar class and set it to todays date
        java.util.Date date = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        // get integers representing the year, month and date for the current date
        int cur_month = cal.get(Calendar.MONTH);
        current_date[0] = cal.get(Calendar.YEAR);
        current_date[1] = cal.get(Calendar.MONTH);
        current_date[2] = cal.get(Calendar.DAY_OF_MONTH);
        
        // get the list of weeks in a month for the current year, dated from the Monday
        ArrayList<String> mondays = getWeekList(current_date[1]);
        
        // get the suffix for the day of the month (st, nd, rd, or th)
        String s = current_date[2] + getDayOfMonthSuffix(current_date[2]);
        
    }
    
    
    static ArrayList<String> getWeekList(int selected_month) {
        
        
        /* a list of mondays for a given month, i.e. May 5th */
        Calendar cal = Calendar.getInstance();
        int mon = 1;
        cal.set(current_date[0], selected_month, mon); //first of the selected month of current year
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        switch (dow) {
            case 1: mon += 1;
                break;
            case 2: break;
            case 3: mon += 6;
                break;
            case 4: mon += 5;
                break;
            case 5: mon += 4;
                break;
            case 6: mon += 3;
                break;
            case 7: mon += 2;
                break;
        }
        
        int daysinmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[] dates = new int[5]; //maximum 5 mondays

        int wk = 0;
        while (mon <= daysinmonth) {
            dates[wk] = mon;
            mon += 7;
            wk++;
        }

        ArrayList<String> weekDates = new ArrayList<String>();
        for (int i = 0; i < dates.length; i++) {
            if(dates[i] == 0) { break; };
            weekDates.add("Monday " + dates[i] + getDayOfMonthSuffix(dates[i]));
        }
        
        return weekDates;
    }
    
    static String getDayOfMonthSuffix(int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
    
    
}
