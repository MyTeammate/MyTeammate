package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.circuit.model.Systemparam;

public interface SystemParamService {
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
    
    //根据配置参数Id获取参数信息
    public Systemparam getSystemparamById(@Param("id")int paramId);
}
