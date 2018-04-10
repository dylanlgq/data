//package com.example.demo.util;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//public class JdbcUtils {
//
//	private static final ThreadLocal<Connection> CONNECTION_HOLDER;
//
//	private static final BasicDataSource DATA_SOURCE = new BasicDataSource();
//
//	private JdbcUtils() {
//	}
//
//	static {
//		CONNECTION_HOLDER = new ThreadLocal<Connection>();
//		String driverClass = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/eyed";
//		String username = "root";
//		String password = "123456";
//		DATA_SOURCE.setDriverClassName(driverClass);
//		DATA_SOURCE.setUrl(url);
//		DATA_SOURCE.setUsername(username);
//		DATA_SOURCE.setPassword(password);
//	}
//
//	public static synchronized Connection getConnection() {
//		Connection conn = CONNECTION_HOLDER.get();
//		if (conn == null) {
//			try {
//				conn = DATA_SOURCE.getConnection();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				CONNECTION_HOLDER.set(conn);
//			}
//		}
//		return conn;
//	}
//
//	// 资源的释放
//	public static void release(Connection conn, PreparedStatement st, ResultSet rs) {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			} finally {
//				rs = null;
//			}
//		}
//		if (st != null) {
//			try {
//				st.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			} finally {
//				st = null;
//			}
//		}
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			} finally {
//				conn = null;
//			}
//		}
//	}
//
//	public static List<Map<String, String>> queryEntityList(String sql, List<String> list, String[] column)
//			throws Exception {
//		List<Map<String, String>> entityList = new ArrayList<>();
//		if (sql.isEmpty() || column.length < 1) {
//			throw new Exception("SQL语句不能为空,并且列的长度不能小于1");
//		}
//		Connection conn = getConnection();
//		PreparedStatement prepareStatement = null;
//		ResultSet result = null;
//		try {
//			prepareStatement = conn.prepareStatement(sql.toString());
//			if (list != null && list.size() > 0) {
//				for (int i = 1; i <= list.size(); i++) {
//					prepareStatement.setString(i, list.get(i - 1));
//				}
//			}
//			result = prepareStatement.executeQuery();
//			Map<String, String> mapList = null;
//			while (result.next()) {
//				mapList = new HashMap<>();
//				for (Object col : column) {
//					mapList.put((String) col, result.getString((String) col));
//				}
//				entityList.add(mapList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			release(conn, prepareStatement, result);
//		}
//		return entityList;
//	}
//
//}