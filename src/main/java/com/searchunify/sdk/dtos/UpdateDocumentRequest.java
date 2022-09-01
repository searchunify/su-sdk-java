/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.Map;

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
public class UpdateDocumentRequest extends SearchUnifyRequest {

	@NonNull
	private String contentSourceId;

	@NonNull
	private String objectId;

	@NonNull
	private String documentId;

	@NonNull
	private Map<String, Object> body;
}
