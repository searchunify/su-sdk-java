/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author ankur
 * @crated 15-Jun-2021
 */
@Getter
@Setter
@Builder
public class SearchQueryKcsSupportRequest extends SearchUnifyRequest {

	@NonNull
	private String startDate;

	@NonNull
	private String endDate;

	private String searchClientId;

}
