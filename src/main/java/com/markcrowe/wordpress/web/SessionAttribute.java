/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.wordpress.web;

import javax.servlet.http.HttpServletRequest;

public class SessionAttribute<T>
{
	public SessionAttribute(String attributeName)
	{
		this.attributeName = attributeName;
	}
	public String getAttributeName()
	{
		return attributeName;
	}
	@SuppressWarnings("unchecked")
	public T getValue(HttpServletRequest request)
	{
		return (T) request.getSession().getAttribute(attributeName);
	}
	public void setValue(HttpServletRequest request, T value)
	{
		request.getSession().setAttribute(attributeName, value);
	}
	private final String attributeName;
}
