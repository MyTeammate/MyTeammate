package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;

public interface SystemRoleDao {
	//查询所以角色
    public int systemRoleCount(Map<String, Object> map);
    
    //查询所以角色信息
    public List<Systemrole> listSystemRole(Map<String, Object> map);
    
    //验证角色编号是否重复
    public Systemrole verifyCoding(Map<String,Object> map);
    
    //验证角色名称是否重复
    public Systemrole verifyName(Map<String,Object> map);
    
    //角色增加
    public int addRole(Map<String,Object> map);
    
    //禁用启用
    public int stateRole(Map<String,Object> map);
    
    //根据id查询角色信息
    public Systemrole queryRole(int id);
    
    //修改角色
    public int updateRole(Map<String,Object> map);
    
    //删除角色
    public int deleteRole(int id);
}
