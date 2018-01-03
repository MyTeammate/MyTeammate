package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;

@MapperScan
public interface SystemUserDao {
	//分页总数量
    public int systemUserCount();
    
    //分页查询
    public List<User> listSystemUser(Map<String, Object> map);

    //查询所有角色名称
    public List<Systemrole> selectSysteUser();
}
