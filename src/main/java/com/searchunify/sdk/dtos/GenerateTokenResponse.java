/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is @author ankur
 * This class is created at 26-Mar-2021
 */
@Getter
@Setter
@ToString
public class GenerateTokenResponse extends SearchUnifyResponse {

	private String accessToken;

	private String refreshToken;

}
