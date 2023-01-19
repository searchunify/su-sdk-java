/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;

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
public class GetContentSourceObjectAndFieldsResponse extends SearchUnifyResponse {

	private List<GetContentSourceObjectAndFieldsItems> items;

	@Getter
	@ToString
	public static class GetContentSourceObjectAndFieldsItems {
		
		private GetContentSourceObjectAndFieldsObject object;
		
		@Getter
		@ToString
		public static class GetContentSourceObjectAndFieldsObject{
			
			private String id;
			
			private String name;
			
			private String label;
			
			private List<GetContentSourceObjectAndFieldsObjectFields> fields;
			
			@Getter
			@ToString
			public static class GetContentSourceObjectAndFieldsObjectFields{
				
				private String id;
				
				private String name;
				
				private String label;
				
				private String type;
				
				private String isFilterable;
				
				private String isSearchable;
				
			}
		}
		
	}

}
