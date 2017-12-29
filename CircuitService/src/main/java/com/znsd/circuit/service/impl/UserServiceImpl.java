package com.znsd.circuit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.znsd.circuit.dao.UserDao;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void userUpdate(User user) {		
		userDao.userUpdate(user);
	}

	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}
}
