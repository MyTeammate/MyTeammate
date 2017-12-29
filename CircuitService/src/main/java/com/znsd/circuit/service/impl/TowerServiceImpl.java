package com.znsd.circuit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.TowerDao;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.service.TowerService;
@Service
public class TowerServiceImpl implements TowerService {

	@Autowired
	private TowerDao towerDao;

	@Override
	public Tower checkCoding(String coding) {
		return towerDao.checkCoding(coding);
	}

	@Override
	public void insertTower(Tower tower) {
		towerDao.insertTower(tower);
	}

	@Override
	public List<Tower> getAllTowerData(String coding) {;
		List<Tower> datas = null;
		if(coding!=null){
			List<Tower> datas2 = new ArrayList<Tower>();
			String regex = "\\d";
			String regex1 = "[a-zA-Z]";
			String zimu = coding.replaceAll(regex, "");
			String shuziStr = coding.replaceAll(regex1, "");
			if(!shuziStr.equals("")) {
				int shuzi = Integer.parseInt(shuziStr);
				datas = towerDao.getAllTowerData(coding==null?null:"%"+zimu+"%");
				for (Tower tower : datas) {
					String zimu2 = tower.getCoding().replaceAll(regex, "");
					int shuzi2 = Integer.parseInt(tower.getCoding().replaceAll(regex1, ""));
					if(zimu.equals(zimu2)&&(coding.length()==tower.getCoding().length())&&shuzi<shuzi2) {
						datas2.add(tower);
					}
				}
			}
			return datas2;
		}else {
			datas = towerDao.getAllTowerData(null);
		}
		return datas;
	}

	@Override
	public void updateTowerLineId(Tower tower) {
		towerDao.updateTowerLineId(tower);
	}

	
	
	
	
	
	
}
