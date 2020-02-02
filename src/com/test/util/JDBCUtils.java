package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * JDBC工具类，用Durid连接池
 */
public class JDBCUtils {

	private static DataSource ds;

	static {
		try {
			// 加载配置文件
			Properties pro = new Properties();
			InputStream iStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			pro.load(iStream);
			
			// 初始化连接对象
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 获取连接池对象
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/*
	 * 获取连接Connection对象
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
