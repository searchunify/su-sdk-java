/**
 * 
 */
package com.searchunify.sdk.dtos;

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
public class GetSearchConverionNotOnFirstPageResponse extends SearchUnifyResponse {

	private GetSearchConverionNotOnFirstPageData data;

	@Getter
	@ToString
	public static class GetSearchConverionNotOnFirstPageData {

		private String doc;

		private String count;
	}
}
