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
public class TileDataResponse extends SearchUnifyResponse {
	
	private GetTileData data;
	
	@Getter
	@ToString
	public static class GetTileData {
		
		private String visitors;
		
	    private String uniqueUsersByDevice;
		
	    private String searchUsers;
		
	    private String searches;
		
	    private String withResult;
		
	    private String withoutResult;
		
	    private String uniqueSearches;
		
	    private String clicks;
		
	    private String caseCount;
		
	    private String clickedSessions;
		
	    private String uniqueFailedSearches;
		
	    private String noClickSearches;
		
	    private String searchesWithoutResults;
		
	    private String usersWithFailedSearches;
		
	    private String noClickSessions;
		
	    private String noResultSessions;
		
	    private long dailyAvgUniqueFailedSearches;
		
	    private long dailyAvgNoClickSearches;
		
	    private long dailyAvgSearchesWithoutResults;
		
	    private long dailyAvgUsersWithFailedSearches;
	    
	    private long emptyEmailSessionCount;
	    
	    private long uniqueUsersByEmail;
	}
}
