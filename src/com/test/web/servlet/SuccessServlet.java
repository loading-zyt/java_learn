package com.test.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.domain.User;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getAttribute("user");

		if (user != null) {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("login succeed! welcome " + user.getUsername());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
