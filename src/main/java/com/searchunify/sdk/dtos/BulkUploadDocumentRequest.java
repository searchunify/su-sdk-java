/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;
import java.util.Map;

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
public class BulkUploadDocumentRequest extends SearchUnifyRequest {

	// @NonNull
	private String contentSourceId;

	// @NonNull
	private String objectId;

	@NonNull
	private List<Map<String, Object>> bulkData;
}
