/**
 * 
 */
package com.searchunify.sdk.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is @author ankur This class is created at 22-Mar-2021
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetSearchConverionWithFilterResponse extends SearchUnifyResponse {

	private List<GetSearchConverionWithFilterData> data;

	@Getter
	@ToString
	public static class GetSearchConverionWithFilterData {

		private String indexName;

		private long indexData;

		@JsonProperty("ObjectsTypes")
		private List<GetSearchConverionWithFilterObjectsTypes> objectsTypes;

		@Getter
		@ToString
		public static class GetSearchConverionWithFilterObjectsTypes {

			private String objectName;

			private long objectData;

			@JsonProperty("Filters")
			private List<GetSearchConverionWithFilterObjectsTypesFilters> filters;

			@Getter
			@ToString
			public static class GetSearchConverionWithFilterObjectsTypesFilters {

				private String filterName;

				private long filterData;

				@JsonProperty("Facets")
				private List<GetSearchConverionWithFilterObjectsTypesFiltersFacets> facets;

				@Getter
				@ToString
				public static class GetSearchConverionWithFilterObjectsTypesFiltersFacets {

					private String facetName;

					private String facetData;

				}
			}

		}

	}
}
