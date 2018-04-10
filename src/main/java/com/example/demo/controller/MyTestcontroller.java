package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapping.Users;
import com.example.demo.service.MyTestService;

@RestController
@RequestMapping("/v3/test/performance")
public class MyTestcontroller {
	private static final Logger log = LoggerFactory.getLogger(MyTestcontroller.class);
	@Autowired
	private MyTestService myTestService;

	@RequestMapping(value = "/testUsers", method = RequestMethod.GET)
	public List<Users> testUsers(String phoneNumber) {
		log.info("进入方法：testUsers");
		List<Users> list = myTestService.getUsers(phoneNumber);
		return list;
	}
}
