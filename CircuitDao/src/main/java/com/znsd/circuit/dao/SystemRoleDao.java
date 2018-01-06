package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;

public interface SystemRoleDao {
	//查询所以角色
    public int systemRoleCount();
    
    //查询所以角色信息
    public List<Systemrole> listSystemRole(Map<String, Object> map);
    
    //验证角色编号是否重复
    public Systemrole verifyCoding(String coding);
    
    //验证角色名称是否重复
    public Systemrole verifyName(String name);
}
