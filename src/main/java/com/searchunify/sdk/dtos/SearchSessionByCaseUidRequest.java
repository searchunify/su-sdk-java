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
public class SearchSessionByCaseUidRequest extends SearchUnifyRequest {

	@NonNull
	private String startDate;

	@NonNull
	private String endDate;

	@NonNull
	private String caseUID;

}
