package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDAO;

public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		long id = Long.parseLong(request.getParameter("id"));
		User user = UserDAO.getInstance().getUserById(id);
		session.setAttribute("user", user);

		request.getRequestDispatcher("/WEB-INF/user/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext ctx = getServletConfig().getServletContext();
		HttpSession session = request.getSession(true);

		try {
			String username = request.getParameter("username");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String dateString = request.getParameter("birthday");
			LocalDate birthday = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

			User user = (User) session.getAttribute("user");
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhone(phone);
			user.setUsername(username);
			user.setBirthday(birthday);

			User updated = UserDAO.getInstance().updateUser(user);
			ctx.setAttribute("user", updated);
			response.sendRedirect("profile");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
