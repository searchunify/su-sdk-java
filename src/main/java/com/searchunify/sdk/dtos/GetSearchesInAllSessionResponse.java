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
public class GetSearchesInAllSessionResponse extends SearchUnifyResponse {
	
	private List<GetSearchesInAllSessionData> data;
	
	@Getter
	@ToString
	public static class GetSearchesInAllSessionData{
		
		private List<GetSearchesInAllSessionLogs> logs;
		
		private String sessionId;
		
		@Getter
		@ToString
		public static class GetSearchesInAllSessionLogs{
			
			private String query;
			
			private String count;
		}
		
	}
	
}
