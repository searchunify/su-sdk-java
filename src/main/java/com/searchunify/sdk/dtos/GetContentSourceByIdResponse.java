/**
 * 
 */
package com.searchunify.sdk.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetContentSourceByIdResponse extends SearchUnifyResponse {

	private long id;

	private String label;

	private String name;

	private String url;

	private long size;

}
