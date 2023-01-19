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
public class GetAllContentSourcesResponse extends SearchUnifyResponse {
	
	List<GetAllContentSources> contentSources;
	
	@Getter
	@ToString
	public static class GetAllContentSources{
		
		private String id;
		
		private String label;
		
		private String name;
		
		private String url;
		
	}
	
}
