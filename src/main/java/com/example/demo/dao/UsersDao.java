package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.mapping.Users;

@Repository
public interface UsersDao {

	/**
	 * 
	 * @author lvguangquan
	 * @time 2017年8月16日下午7:30:48
	 * @param phoneNumber
	 *            电话号码
	 * @return
	 */
	List<Users> selectByPhone(@Param("phoneNumber") String phoneNumber);

}