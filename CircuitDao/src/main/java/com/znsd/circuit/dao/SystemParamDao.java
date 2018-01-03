package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Systemparam;

@MapperScan
public interface SystemParamDao {
	//数据字典参数分页
    public List<Systemparam> listSystemparam(Map<String, Object> map);
    
    //数据字典参数总数量
    public int systemparamCount(int systemsettingId);
    
  //查询数据字典参数
    public Systemparam querySystemparam(Map<String,Object> map);
    
    //增加数据字典参数
    public int addSystemparam(Systemparam param);
    
  //增加数据字典参数
    public int deleteSystemparam(int id);
    
  //修改数据字典参数
    public int updateSystemparam(Map<String,Object> map);
}
