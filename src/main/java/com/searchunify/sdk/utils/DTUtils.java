/**
 * 
 */
package com.searchunify.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is @author ankur
 * This class is created at 14-Jun-2021
 */
public class DTUtils {

	/**
	 * This method is used to format a date to a desired format.
	 * 
	 * Parameters @param d
	 * Parameters @param format
	 * @return String
	 */
	public static String format(Date d, String format) {
		SimpleDateFormat sm = new SimpleDateFormat(format);
		String date = sm.format(d);
		return date;
	}
}
