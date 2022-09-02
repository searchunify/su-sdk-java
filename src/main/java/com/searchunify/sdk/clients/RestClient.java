/**
 * 
 */
package com.searchunify.sdk.clients;

import java.util.Map;

import com.searchunify.sdk.constants.HttpMethod;

/**
 * This class is @author ankur This class is created at 19-Mar-2021
 */
public class RestClient {

	/**
	 * This method is used to send get request.
	 * 
	 * Parameters @param context Parameters @param headers Parameters @param
	 * parameters
	 * 
	 * @return {@link String}
	 */
	public static String get(String context, Map<String, String> headers, Map<String, String> parameters) {
		RequestManager manager = new RequestManager();
		String response = manager.performRequest(context, HttpMethod.GET, headers, parameters, null);
		return response;

	}

	/**
	 * This method is used to send post request.
	 * 
	 * Parameters @param context Parameters @param body Parameters @param headers
	 * Parameters @param parameters
	 * 
	 * @return {@link String}
	 */
	public static String post(String context, String body, Map<String, String> headers,
			Map<String, String> parameters) {
		RequestManager manager = new RequestManager();
		String response = manager.performRequest(context, HttpMethod.POST, headers, parameters, body);
		return response;

	}

	/**
	 * This method is used to send put request.
	 * 
	 * Parameters @param context Parameters @param body Parameters @param headers
	 * Parameters @param parameters
	 * 
	 * @return {@link String}
	 */
	public static String put(String context, String body, Map<String, String> headers, Map<String, String> parameters) {
		RequestManager manager = new RequestManager();
		String response = manager.performRequest(context, HttpMethod.PUT, headers, parameters, body);
		return response;

	}

	/**
	 * This method is used to send delete request.
	 * 
	 * Parameters @param context Parameters @param body Parameters @param headers
	 * Parameters @param parameters
	 * 
	 * @return {@link String}
	 */
	public static String delete(String context, String body, Map<String, String> headers,
			Map<String, String> parameters) {
		RequestManager manager = new RequestManager();
		String response = manager.performRequest(context, HttpMethod.DELETE, headers, parameters, body);
		return response;

	}

}
