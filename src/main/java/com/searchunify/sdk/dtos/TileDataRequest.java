/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ankur
 * @crated 22-Mar-2021
 */
@Getter
@Setter
@Builder
public class TileDataRequest extends SearchUnifyRequest {

	private String from;

	private String to;

	private String uid;

}
