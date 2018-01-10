package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.FlawCont;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Pager;

@MapperScan
public interface FlawConfirmService {

	public List<FlawCont> getFlawConfirmPager(Map<String, Object> map);

	public int getFlawConfirmCount(Map<String, Object> map);


	List<FlawCont> getFlawConfirmAll(String taskcoding, String threadcoding, String towercoding, String flawname,
			String serviceAbility, String flawDesc, String discoverDate, String userId, String flawGrade, int confirmstate,
			int updatedBy);

	public FlawCont flawconfid(int id);

	public boolean updateflawgrade(FlawCont flawCont);
	
	/**第二次确认缺陷等级
	 * @param flawconfirm
	 */
	public void updateFlawconfirmGrade(Flawconfirm flawconfirm);
}
