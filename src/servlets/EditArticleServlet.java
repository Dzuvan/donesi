package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;
import dao.ArticleDAO;

public class EditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Article article = ArticleDAO.getInstance().getArticleById(id);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/WEB-INF/article/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			float price = Float.parseFloat(request.getParameter("price"));
			float amount = Float.parseFloat(request.getParameter("amount"));
			Article article = ArticleDAO.getInstance().getArticleById(id);

			article.setAmount(amount);
			article.setName(name);
			article.setDescription(description);
			article.setPrice(price);

			ArticleDAO.getInstance().updateArticle(article);

			response.sendRedirect("articleList");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
