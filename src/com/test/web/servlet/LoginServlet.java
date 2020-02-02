package com.test.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.test.dao.UserDao;
import com.test.domain.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//
//		User loginUser = new User();
//		loginUser.setUsername(username);
//		loginUser.setPassword(password);

		User loginUser = new User();
		Map<String, String[]> map = req.getParameterMap();
		try {
			BeanUtils.populate(loginUser, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		UserDao userDao = new UserDao();
		User user = userDao.login(loginUser);

		if (user == null) {
			req.getRequestDispatcher("/failServlet").forward(req, resp);
		} else {
			req.setAttribute("user", user);
			req.getRequestDispatcher("/successServlet").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
