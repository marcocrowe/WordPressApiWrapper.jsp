package com.markcrowe.wordpress;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WordPressPostJSON
{
	public static WordPressPost Parse(JSONObject jsonObject) throws JSONException
	{
		WordPressPost wordPressPost = new WordPressPost();
		//
		//  wordPressPost
		//
		wordPressPost.setDate(jsonObject.getString(Fields.date));
		wordPressPost.setId(jsonObject.getString(Fields.id));
		wordPressPost.setSlug(jsonObject.getString(Fields.slug));
		//wordPressPost.setType(jsonObject.getString(Fields.type));
		//
		//	return
		//
		return wordPressPost;
	}
	public static WordPressPost Parse(String text) throws JSONException
	{
		return Parse(new JSONObject(text));
	}
	public static List<WordPressPost> ParseList(JSONArray jsonArray) throws JSONException
	{
		List<WordPressPost> wordPressPosts = new ArrayList<>();
		ParseList(jsonArray, wordPressPosts);
		return wordPressPosts;
	}
	public static void ParseList(JSONArray jsonArray, List<WordPressPost> wordPressPosts) throws JSONException
	{
		for(int index = 0; index < jsonArray.length(); index++)
		{
			JSONObject jsonObject = jsonArray.getJSONObject(index);
			WordPressPost wordPressPost = WordPressPostJSON.Parse(jsonObject);
			wordPressPosts.add(wordPressPost);
		}
	}
	public static List<WordPressPost> ParseList(String text) throws JSONException
	{
		return ParseList(new JSONArray(text));
	}
	public static JSONObject Serialize(WordPressPost wordPressPost) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		//
		//  jsonObject
		//
		jsonObject.put(Fields.id, wordPressPost.getId());
		jsonObject.put(Fields.date, wordPressPost.getDate());
		jsonObject.put(Fields.slug, wordPressPost.getSlug());
		//
		//	return
		//
		return jsonObject;
	}

	public final class Fields
	{
		public static final String id = "id";
		public static final String date = "date";
		public static final String slug = "slug";
		public static final String image = "image";
		public static final String type = "type";
	}
}
