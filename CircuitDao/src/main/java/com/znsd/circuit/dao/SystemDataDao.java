package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Systemsetting;

@MapperScan
public interface SystemDataDao {
	//数据字典分页
    public List<Systemsetting> listSystemsetting(Map<String, Object> map);
    
    //数据字典总数量
    public int systemsettingCount();
    
    //添加数据字典数据
    public int addSystemsetting(Systemsetting system);
}
