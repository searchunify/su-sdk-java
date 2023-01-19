/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;

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
public class SearchSessionByCaseUidResponse extends SearchUnifyResponse {
	
	private List<SearchSessionByCaseUidData> data;
	
	@Getter
	@ToString
	public static class SearchSessionByCaseUidData{
		
		private String name;
		
		private List<SearchSessionByCaseUidDataData> data;
		
		private long totalCount;
		
		@Getter
		@ToString
		public static class SearchSessionByCaseUidDataData{
			
			private String start;
			
			private String end;
			
			private long count;
			
			private List<SearchSessionByCaseUidDataDoc> doc;
			
			@Getter
			@ToString
			public static class SearchSessionByCaseUidDataDoc{
				
				private String text_entered;
				
				private String ts;
			}
			
		}
		
	}
}
