/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.wordpress;

import java.util.List;

public interface WordPressPostRepository
{
	public WordPressPost createWordPressPost(WordPressPost wordPressPost) throws Exception;
	public String deleteWordPressPost(WordPressPost wordPressPost) throws Exception;
	public String deleteWordPressPostById(String id) throws Exception;
	public WordPressPost getWordPressPostById(String id) throws Exception;
	public List<WordPressPost> getWordPressPosts() throws Exception;
	public WordPressPost updateWordPressPost(WordPressPost wordPressPost) throws Exception;
}
