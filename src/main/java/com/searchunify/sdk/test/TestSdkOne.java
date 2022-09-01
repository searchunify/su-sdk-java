/**
 * 
 */
package com.searchunify.sdk.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.searchunify.sdk.SearchUnifyClient;
import com.searchunify.sdk.dtos.BulkUploadDocumentRequest;
import com.searchunify.sdk.dtos.GetContentSourceByIdRequest;
import com.searchunify.sdk.dtos.TileDataRequest;
import com.searchunify.sdk.dtos.TileDataResponse;

import lombok.NonNull;

/**
 * @author ankur
 * @crated 22-Mar-2021
 */
public class TestSdkOne {

	private static SearchUnifyClient client;

	public TestSdkOne() throws ParseException {
		// String key = "key";
		// String secret = "secret";
		// String baseContext = "http://local.searchunify.com";
		// String baseContext = "https://reqres.in";
		// this.client = new SearchUnifyClient(key, secret, baseContext);
		String key = "Cf675b903e0f6b2179bd9d3811ffec11e";
		String secret = "S545686d9780483af79d2758379c9eebf";
		String baseContext = "https://feature1.searchunify.com";
		String username = "mohanrana800@gmail.com";
		String password = "Grazitti@271";
		client = new SearchUnifyClient(key, secret, baseContext, username, password, "password");

		// TileDataRequest request = TileDataRequest.builder().from(DTUtils.format(new
		// Date(), "YYYY-MM-dd"))
		// .to(DTUtils.format(new Date(),
		// "YYYY-MM-dd")).uid(UUID.randomUUID().toString()).build();
		// TileDataResponse tileData = client.getTileData(request);
		// System.out.println(tileData.getData());
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		TestSdkOne one = new TestSdkOne();

		// GetSearchSummaryChartRequest request = GetSearchSummaryChartRequest.builder()
		// .from(DTUtils.format(new Date(), "YYYY-MM-dd")).to(DTUtils.format(new Date(),
		// "YYYY-MM-dd")).build();
		// GetSearchSummaryChartResponse response =
		// client.getSearchSummaryChart(request);
		// System.out.println(response.getMessage() + " | " + response.getData());

		// GetSearchQueryAllRequest request = GetSearchQueryAllRequest.builder()
		// .startDate(DTUtils.format(new Date(),
		// "YYYY-MM-dd")).endDate(DTUtils.format(new Date(), "YYYY-MM-dd"))
		// .count(10).build();
		// GetSearchQueryAllResponse response = client.getSearchQueryAll(request);
		// System.out.println(response.getMessage() + " | " + response.getData());

		// GetContentSourceByIdRequest byIdRequest =
		// GetContentSourceByIdRequest.builder().id("1000").build();
		// GetContentSourceByIdRequest byIdRequest = new GetContentSourceByIdRequest();
		// byIdRequest.setId("100");
		// client.getContentSourcesById(byIdRequest);
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> m1 = new HashMap<>();
		m1.put("name", "ankur");
		m1.put("age", 31);
		Map<String, Object> m2 = new HashMap<>();
		m2.put("name", "chanchal");
		m2.put("age", 28);
		list.add(m1);
		list.add(m2);
		BulkUploadDocumentRequest request = BulkUploadDocumentRequest.builder().contentSourceId("10").objectId("111")
				.bulkData(list).build();
		client.bulkUploadDocuments(request);
	}

	public void testRequest() {
		// TestRequest request = TestRequest.builder().name("Ankur").job("Technical
		// Architect").build();
		// TestResponse response = client.samplePostRequest(request);
		// System.out.println(response.toString());
		// System.out.println("The status is: " + response.isStatus() + " and message is
		// " + response.getMessage());
	}

	public void tileDataRequest() {
		TileDataRequest request = TileDataRequest.builder().from(new Date().toString()).to(new Date().toString())
				.uid("uuid").build();
		Map<String, String> params = new HashMap<>();
		params.put("first", "ankur");
		params.put("second", "mohan");
		params.put("third", "10");
		request.setParameters(params);
		TileDataResponse saveTileData = client.getTileData(request);
		System.out.println(saveTileData);
	}

	public void testRegister() {
		// TestRegisterRequest request =
		// TestRegisterRequest.builder().email("eve.holt@reqres.in").password("pistol")
		// .build();
		// TestRegisterResponse response = client.registerUser(request);
		// System.out.println(response.toString());
		// System.out.println("The status is: " + response.isStatus() + " and message is
		// " + response.getMessage());
		// System.out.println(response.getToken());
		// TODO - Client can do anything.
		// System.out.println(response.getId() + "|" + response.getToken());

	}
}
