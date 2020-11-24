/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.wordpress;

import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

public class WordPressPostJSONTest
{
	/**
	 * Test of Serialize method, of class WordPressPostJSON.
	 */
	//@Test
	public void testSerialize()
	{
		System.out.println("Serialize");
		String jsonText = "{'id':'5','date':'2019-10-28T00:02:59.808Z','slug':'abc'}";

		WordPressPost wordPressPost = WordPressPostJSON.Parse(jsonText);
		JSONObject expResult = new JSONObject(jsonText);
		JSONObject result = WordPressPostJSON.Serialize(wordPressPost);
		System.out.println(result);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}
}
