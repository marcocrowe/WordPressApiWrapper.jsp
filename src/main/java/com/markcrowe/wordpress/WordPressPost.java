/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.wordpress;

import java.io.Serializable;

public class WordPressPost implements Serializable
{
	//
	//	Public Properties
	//
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getSlug()
	{
		return slug;
	}
	public void setSlug(String slug)
	{
		this.slug = slug;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	//
	//	Public Methods
	//
	@Override
	public String toString()
	{
		return String.format("Id:%d\nDate:%t\nSlug:%s", id, date, slug);
	}
	//
	//	Private Fields
	//
	private String date;
	private String id;
	private String slug;
	private String image;
	private String type;
}
