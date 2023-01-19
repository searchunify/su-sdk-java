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
public class SearchQueryHistogramResponse extends SearchUnifyResponse {

	private SearchQueryHistogramData data;
	
	@Getter
	@ToString
	public static class SearchQueryHistogramData{
		
		private List<SearchQueryHistogramSearch> search;
		
		@JsonProperty("Conversions")
		private List<SearchQueryHistogramConversion> conversion;
		
		private String format;
		
		@Getter
		@ToString
		public static class SearchQueryHistogramSearch {
		
			private long count;
			
			private String key;
			
			private String time;
			
		}
		
		@Getter
		@ToString
		public static class SearchQueryHistogramConversion{
			
			private long count;
			
			private String key;
			
			private String time;
			
		}
	}
	
}
