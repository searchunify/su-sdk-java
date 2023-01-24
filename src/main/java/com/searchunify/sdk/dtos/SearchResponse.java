/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchResponse extends SearchUnifyResponse {

	private SearchResult result;
	
	private List<SearchAggregationsArray> aggregationsArray;

	private SearchSuggest suggest;

	private SearchSearchClientSettings searchClientSettings;

	@JsonProperty("merged_facets")
	private String mergedFacets;

	@Getter
	@ToString
	public static class SearchResult {

		private String total;

		@JsonProperty("max_score")
		private String maxScore;

		private List<SearchResultHits> hits;

		@Getter
		@ToString
		public static class SearchResultHits {

			@JsonProperty("_id")
			private String id;

			@JsonProperty("_score")
			private String score;

			private Map<String, Object> highlight;

			private List<Map<String, Object>> metadata;

			private List<Map<String, Object>> autosuggestData;

			private String href;

			private String clientHref;

			private String objLabel;

			private String objName;

			private String sourceName;

			private String sourceLabel;

			private String solved;

			private String indexedDate;

			private String sortOrder;

			private String contentTag;

		}

		@Getter
		@ToString
		public static class SearchResultHitsHighlight {

			private List<String> SummaryToDisplay;

			private List<String> TitleToDisplay;

			private List<String> TitleToDisplayString;

		}

	}

	@Getter
	@ToString
	public static class SearchAggregationsArray {

		private String key;

		private String label;

		private List<SearchAggregationsArrayValues> values;

		private String order;

		private String sort;
		
		@Getter
		@ToString
		public static class SearchAggregationsArrayValues {

			private String displayName;

			private String filterOrder;

			private String Contentname;

			private String value;

			private String immediateParent;

			private String parent;

			private String childName;

			private String level;

		}

	}

	@Getter
	@ToString
	public static class SearchSuggest {

		@JsonProperty("simple_phrase")
		private List<SearchSuggestSimplePhrase> simplePhrase;

		@Getter
		@ToString
		public static class SearchSuggestSimplePhrase {

			private String text;

			private String offset;

			private String length;

			private List<Map<String, Object>> options;

		}

	}

	@Getter
	@ToString
	public static class SearchSearchClientSettings {

		private boolean similarSearch;

		private boolean specialSearch;

		private List<Map<String, Object>> hiddenFacet;

		private String advertisements;

		private String autoCompleteInstant;

		private String recommendations;

		private String autoComplete;

		private String redirectionUrl;

		private boolean scrollPagination;

		private boolean moreResultButton;

		private boolean pageNoButton;

		private String languageManager;

		private String ViewedResults;

		private boolean preview;

		@JsonProperty("SCsalesforceConsoleConfigurations")
		private String salesforceConsoleConfigurations;

		private boolean mergeSources;

		private boolean showMore;

		private String minSummaryLength;

		private boolean contentTag;

		private boolean hideAllContentSources;

		private boolean smartFacets;

		private UserFeedbackEnabled userFeedbackEnabled;

		@Getter
		@ToString
		public static class UserFeedbackEnabled {

			private boolean contentSearchExp;

			private boolean searchExp;

			private boolean conversionExp;

		}

	}

}
