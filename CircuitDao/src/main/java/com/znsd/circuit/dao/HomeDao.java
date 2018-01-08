package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.User;

@MapperScan
public interface HomeDao {
    /**查询所有树形菜单
     * @param nid
     * @return
     */
    public List<Power> selectAllPower(Map<String,Object> map);
    
    /**用户登录
     * @param userName
     * @param passWord
     * @return
     */
    public User login(Map<String,Object> map);
    
    /**记录当前登录的时间
     * @param time
     * @return
     */
    public int loginDate(Map<String,Object> map2);
}
