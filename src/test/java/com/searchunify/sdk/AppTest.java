package com.searchunify.sdk;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private SearchUnifyClient client;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		client = new SearchUnifyClient("testKey", "testSecret", "https://reqres.in", testName, testName, testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testRequest() {
		// TestRequest request = TestRequest.builder().name("Ankur").job("Technical
		// Architect").build();
		// TestResponse response = client.samplePostRequest(request);
		// System.out.println(response.toString());
		// assertNotNull(response);
	}
}
