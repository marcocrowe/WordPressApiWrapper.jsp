package com.markcrowe.http;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class SimpleRestAPI
{
	public SimpleRestAPI(String apiUrl, String authorizationBearerToken)
	{
		this.authorizationBearerToken = authorizationBearerToken;
		this.apiUrl = apiUrl;
	}
	//
	//	Public Methods
	//
	public HttpResponse httpDelete(String id) throws IOException
	{
		String urlString = apiUrl + id;
		HttpDelete httpDeleteRequest = new HttpDelete(urlString);
		//
		//	addAuthorizationHeader
		//
		this.addAuthorizationHeader(httpDeleteRequest);
		//
		//	return execution
		//
		return getHttpResponse(httpDeleteRequest);
	}
	public HttpResponse httpGet(String id) throws IOException
	{
		String urlString = apiUrl + id;
		HttpGet httpGetRequest = new HttpGet(urlString);
		//
		//	addAuthorizationHeader
		//
		this.addAuthorizationHeader(httpGetRequest);
		//
		//	return execution
		//
		return getHttpResponse(httpGetRequest);
	}
	public HttpResponse httpGet() throws IOException
	{
		HttpGet httpGetRequest = new HttpGet(apiUrl);
		//
		//	addAuthorizationHeader
		//
		this.addAuthorizationHeader(httpGetRequest);
		//
		//	execution
		//
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse httpResponse = httpClient.execute(httpGetRequest);
		//
		//	return
		//
		return httpResponse;
	}
	public HttpResponse httpPost(JSONObject jsonObject) throws IOException
	{
		HttpPost httpPostRequest = new HttpPost(this.apiUrl);
		//
		//	httpRequest
		//
		httpPostRequest.addHeader("Content-Type", "application/json;charset=utf-8");
		httpPostRequest.setEntity(new StringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON));
		//
		//	addAuthorizationHeader
		//
		this.addAuthorizationHeader(httpPostRequest);
		//
		//	return execution
		//
		return getHttpResponse(httpPostRequest);
	}
	public HttpResponse httpPut(JSONObject jsonObject, String jsonObjectId) throws IOException
	{
		String urlString = apiUrl + jsonObjectId;
		HttpPut httpPutRequest = new HttpPut(urlString);
		//
		//	httpPutRequest
		//
		httpPutRequest.setEntity(new StringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON));
		//
		//	addAuthorizationHeader
		//
		this.addAuthorizationHeader(httpPutRequest);
		//
		//	return execution
		//
		return getHttpResponse(httpPutRequest);
	}
	//
	//	Protected Methods
	//
	protected void addAuthorizationHeader(HttpUriRequest httpUriRequest)
	{
		httpUriRequest.addHeader("Authorization", this.getAuthorizationString());
	}
	protected String getAuthorizationString()
	{
		return "Bearer " + this.authorizationBearerToken;
	}
	//
	//	Private Fields
	//
	private final String apiUrl;
	private final String authorizationBearerToken;
	//
	//	Public Static Methods
	//
	public static HttpResponse getHttpResponse(HttpUriRequest httpUriRequest) throws IOException
	{
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpResponse httpResponse = httpclient.execute(httpUriRequest);
		return httpResponse;
	}
	public static String responseEntityToString(HttpResponse httpResponse) throws IOException
	{
		return EntityUtils.toString(httpResponse.getEntity());
	}
	public static int getResponseStatusCode(HttpResponse httpResponse)
	{
		return httpResponse.getStatusLine().getStatusCode();
	}
	public static int getResponseStatusCode(HttpUriRequest httpUriRequest) throws IOException
	{
		HttpResponse httpResponse = getHttpResponse(httpUriRequest);
		return httpResponse.getStatusLine().getStatusCode();
	}
}
