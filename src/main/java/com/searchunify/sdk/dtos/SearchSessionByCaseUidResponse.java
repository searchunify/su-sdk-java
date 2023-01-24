/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class SearchSessionByCaseUidResponse extends SearchUnifyResponse {

	private List<SearchSessionByCaseUidData> data;

	@Getter
	@ToString
	public static class SearchSessionByCaseUidData {

		private String name;

		@JsonProperty("data")
		private List<SearchSessionByCaseUidDataData> data;

		private String totalCount;

		@Getter
		@ToString
		public static class SearchSessionByCaseUidDataData {

			private String start;

			private String end;

			private String count;

			private List<Map<String,Object>> doc;

		}

	}
}
