package com.markcrowe.wordpress.httprepository;

import com.markcrowe.http.SimpleRestAPI;
import static com.markcrowe.http.SimpleRestAPI.getResponseStatusCode;
import static com.markcrowe.http.SimpleRestAPI.responseEntityToString;
import com.markcrowe.wordpress.WordPressPost;
import com.markcrowe.wordpress.WordPressPostJSON;
import com.markcrowe.wordpress.WordPressPostRepository;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

public class WordPressPostHttpRepository implements WordPressPostRepository
{
	public WordPressPostHttpRepository(String apiUrl, String authorizationBearerToken)
	{
		wordpressRestAPI = new SimpleRestAPI(apiUrl, authorizationBearerToken);
	}
	//
	//	Public Methods
	//
	@Override
	public WordPressPost createWordPressPost(WordPressPost wordPressPost) throws IOException
	{
		JSONObject jsonObject = WordPressPostJSON.Serialize(wordPressPost);
		HttpResponse httpResponse = wordpressRestAPI.httpPost(jsonObject);
		int responseStatusCode = getResponseStatusCode(httpResponse);

		if(responseStatusCode == HttpStatus.SC_OK)
		{
			WordPressPost newWordPressPost = WordPressPostJSON.Parse(responseEntityToString(httpResponse));
			return newWordPressPost;
		}
		else
		{
			//handle Error
			return null;
		}
	}
	@Override
	public String deleteWordPressPost(WordPressPost wordPressPost) throws IOException
	{
		return deleteWordPressPostById(wordPressPost.getId());
	}
	@Override
	public String deleteWordPressPostById(String id) throws IOException
	{
		int responseCode = getResponseStatusCode(wordpressRestAPI.httpDelete(id));
		if(responseCode == HttpStatus.SC_OK)
		{
			return id;
		}
		else
		{
			//handle error
			return "";
		}
	}
	@Override
	public WordPressPost getWordPressPostById(String id) throws IOException
	{
		HttpResponse httpResponse = wordpressRestAPI.httpGet(id);
		WordPressPost wordPressPost = null;
		if(getResponseStatusCode(httpResponse) == HttpStatus.SC_OK)
		{
			wordPressPost = WordPressPostJSON.Parse(responseEntityToString(httpResponse));
		}
		else
		{
			//handle error
		}
		return wordPressPost;
	}
	@Override
	public List<WordPressPost> getWordPressPosts() throws IOException
	{
		HttpResponse httpResponse = wordpressRestAPI.httpGet();
		List<WordPressPost> wordPressPosts = null;
		if(getResponseStatusCode(httpResponse) == HttpStatus.SC_OK)
		{
			wordPressPosts = WordPressPostJSON.ParseList(responseEntityToString(httpResponse));
		}
		else
		{
			//handle error
		}
		return wordPressPosts;
	}
	@Override
	public WordPressPost updateWordPressPost(WordPressPost wordPressPost) throws IOException
	{
		JSONObject jsonObject = WordPressPostJSON.Serialize(wordPressPost);
		HttpResponse httpResponse = wordpressRestAPI.httpPut(jsonObject, wordPressPost.getId());
		int responseStatusCode = getResponseStatusCode(httpResponse);

		if(responseStatusCode == HttpStatus.SC_OK)
		{
			WordPressPost updatedWordPressPost = WordPressPostJSON.Parse(responseEntityToString(httpResponse));
			return updatedWordPressPost;
		}
		else
		{
			//handle Error
			return null;
		}
	}
	//
	//	Private Fields
	//
	private final SimpleRestAPI wordpressRestAPI;
}
