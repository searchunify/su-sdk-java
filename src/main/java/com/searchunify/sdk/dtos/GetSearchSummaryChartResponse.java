/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;

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
public class GetSearchSummaryChartResponse extends SearchUnifyResponse {

	private GetSearchSummaryChart data;

	@Getter
	@ToString
	public static class GetSearchSummaryChart {

		@JsonProperty("All searches ")
		private List<GetAllSearches> allSearches;

		@JsonProperty("All searches with results")
		private List<GetAllSearchesWithResult> allSearchesWithResult;

		@JsonProperty("Conversions")
		private List<GetConversions> conversions;

		private String format;

		private long conversionPercentage;

		@Getter
		@ToString
		public static class GetAllSearches {

			private String count;

			private String key;

		}

		@Getter
		@ToString
		public static class GetAllSearchesWithResult {

			private String count;

			private String key;

		}

		@Getter
		@ToString
		public static class GetConversions {

			private String count;

			private String key;
		}

	}

}
