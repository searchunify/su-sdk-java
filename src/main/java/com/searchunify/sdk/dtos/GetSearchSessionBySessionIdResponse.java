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
public class GetSearchSessionBySessionIdResponse extends SearchUnifyResponse {

	private List<GetSearchSessionBySessionIdData> data;

	@Getter
	@ToString
	public static class GetSearchSessionBySessionIdData {

		private String sessionId;

		private List<GetSearchSessionBySessionIdLogs> logs;

		@Getter
		@ToString
		public static class GetSearchSessionBySessionIdLogs {

			private String query;

			private String count;

			private List<GetSearchSessionBySessionIdConversions> conversions;

			@Getter
			@ToString
			public static class GetSearchSessionBySessionIdConversions {

				private String doc;

				private String count;
			}

		}
	}
}
