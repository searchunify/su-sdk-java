/**
 * 
 */
package com.searchunify.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ankur
 * @crated 14-Jun-2021
 */
public class DTUtils {

	/**
	 * This method is used to format a date to a desired format.
	 * 
	 * @param d
	 * @param format
	 * @return String
	 */
	public static String format(Date d, String format) {
		SimpleDateFormat sm = new SimpleDateFormat(format);
		String date = sm.format(d);
		return date;
	}
}
