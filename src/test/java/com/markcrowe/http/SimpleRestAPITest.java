/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.http;

import static com.markcrowe.http.SimpleRestAPI.getResponseStatusCode;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author Mark Crowe <https://github.com/markcrowe-com>
 */
public class SimpleRestAPITest
{
	private String testJSONObjectId;
	private SimpleRestAPI instance;
	private String testJSONObjectText;
	private String newJSONObjectText;

	public SimpleRestAPITest()
	{
	}

	@Before
	public void setUp()
	{
		String wpSiteApiUrl = "";
		String wpSiteBearerToken = "";
		instance = new SimpleRestAPI(wpSiteApiUrl, wpSiteBearerToken);
		newJSONObjectText = "{'title':'hello blah bah','status':'publish'}";
		testJSONObjectId = "83";
		testJSONObjectText = "{'id':'83', 'title':'hello blah bah','status':'publish'}";
	}
	/**
	 * Test of httpDelete method, of class SimpleRestAPI.
	 */
	//@Test
	public void testHttpDelete() throws Exception
	{
		System.out.println("httpDelete");
		int expResult = HttpStatus.SC_OK;
		HttpResponse result = instance.httpDelete(testJSONObjectId);
		assertEquals(expResult, getResponseStatusCode(result));
	}
	/**
	 * Test of httpGet method, of class SimpleRestAPI.
	 */
	//@Test
	public void testHttpGet_String() throws Exception
	{
		System.out.println("httpGet");
		int expResult = HttpStatus.SC_OK;
		HttpResponse result = instance.httpGet(testJSONObjectId);
		assertEquals(expResult, getResponseStatusCode(result));
	}
	/**
	 * Test of httpGet method, of class SimpleRestAPI.
	 */
	//@Test
	public void testHttpGet_0args() throws Exception
	{
		System.out.println("httpGet");
		int expResult = HttpStatus.SC_OK;
		HttpResponse result = instance.httpGet();
		assertEquals(expResult, getResponseStatusCode(result));
	}
	/**
	 * Test of httpPost method, of class SimpleRestAPI.
	 */
	//@Test
	public void testHttpPost() throws Exception
	{
		System.out.println("httpPost");
		JSONObject jsonObject = new JSONObject(newJSONObjectText);
		int expResult = HttpStatus.SC_OK;
		HttpResponse result = instance.httpPost(jsonObject);
		assertEquals(expResult, getResponseStatusCode(result));
	}
	/**
	 * Test of httpPut method, of class SimpleRestAPI.
	 */
	//@Test
	public void testHttpPut() throws Exception
	{
		System.out.println("httpPut");
		JSONObject jsonObject = new JSONObject(testJSONObjectText);
		int expResult = HttpStatus.SC_OK;
		HttpResponse result = instance.httpPut(jsonObject, testJSONObjectId);
		assertEquals(expResult, getResponseStatusCode(result));
	}
}
