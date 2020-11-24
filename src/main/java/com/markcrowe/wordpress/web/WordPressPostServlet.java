package com.markcrowe.wordpress.web;

import com.markcrowe.wordpress.WordPressPost;
import com.markcrowe.wordpress.httprepository.WordPressPostHttpRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WordPressPost", urlPatterns =
{
	"/WordPressPost"
})
public class WordPressPostServlet extends HttpServlet
{
	public WordPressPostServlet() throws IOException
	{
		ApplicationProperties applicationProperties = ApplicationProperties.getApplicationProperties();
		wordPressPostRepository = new WordPressPostHttpRepository(applicationProperties.getApiUrl(), applicationProperties.getAuthorizationBearerToken());
	}
	//
	//	Public Methods
	//
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter(RequestParameterNames.Action);
		switch(action)
		{
			case Actions.CreateWordPressPost:
				createWordPressPost(request, response);
			case Actions.DeleteWordPressPost:
				deleteWordPressPost(request, response);
			case Actions.GetCreatePage:
				gotoPage(WebPages.CreatePost, request, response);
				break;
			case Actions.GetWordPressPost:
				getWordPressPost(request, response);
				break;
			case Actions.GetWordPressPosts:
				getWordPressPosts(request, response);
				break;
		}
	}
	private void createWordPressPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		WordPressPost wordPressPost = parseWordPressPostFromRequest();

		WordPressPost createdWordPressPost = wordPressPostRepository.createWordPressPost(wordPressPost);

		SessionAttributes.WordPressPost.setValue(request, createdWordPressPost);
		gotoPage(WebPages.Created, request, response);
	}
	private void deleteWordPressPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestId = request.getParameter(RequestParameterNames.Id);

		String deletedWordPressPostId = wordPressPostRepository.deleteWordPressPostById(requestId);

		SessionAttributes.WordPressPostId.setValue(request, deletedWordPressPostId);
		SessionAttributes.OperationSucessFlag.setValue(request, deletedWordPressPostId.equalsIgnoreCase(requestId));
		gotoPage(WebPages.Deleted, request, response);
	}
	private void getWordPressPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String requestId = request.getParameter(RequestParameterNames.Id);

		WordPressPost wordPressPost = wordPressPostRepository.getWordPressPostById(requestId);

		SessionAttributes.WordPressPost.setValue(request, wordPressPost);
		gotoPage(WebPages.Posts, request, response);
	}
	private void getWordPressPosts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		SessionAttributes.WordPressPosts.setValue(request, wordPressPostRepository.getWordPressPosts());
		gotoPage(WebPages.Posts, request, response);
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	private WordPressPost parseWordPressPostFromRequest()
	{
		WordPressPost wordpressPost = new WordPressPost();
		// getHttpPost/HttpGet Variables
		return wordpressPost;
	}
	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}
	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}
	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo()
	{
		return "Sales Stock Servlet";
	}
	// </editor-fold>
	//
	//	Private Fields
	//
	private final WordPressPostHttpRepository wordPressPostRepository;

	public class Actions
	{
		public static final String CreateWordPressPost = "createwordpresspost";
		public static final String DeleteWordPressPost = "deletewordpresspost";
		public static final String GetWordPressPost = "getwordpresspost";
		public static final String GetWordPressPosts = "getwordpressposts";
		public static final String GetCreatePage = "getcreatepage";
	}

	public class RequestParameterNames
	{
		public static final String Action = "action";
		public static final String Id = "Id";
	}

	public class SessionAttributeNames
	{
		public static final String OperationSucessFlag = "operationSucessFlag";
		public static final String WordPressPost = "wordPressPost";
		public static final String WordPressPostId = "wordPressPostId";
		public static final String WordPressPosts = "wordPressPosts";
	}

	public static class SessionAttributes
	{
		public final static SessionAttribute<Boolean> OperationSucessFlag = new SessionAttribute<>(SessionAttributeNames.OperationSucessFlag);
		public final static SessionAttribute<WordPressPost> WordPressPost = new SessionAttribute<>(SessionAttributeNames.WordPressPost);
		public final static SessionAttribute<String> WordPressPostId = new SessionAttribute<>(SessionAttributeNames.WordPressPostId);
		public final static SessionAttribute<List<WordPressPost>> WordPressPosts = new SessionAttribute<>(SessionAttributeNames.WordPressPosts);
	}
}
