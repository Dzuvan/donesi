package servlets.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Restaurant;
import dao.RestaurantDAO;

public class DeleteRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = RestaurantDAO.getInstance().getRestaurantById(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/restaurant/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			RestaurantDAO.getInstance().deleteRestaurant(id);
			response.sendRedirect("restaurantList");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
