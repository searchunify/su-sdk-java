/**
 * 
 */
package com.searchunify.sdk.clients;

import java.io.IOException;
import java.util.Map;

import com.searchunify.sdk.constants.HttpMethod;
import com.searchunify.sdk.constants.Media;
import com.searchunify.sdk.constants.SearchUnifyConstant;
import com.searchunify.sdk.dtos.SearchUnifyRequest;
import com.searchunify.sdk.dtos.SearchUnifyResponse;
import com.searchunify.sdk.exceptions.SearchUnifyException;
import com.searchunify.sdk.utils.JsonUtils;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * This class is @author ankur
 * This class is created at 19-Mar-2021
 */
public class RequestManager {

	private OkHttpClient httpClient;

	public RequestManager() {
		this.httpClient = new OkHttpClient();
	}

	/**
	 * This method is used to perform the rest request based on the parameters sent
	 * to it.
	 * 
	 * Parameters @param <R extends SearchUnifyRequest>
	 * Parameters @param T extends SearchUnifyResponse
	 * Parameters @param req
	 * Parameters @param clz
	 * 
	 * @return <T extends SearchUnifyResponse>
	 */
	public <R extends SearchUnifyRequest, T extends SearchUnifyResponse> T performRequest(R req, Class<T> clz) {
		Request request = buildRequest(req);
		T response = null;
		try {
			Response res = this.httpClient.newCall(request).execute();
			response = JsonUtils.jsonToObject(res.body().string(), clz);
		} catch (IOException ex) {
			try {
				response = clz.getDeclaredConstructor().newInstance();
				response.setStatus(false);
				response.setMessage(ex.getMessage());
			} catch (Exception e) {
				throw new SearchUnifyException("Error to map the response object.");
			}
		}
		return response;
	}

	/**
	 * This method is used to build the request body, headers and query parameters.
	 * 
	 * Parameters @param <R>
	 * Parameters @param req
	 * 
	 * @return {@link Request}
	 */
	private <R extends SearchUnifyRequest> Request buildRequest(R req) {
		Request.Builder requestBuilder = new Request.Builder();
		requestBuilder.url(this.constructUrl(req));
		this.addHeaders(requestBuilder, req);
		requestBuilder.method(req.getMethod().toString(), this.constructRequestBody(req));
		return requestBuilder.build();
	}

	/**
	 * This method is used to create the context.
	 * 
	 * Parameters @param <R>
	 * Parameters @param req
	 * 
	 * @return {@link HttpUrl}
	 */
	private <R extends SearchUnifyRequest> HttpUrl constructUrl(R req) {
		String url = req.getContext();

		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
		if (req.getParameters() != null) {
			for (Map.Entry<String, String> param : req.getParameters().entrySet()) {
				if (null != param.getValue()) {
					urlBuilder.addQueryParameter(param.getKey(), param.getValue());
				}
			}
		}
		return urlBuilder.build();
	}

	/**
	 * This method will parse the headers map and add it to the request.
	 * 
	 * Parameters @param <R>
	 * Parameters @param requestBuilder
	 * Parameters @param req
	 */
	private <R extends SearchUnifyRequest> void addHeaders(final Request.Builder requestBuilder, R req) {
		requestBuilder.addHeader("User-Agent", SearchUnifyConstant.SEARCHUNIFY_USER_AGENT);
		// if (this.auth != null) {
		// String accessToken = this.auth.getAccessToken();
		// if (accessToken != null) {
		// requestBuilder.addHeader("Authorization", "Bearer " + accessToken);
		// }
		// }
		if (req.getHeaders() != null) {
			for (Map.Entry<String, String> header : req.getHeaders().entrySet()) {
				requestBuilder.addHeader(header.getKey(), header.getValue());
			}
		}
	}

	/**
	 * This method is used to parse the request object to the JSON and map it with
	 * request body.
	 * 
	 * Parameters @param <R>
	 * Parameters @param req
	 * 
	 * @return {@link RequestBody}
	 */
	private <R extends SearchUnifyRequest> RequestBody constructRequestBody(R req) {
		RequestBody requestBody = null;
		if (null != req.getMethod() && (req.getMethod() == HttpMethod.POST || req.getMethod() == HttpMethod.PUT)) {
			String jsonString = null;
			// System.out.println(Runtime.getRuntime().freeMemory());
			jsonString = JsonUtils.toJsonString(req);

			requestBody = RequestBody.create(jsonString, SearchUnifyConstant.MEDIA_APPLICATION_JSON);
		}

		return requestBody;
	}

	/**
	 * This method is used to perform the rest request based on the parameters sent
	 * to it.
	 * 
	 * Parameters @param context
	 * Parameters @param method
	 * Parameters @param headers
	 * Parameters @param parameters
	 * Parameters @param body
	 * 
	 * @return {@link String}
	 */
	public String performRequest(String context, HttpMethod method, Map<String, String> headers, Map<String, String> parameters,
			Map<String, String> formData) {
		Request request = buildRequest(context, method, headers, parameters, formData);
		String response = null;
		try {
			Response res = this.httpClient.newCall(request).execute();
			response = res.body().string();
		} catch (IOException ex) {
			try {
				SearchUnifyResponse res = new SearchUnifyResponse();
				res.setStatus(false);
				res.setMessage(ex.getMessage());
				return JsonUtils.toJsonString(res);
			} catch (Exception e) {
				throw new SearchUnifyException("Error to map the response object.");
			}
		}
		return response;
	}

	/**
	 * This method is used to build the request body, headers and query parameters.
	 * 
	 * Parameters @param context
	 * Parameters @param method
	 * Parameters @param headers
	 * Parameters @param parameters
	 * Parameters @param body
	 * 
	 * @return {@link Request}
	 */
	private Request buildRequest(String context, HttpMethod method, Map<String, String> headers, Map<String, String> parameters,
			Map<String, String> body) {
		Request.Builder requestBuilder = new Request.Builder();
		requestBuilder.url(this.constructUrl(context, parameters));
		this.addHeaders(requestBuilder, headers);
		requestBuilder.method(method.toString(),
				constructRequestBody(method, body,
						null != headers && null != headers.get(SearchUnifyConstant.CONTENT_TYPE)
								? Media.fromValue(headers.get(SearchUnifyConstant.CONTENT_TYPE))
								: Media.JSON));
		return requestBuilder.build();
	}

	/**
	 * This method is used to create the context.
	 * 
	 * Parameters @param context
	 * Parameters @param parameters
	 * 
	 * @return {@link HttpUrl}
	 */
	private HttpUrl constructUrl(String context, Map<String, String> parameters) {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(context).newBuilder();
		if (parameters != null) {
			for (Map.Entry<String, String> param : parameters.entrySet()) {
				urlBuilder.addQueryParameter(param.getKey(), param.getValue());
			}
		}
		return urlBuilder.build();
	}

	/**
	 * This method will parse the headers map and add it to the request.
	 * 
	 * Parameters @param requestBuilder
	 * Parameters @param headers
	 */
	private void addHeaders(final Request.Builder requestBuilder, Map<String, String> headers) {
		requestBuilder.addHeader("User-Agent", SearchUnifyConstant.SEARCHUNIFY_USER_AGENT);
		// if (this.auth != null) {
		// String accessToken = this.auth.getAccessToken();
		// if (accessToken != null) {
		// requestBuilder.addHeader("Authorization", "Bearer " + accessToken);
		// }
		// }
		if (headers != null) {
			for (Map.Entry<String, String> header : headers.entrySet()) {
				requestBuilder.addHeader(header.getKey(), header.getValue());
			}
		}
	}

	/**
	 * This method is used to parse the request object to the JSON and map it with
	 * request body.
	 * 
	 * Parameters @param method
	 * Parameters @param body
	 * Parameters @param contentType
	 * 
	 * @return {@link RequestBody}
	 */
	private RequestBody constructRequestBody(HttpMethod method, Map<String, String> body, Media contentType) {
		RequestBody requestBody = null;
		if (null != method && (method == HttpMethod.POST || method == HttpMethod.PUT)) {
			if (contentType.equals(Media.FORM_URLENCODED)) {
				Builder formBuilder = new FormBody.Builder();
				for (Map.Entry<String, String> entry : body.entrySet()) {
					formBuilder.add(entry.getKey(), entry.getValue());
				}
				// requestBody = FormBody.create(body, SearchUnifyConstant.MEDIA_FORM_URLENCODED);
				requestBody = formBuilder.build();
			} else {
				// JsonUtils.isValidJSON(body);
				requestBody = RequestBody.create(JsonUtils.toJsonString(body), SearchUnifyConstant.MEDIA_APPLICATION_JSON);
			}
		}
		return requestBody;

	}

}
