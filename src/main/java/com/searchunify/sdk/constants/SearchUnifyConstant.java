/**
 * 
 */
package com.searchunify.sdk.constants;

import okhttp3.MediaType;

/**
 * This class is @author ankur
 * This class is created at 23-Mar-2021
 */
public class SearchUnifyConstant {

	public static final String SEARCHUNIFY_USER_AGENT = "searchunify-java/v-1.0";

	// Media Types
	public static final MediaType MEDIA_APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

	public static final MediaType MEDIA_FORM_URLENCODED = MediaType
			.parse("application/x-www-form-urlencoded; charset=utf-8");

	// Headers
	public static final String CONTENT_TYPE = "Content-Type";

	public static final String AUTHORIZATION = "Authorization";

	public static final String TEST_SEGMENT = "/api/users";

	public static final String TEST_REGISTER_SEGMENT = "/api/register";

	// Actual SearchUnify API's
	public static final String GENERATE_ACCESS_TOKEN = "/oauth/token";

	public static final String TILE_DATA = "/api/v2/searchOverview/getTileData";

	public static final String GET_SEARCH_SUMMARY_CHART = "/api/v2/searchOverview/getSearchSummaryChart";

	public static final String GET_SEARCH_QUERY_ALL = "/api/v2/searchQuery/all";

	public static final String GET_SEARCH_QUERY_WITH_RESULTS = "/api/v2/searchQuery/withResults";

	public static final String GET_SEARCH_QUERY_WITH_NO_CLICKS = "/api/v2/searchQuery/withNoClicks";

	public static final String GET_SEARCH_QUERY_WITHOUT_RESULTS = "/api/v2/searchQuery/withoutResults";

	public static final String SEARCH_QUERY_HISTOGRAM = "/api/v2/searchQuery/histogram";

	public static final String SEARCH_QUERY_MISSED_HISTOGRAM = "/api/v2/searchQuery/missedQueryHistogram";

	public static final String GET_SEARCH_CONVERION_ALL = "/api/v2/searchQuery/missedQueryHistogram";

	public static final String GET_SEARCH_CONVERION_NOT_ON_FIRST_PAGE = "/api/v2/searchConversion/notOnFirstPage";

	public static final String GET_SEARCH_CONVERION_WITH_FILTER = "/api/v2/searchConversion/withFilters";

	public static final String GET_SEARCH_CONVERION_BY_SESSION_ID = "/api/v2/searchConversion/bySessionsId/{id}";

	public static final String DISCUSSIONS_READY_TO_BECOME_ARTICLES ="/api/v2/searchConversion/DiscussionsReadyToBecomeArticles";
	
	//public static final String DISCUSSIONS_READY_TO_BECOME_ARTICLES = "/api/v2/searchConversion/discussionsreadytobecomearticles";

	// TODO - Duplicate.
	public static final String ARTICLES_CREATED_CASES = "/api/v2/conversion/articlesCreatedCases";

	public static final String ARTICLES_DEFLECTED_CASE = "/api/v2/conversion/articlesDeflectedCase";

	public static final String ARTICLES_ATTACHED_TO_CASES = "/api/v2/conversion/articlesCreatedCases";

	public static final String GET_SEARCHES_WITH_NO_CLICKS = "/api/v2/searchQuery/withNoClicks";

	public static final String GET_SEARCHES_IN_ALL_SESSION = "/api/v2/searchSession/all/searchQuery";

	public static final String GET_SEARCH_SESSION_BY_SESSION_ID = "/api/v2/searchSession/bySearchSessionId/{id}";

	public static final String SEARCH_QUERY_KCS_SUPPORT = "/api/v2/searchQuery/kcsSupport";

	public static final String SEARCH_SESSION_BY_CASE_UID = "/api/v2/searchSession/byCaseUid";

	public static final String SEARCH = "/api/v2_search/searchResults";

	public static final String GET_ALL_CONTENT_SOURCES = "/api/v2_cs/contentSource/all";

	public static final String GET_CONTENT_SOURCES_BY_ID = "/api/v2_cs/contentSource/{id}";

	public static final String GET_CONTENT_SOURCE_OBJECT_AND_FIELDS = "/api/v2_cs/contentSource/{id}/objectAndFields";

	public static final String GET_ALL_DOCUMENT_IN_CONTENT_SOURCE = "api/v2_cs/apiData/contentSource/{contentSourceId}/object/{objectId}/document/{id}/get";

	public static final String UPDATE_DOCUMENT = "/api/v2_cs/apiData/contentSource/{contentSourceId}/object/{objectId}/document/{id}/update";

	public static final String BULK_UPLOAD_DOCUMENTS = "/api/v2_cs/apiData/contentSource/{contentSourceId}/object/{objectId}/bulkUpload";

}
