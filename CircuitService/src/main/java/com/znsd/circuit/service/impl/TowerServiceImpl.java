package com.znsd.circuit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.TowerDao;
import com.znsd.circuit.model.Line;
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
	public List<Tower> getAllTowerData(Line line,String flag) {;
		List<Tower> datas = null;
		if(line!=null&&line.getCoding()!=null){
			String coding = line.getCoding();
			List<Tower> datas2 = new ArrayList<Tower>();
			String regex = "\\d";
			String regex1 = "[a-zA-Z]";
			String zimu = line.getCoding().replaceAll(regex, "");
			String shuziStr = line.getCoding().replaceAll(regex1, "");
			if(!shuziStr.equals("")) {
				int shuzi;
				try {
					shuzi = Integer.parseInt(shuziStr);
				
					line.setCoding("%"+zimu+"%");
					datas = towerDao.getAllTowerData(line);
					for (Tower tower : datas) {
						String zimu2 = tower.getCoding().replaceAll(regex, "");
						int shuzi2 = Integer.parseInt(tower.getCoding().replaceAll(regex1, ""));
						if(zimu.equals(zimu2)&&(coding.length()==tower.getCoding().length())) {
                            if(flag!=null&&flag.equals("true")) {
									if(shuzi>=shuzi2) {
										datas2.add(tower);
									}
							}else {
                                if(line.getEndTower()!=null&&line.getEndTower()!="") {
                                	if(shuzi<=shuzi2) {
										datas2.add(tower);
									}
                            	}else {
									if(shuzi<shuzi2) {
										datas2.add(tower);
									}
                            	}
							}
							
						}
					}
				} catch (NumberFormatException e) {
					return null;
				}
			}
			return datas2;
		}else {
			datas = towerDao.getAllTowerData(line);
		}
		return datas;
	}

	@Override
	public void updateTowerLineId(Tower tower) {
		towerDao.updateTowerLineId(tower);
	}

	@Override
	public List<Tower> getTowerByLikeCoding(String coding) {
		return towerDao.getTowerByLikeCoding(coding);
	}

	@Override
	public List<Tower> getLineTowersById(int id) {
		return towerDao.getLineTowersById(id);
	}

	@Override
	public void setTowerState(Tower tower) {
		towerDao.setTowerState(tower);
	}

	@Override
	public Tower getTowerById(int id) {
		return towerDao.getTowerById(id);
	}

	@Override
	public void updateTower(Tower tower) {
		towerDao.updateTower(tower);
	}

	@Override
	public void setDeleteFlag(int id) {
		towerDao.setDeleteFlag(id);
	}

}
