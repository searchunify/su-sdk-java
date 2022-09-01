/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ankur
 * @crated 26-Mar-2021
 */
@Getter
@Setter
@ToString
public class GenerateTokenResponse extends SearchUnifyResponse {

	private String accessToken;

	private String refreshToken;

}
