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
		return c.getTime();
	}
	
	//Retrieve the start of a month
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
	}
}
