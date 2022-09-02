/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
@Getter
@Setter
@NoArgsConstructor
public class GetSearchQueryAllResponse extends SearchUnifyResponse {

	private Map<String, Object> data;
}
