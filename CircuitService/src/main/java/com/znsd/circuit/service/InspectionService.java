package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.model.Systemparam;

public interface InspectionService {
	
	/**获取  巡检任务巡检状态
	 * @return
	 */
	public List<Systemparam> getInspectionParam();
	
	/**得到分页的总条数
	 * @return
	 */
	public int getInspectionPageCount();
	
	/**分页查询
	 * @param map
	 * @return
	 */
	public Pager<Inspection> getInspectionPage(int pageIndex,int pageSize);
}
