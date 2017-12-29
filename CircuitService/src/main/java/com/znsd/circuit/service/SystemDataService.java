package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Systemsetting;

public interface SystemDataService {
	//数据字典分页
    public List<Systemsetting> listSystemsetting(Map<String, Object> map);
    
    //数据字典总数
    public int systemsettingCount();
    
  //添加数据字典数据
    public int addSystemsetting(Systemsetting system);
}
