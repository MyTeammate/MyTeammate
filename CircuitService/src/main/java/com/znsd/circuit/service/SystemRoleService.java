package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;

public interface SystemRoleService {
	//查询所以角色
    public int systemRoleCount(Map<String, Object> map);
    
  //查询所以角色信息
    public List<Systemrole> listSystemRole(Map<String, Object> map);
    
  //验证角色编号是否重复
    public Systemrole verifyCoding(Map<String,Object> map);
    
    //验证角色名称是否重复
    public Systemrole verifyName(Map<String,Object> map);
    
  //增加角色
    public int addRole(Systemrole role);
    
  //启用/禁用
    public int stateRole(Map<String,Object> map);
    
  //修改角色
    public int updateRole(Map<String,Object> map);
    
  //删除角色
    public int deleteRole(int id);
    
  //查询角色信息
    public Systemrole queryRole(int id);
    
  //根据姓名和状态模糊查询
    public List<Systemrole> likeRole(Map<String,Object> map);
}
