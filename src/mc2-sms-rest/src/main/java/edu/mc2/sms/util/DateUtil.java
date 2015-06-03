package edu.mc2.sms.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Calendar getDateOnlyCalendar() {
		Calendar cal = Calendar.getInstance();
		trimTime(cal);
		return cal;
	}
	
	public static Calendar getDateOnlyCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		trimTime(cal);
		return cal;
	}
	
	public static void trimTime(Calendar cal){
		 cal.set(Calendar.HOUR_OF_DAY, 0);
	     cal.set(Calendar.MINUTE, 0);
	     cal.set(Calendar.SECOND, 0);
	     cal.set(Calendar.MILLISECOND, 0);
	}
	
	
	public static Date getDate() {
        Calendar cal = getDateOnlyCalendar();
        return cal.getTime();
    }
	
	public static Date getNextDate() {
		Calendar cal = getDateOnlyCalendar();
		cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
	
	
	public static Date getDate(Date date) {
		 Calendar cal = getDateOnlyCalendar(date);
	     return cal.getTime();
    }
	
	public static Date getNextDate(Date date) {
		Calendar cal = getDateOnlyCalendar(date);
		cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
	
}
