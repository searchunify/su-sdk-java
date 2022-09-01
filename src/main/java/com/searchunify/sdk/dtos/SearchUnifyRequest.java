/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.searchunify.sdk.constants.HttpMethod;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ankur
 * @crated 22-Mar-2021
 */
@Getter
@Setter
public class SearchUnifyRequest {

	@JsonIgnore
	private String context;

	@JsonIgnore
	private HttpMethod method;

	@JsonIgnore
	private Map<String, String> headers;

	@JsonIgnore
	private Map<String, String> parameters;

}
