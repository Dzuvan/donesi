package servlets.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Restaurant;
import dao.RestaurantDAO;

public class EditRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/restaurant/edit.jsp").forward(request, response);
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
			String address = request.getParameter("address");
			String category = request.getParameter("category");

			Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(id);

			restaurant.setCategory(category);
			restaurant.setName(name);
			restaurant.setAddress(address);

			RestaurantDAO.getInstance().update(restaurant);

			response.sendRedirect("restaurantList");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
