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
    
    //删除选择数据
    public int deleteSystemsetting(int id);
    
    //根据id查询数据字典数据
    public Systemsetting updateSystemsetting(int id);
    
    //根据coding查询数据字典数据
    public Systemsetting updateSystemsetting3(String coding);
    
    //数据字典修改数据
    public int updateSystemsetting2(Systemsetting system);
    
  //启用禁用选择数据
    public int stateSystemsetting(Map<String,Object> map);
}
