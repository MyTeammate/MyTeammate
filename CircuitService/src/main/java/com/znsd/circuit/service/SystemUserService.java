package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;

public interface SystemUserService {
	//分页总数量
    public int systemUserCount();
    
    //分页查询
    public List<User> listSystemUser(Map<String, Object> map);

  //查询所有角色名称
    public List<Systemrole> selectSysteUser();
}
