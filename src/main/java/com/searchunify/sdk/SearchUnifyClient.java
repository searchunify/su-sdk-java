/**
 * 
 */
package com.searchunify.sdk;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.searchunify.sdk.clients.RequestManager;
import com.searchunify.sdk.constants.HttpMethod;
import com.searchunify.sdk.constants.Media;
import com.searchunify.sdk.constants.SearchUnifyConstant;
import com.searchunify.sdk.dtos.ArticlesAttachedToCasesRequest;
import com.searchunify.sdk.dtos.ArticlesAttachedToCasesResponse;
import com.searchunify.sdk.dtos.ArticlesCreatedCasesRequest;
import com.searchunify.sdk.dtos.ArticlesCreatedCasesResponse;
import com.searchunify.sdk.dtos.ArticlesDeflectedCaseRequest;
import com.searchunify.sdk.dtos.ArticlesDeflectedCaseResponse;
import com.searchunify.sdk.dtos.BulkUploadDocumentRequest;
import com.searchunify.sdk.dtos.BulkUploadDocumentResponse;
import com.searchunify.sdk.dtos.DiscussionsReadyToBecomeArticlesRequest;
import com.searchunify.sdk.dtos.DiscussionsReadyToBecomeArticlesResponse;
import com.searchunify.sdk.dtos.GenerateTokenRequest;
import com.searchunify.sdk.dtos.GenerateTokenResponse;
import com.searchunify.sdk.dtos.GetAllContentSourcesRequest;
import com.searchunify.sdk.dtos.GetAllContentSourcesResponse;
import com.searchunify.sdk.dtos.GetAllDocumentInContentSourceRequest;
import com.searchunify.sdk.dtos.GetAllDocumentInContentSourceResponse;
import com.searchunify.sdk.dtos.GetContentSourceByIdRequest;
import com.searchunify.sdk.dtos.GetContentSourceByIdResponse;
import com.searchunify.sdk.dtos.GetContentSourceObjectAndFieldsRequest;
import com.searchunify.sdk.dtos.GetContentSourceObjectAndFieldsResponse;
import com.searchunify.sdk.dtos.GetSearchConverionAllRequest;
import com.searchunify.sdk.dtos.GetSearchConverionAllResponse;
import com.searchunify.sdk.dtos.GetSearchConverionBySessionIdRequest;
import com.searchunify.sdk.dtos.GetSearchConverionBySessionIdResponse;
import com.searchunify.sdk.dtos.GetSearchConverionNotOnFirstPageRequest;
import com.searchunify.sdk.dtos.GetSearchConverionNotOnFirstPageResponse;
import com.searchunify.sdk.dtos.GetSearchConverionWithFilterRequest;
import com.searchunify.sdk.dtos.GetSearchConverionWithFilterResponse;
import com.searchunify.sdk.dtos.GetSearchQueryAllRequest;
import com.searchunify.sdk.dtos.GetSearchQueryAllResponse;
import com.searchunify.sdk.dtos.GetSearchQueryWithNoClicksRequest;
import com.searchunify.sdk.dtos.GetSearchQueryWithNoClicksResponse;
import com.searchunify.sdk.dtos.GetSearchQueryWithResultsRequest;
import com.searchunify.sdk.dtos.GetSearchQueryWithResultsResponse;
import com.searchunify.sdk.dtos.GetSearchQueryWithoutResultsRequest;
import com.searchunify.sdk.dtos.GetSearchQueryWithoutResultsResponse;
import com.searchunify.sdk.dtos.GetSearchSessionBySessionIdRequest;
import com.searchunify.sdk.dtos.GetSearchSessionBySessionIdResponse;
import com.searchunify.sdk.dtos.GetSearchSummaryChartRequest;
import com.searchunify.sdk.dtos.GetSearchSummaryChartResponse;
import com.searchunify.sdk.dtos.GetSearchesInAllSessionRequest;
import com.searchunify.sdk.dtos.GetSearchesInAllSessionResponse;
import com.searchunify.sdk.dtos.GetSearchesWithNoClicksRequest;
import com.searchunify.sdk.dtos.GetSearchesWithNoClicksResponse;
import com.searchunify.sdk.dtos.SearchQueryHistogramRequest;
import com.searchunify.sdk.dtos.SearchQueryHistogramResponse;
import com.searchunify.sdk.dtos.SearchQueryKcsSupportRequest;
import com.searchunify.sdk.dtos.SearchQueryKcsSupportResponse;
import com.searchunify.sdk.dtos.SearchQueryMissedHistogramRequest;
import com.searchunify.sdk.dtos.SearchQueryMissedHistogramResponse;
import com.searchunify.sdk.dtos.SearchRequest;
import com.searchunify.sdk.dtos.SearchResponse;
import com.searchunify.sdk.dtos.SearchSessionByCaseUidAuthRequest;
import com.searchunify.sdk.dtos.SearchSessionByCaseUidAuthResponse;
import com.searchunify.sdk.dtos.SearchSessionByCaseUidRequest;
import com.searchunify.sdk.dtos.SearchSessionByCaseUidResponse;
import com.searchunify.sdk.dtos.SearchUnifyRequest;
import com.searchunify.sdk.dtos.TileDataRequest;
import com.searchunify.sdk.dtos.TileDataResponse;
import com.searchunify.sdk.dtos.UpdateDocumentRequest;
import com.searchunify.sdk.dtos.UpdateDocumentResponse;
import com.searchunify.sdk.utils.JsonUtils;

import lombok.NonNull;

/**
 * @author ankur
 * @crated 19-Mar-2021
 */

public class SearchUnifyClient {

	private static final Logger logger = LogManager.getLogger(SearchUnifyClient.class);

	private String key;

	private String secret;

	private String baseContext;

	private String username;

	private String password;

	private String grantType;

	private String accessToken;

	private String refreshToken;

	private RequestManager requestManager;

	/**
	 * @param key
	 * @param secret
	 * @param baseContext
	 */
	public SearchUnifyClient(@NonNull String key, @NonNull String secret, @NonNull String baseContext,
			@NonNull String username, @NonNull String password, String grantType) {
		this.requestManager = new RequestManager();
		this.secret = secret;
		this.key = key;
		this.baseContext = baseContext;
		this.username = username;
		this.password = password;
		this.grantType = null != grantType ? grantType : "password";
		// TODO - Think better way to wrap like DI.
		GenerateTokenRequest request = GenerateTokenRequest.builder().build();
		GenerateTokenResponse tokRes = generateAccessToken(request);
		this.accessToken = tokRes.getAccessToken();
		this.refreshToken = tokRes.getRefreshToken();
		logger.info("Successfully generated access {} and refresh tokens {}", accessToken, refreshToken);
	}

	/**
	 * This method is used to append the authorization header in the request.
	 * 
	 * @param <R>
	 * @param request
	 * @return R
	 */
	private <R extends SearchUnifyRequest> R addAuthHeader(@NonNull R request) {
		// Set headers.
		Map<String, String> headers = request.getHeaders();
		if (null == headers) {
			headers = new HashMap<>();
		}
		headers.put(SearchUnifyConstant.AUTHORIZATION, "Bearer " + this.accessToken);
		request.setHeaders(headers);
		return request;
	}

	/**
	 * This method is used for get access token. Internally this sends the data as
	 * form URL encoded way.
	 * 
	 * @param request {@link GenerateTokenRequest}
	 * @return {@link GenerateTokenResponse}
	 */
	public GenerateTokenResponse generateAccessToken(@NonNull GenerateTokenRequest request) {
		String concat = this.key.trim() + ":" + this.secret.trim();
		String encoded = Base64.getEncoder().encodeToString(concat.getBytes());
		// byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		// String decodedString = new String(decodedBytes);
		// logger.debug("Base64 encode {} and decoded {}", encoded, decodedString);
		// Set headers.
		Map<String, String> headers = request.getHeaders();
		if (null == headers) {
			headers = new HashMap<>();
		}
		headers.put(SearchUnifyConstant.AUTHORIZATION, "Basic " + encoded);
		headers.put(SearchUnifyConstant.CONTENT_TYPE, Media.FORM_URLENCODED.toString());
		request.setHeaders(headers);
		// Set URL encoded body
		StringBuilder builder = new StringBuilder();
		builder.append("grant_type=" + this.grantType + "&");
		builder.append("username=" + this.username + "&");
		builder.append("password=" + this.password);
		// Set other properties
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.GENERATE_ACCESS_TOKEN);
		String result = requestManager.performRequest(baseContext + SearchUnifyConstant.GENERATE_ACCESS_TOKEN,
				HttpMethod.POST, headers, null, builder.toString());
		GenerateTokenResponse response = JsonUtils.jsonToObject(result, GenerateTokenResponse.class);
		return response;
	}

	/**
	 * This method is used to get the tile data from SearchUnify analytics.
	 * 
	 * @param {@link TileDataRequest}
	 * @return {@link TileDataResponse}
	 */
	public TileDataResponse getTileData(@NonNull TileDataRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.TILE_DATA);
		return requestManager.performRequest(request, TileDataResponse.class);
	};

	/**
	 * This method is used to get the search summary chart data from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link GetSearchSummaryChartRequest}
	 * @return {@link GetSearchSummaryChartResponse}
	 */
	public GetSearchSummaryChartResponse getSearchSummaryChart(@NonNull GetSearchSummaryChartRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_SUMMARY_CHART);
		return requestManager.performRequest(request, GetSearchSummaryChartResponse.class);
	};

	/**
	 * This method is used to get all search query report from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link GetSearchQueryAllRequest}
	 * @return {@link GetSearchQueryAllResponse}
	 */
	public GetSearchQueryAllResponse getSearchQueryAll(@NonNull GetSearchQueryAllRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_QUERY_ALL);
		return requestManager.performRequest(request, GetSearchQueryAllResponse.class);
	};

	/**
	 * This method is used to get all the search queries with results from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchQueryWithResultsRequest}
	 * @return {@link GetSearchQueryWithResultsResponse}
	 */
	public GetSearchQueryWithResultsResponse getSearchQueryWithResults(
			@NonNull GetSearchQueryWithResultsRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_QUERY_WITH_RESULTS);
		return requestManager.performRequest(request, GetSearchQueryWithResultsResponse.class);
	};

	/**
	 * This method is used to get all the search queries with no clicks from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchQueryWithNoClicksRequest}
	 * @return {@link GetSearchQueryWithResultsResponse}
	 */
	public GetSearchQueryWithNoClicksResponse getSearchQueryWithNoClicks(
			@NonNull GetSearchQueryWithNoClicksRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_QUERY_WITH_NO_CLICKS);
		return requestManager.performRequest(request, GetSearchQueryWithNoClicksResponse.class);
	};

	/**
	 * This method is used to get all the search queries without results from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchQueryWithoutResultsRequest}
	 * @return {@link GetSearchQueryWithoutResultsResponse}
	 */
	public GetSearchQueryWithoutResultsResponse getSearchQueryWithoutResults(
			@NonNull GetSearchQueryWithoutResultsRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_QUERY_WITHOUT_RESULTS);
		return requestManager.performRequest(request, GetSearchQueryWithoutResultsResponse.class);
	};

	/**
	 * This method is used to get the search query histogram from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link SearchQueryHistogramRequest}
	 * @return {@link SearchQueryHistogramResponse}
	 */
	public SearchQueryHistogramResponse searchQueryHistogram(@NonNull SearchQueryHistogramRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH_QUERY_HISTOGRAM);
		return requestManager.performRequest(request, SearchQueryHistogramResponse.class);
	};

	/**
	 * This method is used to get the search missed query histogram from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link SearchQueryMissedHistogramRequest}
	 * @return {@link SearchQueryMissedHistogramResponse}
	 */
	public SearchQueryMissedHistogramResponse searchQueryMissedHistogram(
			@NonNull SearchQueryMissedHistogramRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH_QUERY_HISTOGRAM);
		return requestManager.performRequest(request, SearchQueryMissedHistogramResponse.class);
	};

	/**
	 * This method is used to get the search session by the case uid from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link SearchSessionByCaseUidAuthRequest}
	 * @return {@link SearchSessionByCaseUidAuthResponse}
	 */
	public SearchSessionByCaseUidAuthResponse searchSessionByCaseUidAuth(
			@NonNull SearchSessionByCaseUidAuthRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH_QUERY_HISTOGRAM);
		return requestManager.performRequest(request, SearchSessionByCaseUidAuthResponse.class);
	};

	/**
	 * This method is used to get all the search conversions from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link GetSearchConverionAllRequest}
	 * @return {@link GetSearchConverionAllResponse}
	 */
	public GetSearchConverionAllResponse getSearchConverionAll(@NonNull GetSearchConverionAllRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_CONVERION_ALL);
		return requestManager.performRequest(request, GetSearchConverionAllResponse.class);
	};

	/**
	 * This method is used to get all the search conversions which are not on first
	 * page from SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchConverionNotOnFirstPageRequest}
	 * @return {@link GetSearchConverionNotOnFirstPageResponse}
	 */
	public GetSearchConverionNotOnFirstPageResponse getSearchConverionNotOnFirstPage(
			@NonNull GetSearchConverionNotOnFirstPageRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_CONVERION_NOT_ON_FIRST_PAGE);
		return requestManager.performRequest(request, GetSearchConverionNotOnFirstPageResponse.class);
	};

	/**
	 * This method is used to get all the search conversions with filters from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchConverionWithFilterRequest}
	 * @return {@link GetSearchConverionWithFilterResponse}
	 */
	public GetSearchConverionWithFilterResponse getSearchConverionWithFilter(
			@NonNull GetSearchConverionWithFilterRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCH_CONVERION_WITH_FILTER);
		return requestManager.performRequest(request, GetSearchConverionWithFilterResponse.class);
	};

	/**
	 * This method is used to get all the search conversions by session id from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchConverionBySessionIdRequest}
	 * @return {@link GetSearchConverionBySessionIdResponse}
	 */
	public GetSearchConverionBySessionIdResponse getSearchConverionBySessionId(
			@NonNull GetSearchConverionBySessionIdRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		// TODO - Remove sessionId from query parameters.
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		// Add sessionId as a path variable.
		String context = SearchUnifyConstant.GET_SEARCH_CONVERION_BY_SESSION_ID;
		// Replace all the path variables.
		context = context.replace("{id}", request.getSessionId()).trim();
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, GetSearchConverionBySessionIdResponse.class);
	};

	/**
	 * This method is used to get the search conversion discussion that are ready to
	 * become help articles from SearchUnify analytics.
	 * 
	 * @param request {@link DiscussionsReadyToBecomeArticlesRequest}
	 * @return {@link DiscussionsReadyToBecomeArticlesResponse}
	 */
	public DiscussionsReadyToBecomeArticlesResponse discussionsReadyToBecomeArticles(
			@NonNull DiscussionsReadyToBecomeArticlesRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.DISCUSSIONS_READY_TO_BECOME_ARTICLES);
		return requestManager.performRequest(request, DiscussionsReadyToBecomeArticlesResponse.class);
	};

	/**
	 * This method is used to get the search conversion articles that are created
	 * articles from SearchUnify analytics.
	 * 
	 * @param request {@link ArticlesCreatedCasesRequest}
	 * @return {@link ArticlesCreatedCasesResponse}
	 */
	public ArticlesCreatedCasesResponse articlesCreatedCases(@NonNull ArticlesCreatedCasesRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.ARTICLES_CREATED_CASES);
		return requestManager.performRequest(request, ArticlesCreatedCasesResponse.class);
	};

	/**
	 * This method is used to get the search conversion articles that deflected
	 * cases from SearchUnify analytics.
	 * 
	 * @param request {@link ArticlesDeflectedCaseRequest}
	 * @return {@link ArticlesDeflectedCaseResponse}
	 */
	public ArticlesDeflectedCaseResponse articlesDeflectedCase(@NonNull ArticlesDeflectedCaseRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.ARTICLES_DEFLECTED_CASE);
		return requestManager.performRequest(request, ArticlesDeflectedCaseResponse.class);
	};

	/**
	 * This method is used to get the search conversion articles that are attached
	 * to cases from SearchUnify analytics.
	 * 
	 * @param request {@link ArticlesAttachedToCasesRequest}
	 * @return {@link ArticlesAttachedToCasesResponse}
	 */
	public ArticlesAttachedToCasesResponse articlesAttachedToCases(@NonNull ArticlesAttachedToCasesRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.ARTICLES_ATTACHED_TO_CASES);
		return requestManager.performRequest(request, ArticlesAttachedToCasesResponse.class);
	};

	// TODO - Add POST conversion/attachedOnCase after verification.

	/**
	 * This method is used to get all the searches with no clicks from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link GetSearchesWithNoClicksRequest}
	 * @return {@link GetSearchesWithNoClicksResponse}
	 */
	public GetSearchesWithNoClicksResponse getSearchesWithNoClicks(@NonNull GetSearchesWithNoClicksRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCHES_WITH_NO_CLICKS);
		return requestManager.performRequest(request, GetSearchesWithNoClicksResponse.class);
	};

	/**
	 * This method is used to get the searches based on the search sessions from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchesInAllSessionRequest}
	 * @return {@link GetSearchesInAllSessionResponse}
	 */
	public GetSearchesInAllSessionResponse getSearchesInAllSession(@NonNull GetSearchesInAllSessionRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		request.setContext(baseContext + SearchUnifyConstant.GET_SEARCHES_IN_ALL_SESSION);
		return requestManager.performRequest(request, GetSearchesInAllSessionResponse.class);
	};

	/**
	 * This method is used to get all the search sessions by session id from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link GetSearchSessionBySessionIdRequest}
	 * @return {@link GetSearchSessionBySessionIdResponse}
	 */
	public GetSearchSessionBySessionIdResponse getSearchSessionBySessionId(
			@NonNull GetSearchSessionBySessionIdRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		// TODO - Remove sessionId from query parameters.
		Map<String, String> params = JsonUtils.convertPojoToMap(request);
		request.setParameters(params);
		// Add sessionId as a path variable.
		String context = SearchUnifyConstant.GET_SEARCH_SESSION_BY_SESSION_ID;
		// Replace all the path variables.
		context = context.replace("{id}", request.getSessionId()).trim();
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, GetSearchSessionBySessionIdResponse.class);
	};

	/**
	 * This method is used to get the searches that become KCS support from
	 * SearchUnify analytics.
	 * 
	 * @param request {@link SearchQueryKcsSupportRequest}
	 * @return {@link SearchQueryKcsSupportResponse}
	 */
	public SearchQueryKcsSupportResponse searchQueryKcsSupport(@NonNull SearchQueryKcsSupportRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH_QUERY_KCS_SUPPORT);
		return requestManager.performRequest(request, SearchQueryKcsSupportResponse.class);
	};

	/**
	 * This method is used to get the search sessions by case UID from SearchUnify
	 * analytics.
	 * 
	 * @param request {@link SearchSessionByCaseUidRequest}
	 * @return {@link SearchSessionByCaseUidResponse}
	 */
	public SearchSessionByCaseUidResponse searchSessionByCaseUid(@NonNull SearchSessionByCaseUidRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH_SESSION_BY_CASE_UID);
		return requestManager.performRequest(request, SearchSessionByCaseUidResponse.class);
	};

	/**
	 * This method is used to get the search results based on the queries.
	 * 
	 * @param request {@link SearchRequest}
	 * @return {@link SearchResponse}
	 */
	public SearchResponse search(@NonNull SearchRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		request.setContext(baseContext + SearchUnifyConstant.SEARCH);
		return requestManager.performRequest(request, SearchResponse.class);
	};

	// Content source API
	/**
	 * This method is used to get all the content sources.
	 * 
	 * @param request {@link GetAllContentSourcesRequest}
	 * @return {@link GetAllContentSourcesResponse}
	 */
	public GetAllContentSourcesResponse getAllContentSources(@NonNull GetAllContentSourcesRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		request.setContext(baseContext + SearchUnifyConstant.GET_ALL_CONTENT_SOURCES);
		return requestManager.performRequest(request, GetAllContentSourcesResponse.class);
	};

	/**
	 * This method is used to get the content source by id.
	 * 
	 * @param request {@link GetContentSourceByIdRequest}
	 * @return {@link GetContentSourceByIdResponse}
	 */
	public GetContentSourceByIdResponse getContentSourcesById(@NonNull GetContentSourceByIdRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		String context = SearchUnifyConstant.GET_CONTENT_SOURCES_BY_ID;
		context = context.replace("{id}", request.getId()).trim();
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, GetContentSourceByIdResponse.class);
	};

	/**
	 * This method is used to get the content source object and fields by id.
	 * 
	 * @param request {@link GetContentSourceObjectAndFieldsRequest}
	 * @return {@link GetContentSourceObjectAndFieldsResponse}
	 */
	public GetContentSourceObjectAndFieldsResponse getContentSourceObjectAndFields(
			@NonNull GetContentSourceObjectAndFieldsRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		String context = SearchUnifyConstant.GET_CONTENT_SOURCE_OBJECT_AND_FIELDS;
		context = context.replace("{id}", request.getId()).trim();
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, GetContentSourceObjectAndFieldsResponse.class);
	};

	/**
	 * This method is used to get the content source object and fields by id.
	 * 
	 * @param request {@link GetAllDocumentInContentSourceRequest}
	 * @return {@link GetAllDocumentInContentSourceResponse}
	 */
	public GetAllDocumentInContentSourceResponse getAllDocumentInContentSource(
			@NonNull GetAllDocumentInContentSourceRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.GET);
		String context = SearchUnifyConstant.GET_ALL_DOCUMENT_IN_CONTENT_SOURCE;
		// Replace all the path variables.
		context = context.replace("{contentSourceId}", request.getContentSourceId()).trim();
		context = context.replace("{objectId}", request.getObjectId()).trim();
		context = context.replace("{id}", request.getDocumentId()).trim();
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, GetAllDocumentInContentSourceResponse.class);
	};

	/**
	 * This method is used to update any content field or document property in your
	 * index. The changes are reflected in your index. This call does not alter data
	 * on your content source.
	 * 
	 * @param request {@link UpdateDocumentRequest}
	 * @return {@link UpdateDocumentResponse}
	 */
	public UpdateDocumentResponse updateDocument(@NonNull UpdateDocumentRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		String context = SearchUnifyConstant.UPDATE_DOCUMENT;
		// Replace all the path variables.
		context = context.replace("{contentSourceId}", request.getContentSourceId()).trim();
		context = context.replace("{objectId}", request.getObjectId()).trim();
		context = context.replace("{id}", request.getDocumentId()).trim();
		// TODO Check path variables and make them Null for request body.
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, UpdateDocumentResponse.class);
	};

	/**
	 * This method is used to add one or more documents to your search index.
	 * 
	 * @param request {@link BulkUploadDocumentRequest}
	 * @return {@link BulkUploadDocumentResponse}
	 */
	public BulkUploadDocumentResponse bulkUploadDocuments(@NonNull BulkUploadDocumentRequest request) {
		logger.debug("Base context is {}", baseContext);
		request = addAuthHeader(request);
		request.setMethod(HttpMethod.POST);
		String context = SearchUnifyConstant.BULK_UPLOAD_DOCUMENTS;
		// Replace all the path variables.
		context = context.replace("{contentSourceId}", request.getContentSourceId()).trim();
		context = context.replace("{objectId}", request.getObjectId()).trim();
		// TODO Check this with NonNull
		request.setContentSourceId(null);
		request.setObjectId(null);
		request.setContext(baseContext + context);
		return requestManager.performRequest(request, BulkUploadDocumentResponse.class);
	};
}
