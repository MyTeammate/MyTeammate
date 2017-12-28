package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.User;

public interface HomeService {
	
	/**树形菜单查询
	 * @param nid
	 * @return
	 */
	public List<Power> selectAllPower(Integer nid);
	
	/**用户登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User login(Map<String,Object> map);
	
	/**记录当前登录的时间
	 * @return
	 */
	public int loginDate(Map<String,Object> map2);
}
