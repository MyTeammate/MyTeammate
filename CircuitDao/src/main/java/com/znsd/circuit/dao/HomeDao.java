package com.znsd.circuit.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Power;

@MapperScan
public interface HomeDao {
	//查询所有树形菜单
    public List<Power> selectAllPower(Integer nid);
}
