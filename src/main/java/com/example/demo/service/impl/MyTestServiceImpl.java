package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDao;
import com.example.demo.mapping.Users;
import com.example.demo.service.MyTestService;

@Service
public class MyTestServiceImpl implements MyTestService {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MyTestServiceImpl.class);

	// @Override
	// public List<Users> getUsers(String phoneNumber) {
	// Connection conn = null;
	// PreparedStatement pstm = null;
	// ResultSet result = null;
	// List<Users> list = new ArrayList<Users>();
	// try {
	// Long startTime = System.currentTimeMillis();
	// conn = JdbcUtils.getConnection();
	// String usersSql = "select
	// id,creat_time,phone_number,password,type,is_enable from users where
	// phone_number=?";
	// pstm = conn.prepareStatement(usersSql);
	// conn.setAutoCommit(false);// 将自动提交关闭
	// pstm.setString(1, phoneNumber);
	// result = pstm.executeQuery();
	// Long endTime = System.currentTimeMillis();
	// while (result.next()) {
	// Users users = new Users();
	// users.setId(result.getLong("id"));
	// users.setPhoneNumber(result.getString("phone_number"));
	// users.setPassword(result.getString("password"));
	// list.add(users);
	// }
	// log.info("查询users,用时：" + (endTime - startTime));
	// return list;
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// } finally {
	// if (pstm != null || conn != null || result != null) {
	// try {
	// JdbcUtils.release(conn, pstm, result);
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// }
	// }
	// }
	// }

	@Override
	public List<Users> getUsers(String phoneNumber) {
		log.info("开始访问数据库，查询usersDao.selectByPhone");
		long beginTime = System.currentTimeMillis();
		List<Users> user = usersDao.selectByPhone(phoneNumber);
		log.info("结束数据库访问，耗时：{}", System.currentTimeMillis() - beginTime);
		return user;
	}

}
