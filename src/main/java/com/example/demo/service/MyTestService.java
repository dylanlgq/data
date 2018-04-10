package com.example.demo.service;

import java.util.List;

import com.example.demo.mapping.Users;

public interface MyTestService {

	List<Users> getUsers(String phoneNumber);

}
