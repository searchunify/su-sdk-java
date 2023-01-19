/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class is @author ankur
 * This class is created at 15-Jun-2021
 */
@Getter
@Setter
@Builder
public class SearchQueryHistogramRequest extends SearchUnifyRequest {
	
	private String uid;
	
	@NonNull
	private String from;
	
	@NonNull
	private String 	to;
	
	private String internalUser;

}
