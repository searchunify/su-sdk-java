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
public class ArticlesDeflectedCaseRequest extends SearchUnifyRequest {

	@NonNull
	private String from;

	@NonNull
	private String to;

	@NonNull
	private String internalUser;

	@NonNull
	private String searchType;

	@NonNull
	private String uid;

	private Integer offset;

	private Integer limit;

}
