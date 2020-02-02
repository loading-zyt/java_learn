package com.test.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.domain.User;
import com.test.util.JDBCUtils;

/*
 * 操作数据库UserDemo表
 */
public class UserDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	/**
	 * 
	 * @param loginUser
	 * @return
	 */
	public User login(User loginUser) {
		try {
			String sqlString = "select * from [dbo].[User] where username=? and password=?";
			User user = template.queryForObject(sqlString, new BeanPropertyRowMapper<User>(User.class),
					loginUser.getUsername(), loginUser.getPassword());
			return user;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}
