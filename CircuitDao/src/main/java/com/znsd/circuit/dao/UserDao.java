package com.znsd.circuit.dao;

import org.mybatis.spring.annotation.MapperScan;
import com.znsd.circuit.model.User;

@MapperScan
public interface UserDao {

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
