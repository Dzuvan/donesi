package servlets.article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Drink;
import beans.Meal;
import beans.Restaurant;
import dao.ArticleDAO;
import dao.RestaurantDAO;

public class CreateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("restaurants", RestaurantDAO.getInstance().getRestaurants());
		request.getRequestDispatcher("/WEB-INF/article/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			float amount = Float.parseFloat(request.getParameter("amount"));
			float price = Float.parseFloat(request.getParameter("price"));
			Long id = Long.parseLong(request.getParameter("restaurant"));
			Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(id);
			
			if (type.equals("Meal")) {
				Meal meal = new Meal(name, price, description, amount);
				meal.setRestaurant(restaurant);
				ArticleDAO.getInstance().create(meal);
			} else {
				Drink drink = new Drink(name, price, description, amount);
				drink.setRestaurant(restaurant);
				ArticleDAO.getInstance().create(drink);
			}
			response.sendRedirect("articleList");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
