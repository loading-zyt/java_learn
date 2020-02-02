package com.test.test;

import org.junit.jupiter.api.Test;

import com.test.dao.UserDao;
import com.test.domain.User;

class UserDaoTest {

	@Test
	void test() {
		User testUser = new User();
		testUser.setUsername("admin");
		testUser.setPassword("test");

		UserDao dao = new UserDao();
		User user = dao.login(testUser);
		System.out.println(user);
	}

}
