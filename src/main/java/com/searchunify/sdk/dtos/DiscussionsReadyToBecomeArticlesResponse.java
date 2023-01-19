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
public class DiscussionsReadyToBecomeArticlesResponse extends SearchUnifyResponse {
	
	private List<DiscussionsReadyToBecomeArticlesData> data;
	
	@Getter
	@ToString
	public static class DiscussionsReadyToBecomeArticlesData{
		
		private String url;
		
		private String title;
		
		private String content_source;
		
		private String count;
	}
}
