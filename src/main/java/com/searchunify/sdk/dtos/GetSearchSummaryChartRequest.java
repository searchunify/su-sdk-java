/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ankur
 * @crated 15-Jun-2021
 */
@Getter
@Setter
@Builder
public class GetSearchSummaryChartRequest extends SearchUnifyRequest {

	private String from;

	private String to;

	private String uid;

}
