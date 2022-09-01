/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ankur
 * @crated 22-Mar-2021
 */
@Getter
@Setter
@NoArgsConstructor
public class GetContentSourceObjectAndFieldsResponse extends SearchUnifyResponse {

	private Map<String, Object> data;
}
