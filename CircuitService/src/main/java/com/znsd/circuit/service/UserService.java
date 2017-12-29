package com.znsd.circuit.service;

import com.znsd.circuit.model.User;

public interface UserService {
	/**
	 * 修改个人资料
	 * @param user
	 */
	public void userUpdate(User user);
	
	/**
	 * 修改密码
	 * @param user
	 */
	public void updatePassword(User user);
}
