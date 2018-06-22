package servlets.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;
import beans.Restaurant;
import dao.ArticleDAO;
import dao.RestaurantDAO;

public class AddArticleToRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("articles", ArticleDAO.getInstance().getArticles());
		Long id = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("WEB-INF/restaurant/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("article"));
			Article article = ArticleDAO.getInstance().getArticleById(id);
			Long restaurantId = Long.parseLong(request.getParameter("restaurant"));
			Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(restaurantId);
			RestaurantDAO.getInstance().addArticle(restaurant, article);
			response.sendRedirect("restaurantDetails?id=" + restaurantId);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
