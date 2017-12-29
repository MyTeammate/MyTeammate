package com.znsd.circuit.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.LineDao;
import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.service.LineService;
import com.znsd.circuit.util.Operation;
@Service
public class LineServiceImpl implements LineService {

	@Autowired
	private LineDao lineDao;

	@Override
	public Map<String,Object> pageSelectLine(int page,int rows,Line line) {
		Map<String,Object> params = new HashMap<String,Object>();
		Operation operation = new Operation();
		
		
		params.put("page", (page-1)*rows);
		params.put("row", rows);
		params.put("line", line);
		List<Line> lines = lineDao.pageSelectLine(params);
		int total = lineDao.getLineTotal(params);
		for (Line line2 : lines) {
			line2.setStateString(line2.getState()==0?"启用":"禁用");
			line2.setOperation("<a href='javascript:onclick=intoThread()'>管理线路 </a>&nbsp;&nbsp;|&nbsp;&nbsp;"+operation.getOperation(line2.getState()));
		}
		params.put("rows", lines);
		params.put("total", total);
		
		return params;
	}

	@Override
	public Line checkCoding(String coding) {
		return lineDao.checkCoding(coding);
	}

	@Override
	public int insertLine(Line line) {
		lineDao.insertLine(line);
		return line.getId();
	}

	@Override
	public List<Tower> getLineAllTowers(Line line) {
		return lineDao.getLineAllTowers(line);
	}
	
	
	
}
