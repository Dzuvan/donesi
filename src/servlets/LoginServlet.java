package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDAO;

/**
 * Servlet za prijavu korisnika.
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -678832957377757118L;

	private String failurePage;
	private String successPage;
	private ServletContext ctx;

	private UserDAO userDao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		failurePage = config.getInitParameter("failure-page");
		if (failurePage == null)
			throw new ServletException("LoginServlet: missing init parameter 'failure-page'");

		successPage = config.getInitParameter("success-page");
		if (successPage == null)
			throw new ServletException("LoginServlet: missing init parameter 'success-page");

		ctx = config.getServletContext();
		userDao = UserDAO.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || password == null)
			throw new ServletException("[LoginServlet] Illegal invocation no username and/or passwrod");

		User user = userDao.login(username, password);
		if (user == null) {
			ctx.getRequestDispatcher(failurePage).forward(request, response);
			return;
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);

		response.sendRedirect(successPage);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ctx.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
	}

}
