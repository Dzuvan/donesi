package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.User;

public class AuthorizationFilter implements Filter {

	private String loginPage = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		boolean isStaticResource = req.getRequestURI().contains("/resources/");
		boolean isRegistration = req.getRequestURI().contains("signup");

		String path = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		if (path.indexOf("/login") != -1 || isStaticResource || isRegistration) {
			chain.doFilter(req, response);
			return;
		}

		HttpSession session = req.getSession(false);
		if (session == null) {
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			User user = (User) session.getAttribute("user");
			if (user == null || user.getUsername() == null) {
				request.getRequestDispatcher(loginPage).forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		loginPage = cfg.getInitParameter("login-page");
		if (loginPage == null)
			throw new ServletException("AuthorizationFilter: missing parameter 'login-page'");
	}

	@Override
	public void destroy() {

	}

}
