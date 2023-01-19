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
public class GetAllDocumentInContentSourceResponse extends SearchUnifyResponse {

	private GetAllDocumentInContentSourceData response;

	@Getter
	@ToString
	public static class GetAllDocumentInContentSourceData {

		private String id;
		
		private String contentSource;
		
		private String object;
		
		private Boolean found;
		
		private GetAllDocumentInContentSourceSource source;
		
		public static class GetAllDocumentInContentSourceSource{
			
		}
		
	}

}
