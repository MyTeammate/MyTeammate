package com.znsd.circuit.aop;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.znsd.circuit.model.Systemlog;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemUserService;

public class AopDefinition implements HandlerInterceptor {
	@Autowired
    private SystemUserService systemUserService;
	
	//全部完成后处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		User user=(User) request.getSession().getAttribute("user");
		user.getId();
		String logId = request.getParameter("logId");
		int id=Integer.parseInt(logId);
		 	if(id==9999) {
				Systemlog log=new Systemlog();
				log.setUserId(user.getId());
				log.setId(id);
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				log.setCreateDate(time);
				log.setRemark("登陆系统");
				int i=systemUserService.loginLog(log);
			}else if(id==10000) {
				Systemlog log=new Systemlog();
				log.setUserId(user.getId());
				log.setId(id);
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				log.setCreateDate(time);
				log.setRemark("退出系统");
				int i=systemUserService.loginLog(log);
			}else if(id!=0) {
				Systemlog log=new Systemlog();
				log.setUserId(user.getId());
				log.setId(id);
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				log.setCreateDate(time);
				int i=systemUserService.addLog(log);
			}
		/*MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
		System.out.println("methodName="+methodNameResolver.getHandlerMethodName(request));*/
	}

	//拦截后处理
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	//拦截前处理
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        if(url.indexOf("/login")>=0){  
            return true;  
        }  
        if(url.indexOf("/defined")>=0){  
            return true;  
        } 
        if(url.indexOf("/logout")>=0){  
            return true;  
        }  
        if(url.indexOf("/prepareLogout")>=0){  
            return true;  
        } 
        //获取Session  
        HttpSession session = request.getSession();  
        User user = (User)session.getAttribute("user");  
        if(user != null){ 
            return true;  
        }  
        //不符合条件的，跳转到登录界面  
        response.sendRedirect("http://localhost:8080/Circuit/login");
        return false;  
	}
	
	
  
  

}
