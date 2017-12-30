package com.znsd.circuit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.znsd.circuit.model.User;
import com.znsd.circuit.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 修改用户个人资料
	@RequestMapping("/updateUserPost")
	public String updateUserPost(User user, HttpSession session, @RequestParam("id") int id,
			@RequestParam("age") int age, @RequestParam("phone") String phone, @RequestParam("sex") String sex,
			@RequestParam("email") String email, @RequestParam("userName") String userName,
			@RequestParam("name") String name, @RequestParam("entryDate") String entryDate,
			@RequestParam("leaveDate") String leaveDate) {
		user.setUserName(user.getUserName());
		user.setName(user.getName());
		user.setEntryDate(user.getEntryDate());
		user.setLeaveDate(user.getLeaveDate());
		user.setSex(user.getSex());
		user.setEmail(user.getEmail());
		user.setPhone(user.getPhone());
		user.setAge(user.getAge());
		userService.userUpdate(user);
		session.setAttribute("user", user);
		return "personalFile";
	}

	// 修改密码
	@RequestMapping("/updatePassword")
	public String updatePassword(User user, HttpSession session, @RequestParam("id") int id,
			@RequestParam("passWord") String password, @RequestParam("repassword") String repassword) {
		user.setPassWord(repassword);
		userService.updatePassword(user);
		session.setAttribute("user", user);
		return "login";
	}
}
