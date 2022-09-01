/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author ankur
 * @crated 15-Jun-2021
 */
@Getter
@Setter
@Builder
public class SearchRequest extends SearchUnifyRequest {

	@NonNull
	private String uid;

	private Integer offset;

	private Integer limit;

	private String searchString;

	private String email;

	private String orderBy;

	private String sortby;

	private String exactPhrase;

	private String withOneOrMoreString;

	private String withoutTheWords;

	private String from;

	private String resultsPerPage;

	private String indexEnabled;

	private String aggregations;

	private String pagingAggregation;

	private String pageNo;

	private String sid;

	private String language;

	private String versionResults;

	private String getAutoTunedResult;

	private String getSimilarSearches;

	private String mergeSources;

	// Salesforce-Specific Parameters
	private String UserId;

	private String UserType;

	private String AccountId;

	private String ProfileId;

	private String ContactId;

	// Lithium-Specific Parameters
	private String boardsArr;
}
