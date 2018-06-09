package servlets.user;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Buyer;
import dao.UserDAO;

/**
 * Servlet za registraciju korisnika.
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;
	private ServletContext ctx;
	private HashMap<String, String> messages;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userDao = UserDAO.getInstance();
		ctx = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		messages = new HashMap<>();
		request.setAttribute("messages", messages);
		request.setCharacterEncoding("UTF-8");

		try {
			String username = request.getParameter("username");
			boolean unique = userDao.checkUniqueUsername(username);
			if (!unique) {
				messages.put("username", "Username taken!");
				ctx.getRequestDispatcher("/WEB-INF/user/signup.jsp").forward(request, response);
				return;
			}
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			if (!password.equals(password2)) {
				messages.put("password", "Passwords do not match!");
				ctx.getRequestDispatcher("/WEB-INF/user/signup.jsp").forward(request, response);
				return;
			}
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String dateString = request.getParameter("birthday");
			LocalDate birthday = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

			Buyer user = new Buyer(firstName, lastName, username, password, email, phone, birthday);
			userDao.create(user);

			// ctx.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			response.sendRedirect("login");
		} catch (Exception e) {
			throw new ServletException();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ctx.getRequestDispatcher("/WEB-INF/user/signup.jsp").forward(req, resp);
	}

}
