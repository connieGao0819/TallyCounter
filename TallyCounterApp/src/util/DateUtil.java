package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;
	
	public static java.sql.Date utilToSql (java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}
	
	// Retrieve today's date, discard the hour, minute and second
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	//Retrieve the start of a month
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,  1);
		
		c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
        return c.getTime();
	}
	
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
		
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        
        return c.getTime();
	}
	
	public static int NumOfDaysOfThisMonth() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		
		return (int) ((lastDayMilliSeconds-firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}
	
	public static int LeftDaysOfThisMonth() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long todayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds-todayMilliSeconds) / millisecondsOfOneDay) +1;
	}
	
	public static void main(String[] args) {
        System.out.println(DateUtil.monthEnd());
     
    }
}
