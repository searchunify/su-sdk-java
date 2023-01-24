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
 * This class is created at 22-Mar-2021
 */
@Getter
@Setter
@Builder
public class TileDataRequest extends SearchUnifyRequest {

	@NonNull
	private String from;

	@NonNull
	private String to;

	private String uid;
	
	private String internalUser;

}
