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
public class GetSearchQueryWithNoClicksResponse extends SearchUnifyResponse {
		
	private List<GetSearchQueryWithNoClicksData> data;
	
	@Getter
	@ToString
	public static class GetSearchQueryWithNoClicksData{
		
		private String count;
		
		private String value;
		
	}
}
