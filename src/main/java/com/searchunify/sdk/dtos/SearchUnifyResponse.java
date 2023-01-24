/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
@Getter
@Setter
@ToString
public class SearchUnifyResponse {

	private boolean status = true;

	private String message = "API Response.";

}
