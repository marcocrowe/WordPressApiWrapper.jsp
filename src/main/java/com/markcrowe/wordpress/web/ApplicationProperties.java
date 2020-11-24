/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.wordpress.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties
{
	private ApplicationProperties()
	{
	}
	public String getApiUrl()
	{
		return apiUrl;
	}
	public void setApiUrl(String apiUrl)
	{
		this.apiUrl = apiUrl;
	}
	public String getAuthorizationBearerToken()
	{
		return authorizationBearerToken;
	}
	public void setAuthorizationBearerToken(String authorizationBearerToken)
	{
		this.authorizationBearerToken = authorizationBearerToken;
	}
	//
	//	Private Fields
	//
	private String apiUrl;
	private String authorizationBearerToken;
	//
	//	Static Methods
	//
	public static ApplicationProperties getApplicationProperties() throws FileNotFoundException, IOException
	{
		Properties properties = getProperties();
		ApplicationProperties applicationProperties = new ApplicationProperties();
		applicationProperties.setApiUrl(properties.getProperty("apiUrl"));
		applicationProperties.setAuthorizationBearerToken(properties.getProperty("authorizationBearerToken"));
		return applicationProperties;
	}
	private static Properties getProperties() throws IOException, FileNotFoundException
	{
		String filename = "application.config";
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(filename);
		properties.load(fileInputStream);
		fileInputStream.close();
		return properties;
	}
}
