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
public class GetSearchQueryWithoutResultsResponse extends SearchUnifyResponse {

	private List<GetSearchQueryWithoutResultsData> data;

	@Getter
	@ToString
	public static class GetSearchQueryWithoutResultsData {

		private String count;

		private String value;

	}
}
