package com.znsd.circuit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.InspectionService;
import com.znsd.circuit.service.SystemParamService;
import com.znsd.circuit.service.ThreadService;
import com.znsd.circuit.service.TowerService;
import com.znsd.circuit.util.Pager;

@Controller
public class InspectionController {
	
	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private SystemParamService systemParamService;
	
	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private TowerService towerService;
	
	
	
	/*
	 * 进入 巡检任务 制定与分配页面
	 */
	@RequestMapping(value="inspectionMakeAllot")
	public String intoMakeAllot(){
		return "inspectionMakeAllot";
	}
	
	/*
	 * 进入 巡检任务 任务执行与回执
	 */
	@RequestMapping(value="inspectionExecuteReceipt")
	public String intoExecuteReceipt(){
		return "inspectionExecuteReceipt";
	}
	
	/*
	 * 进入   制定巡检任务页面
	 */
	@RequestMapping(value="makeInspection")
	public String intoMakeInspection(){
		return "makeInspection";
	}
	
	/*
	 * 进入  巡检任务回执录入界面
	 */
	@RequestMapping(value="receiptInspection")
	public String intoReceiptInspection(int taskId,HttpSession session){
		session.setAttribute("receiptId", taskId);
		return "receiptInspection";
	}
	
	/*
	 * 所有  巡检任务状态
	 */
	@ResponseBody
	@RequestMapping(value="getInspectionParam")
	public List<Systemparam> getSystemParam(){
		return inspectionService.getSystemParam("TASK_STATE");
	}
	
	/*
	 * 所有线路
	 */
	@ResponseBody
	@RequestMapping(value="getAllThread")
	public List<Threads> getAllThread(){
		return inspectionService.getAllThread();
	}	
	
	/*
	 * 根据线路id得到所属杆塔
	 */
	@ResponseBody
	@RequestMapping(value="getThreadTower")
	public Threads getThreadTower(@RequestParam int id){
		return inspectionService.getThreadTower(id);
	}
	
	
	/*
	 * 通过taskId获得所属杆塔
	 */
	@ResponseBody
	@RequestMapping(value="getTowerByTaskId")
	public Map<String, Object> getTowerByTaskId(HttpSession session){
		int taskId = session.getAttribute("receiptId") == null ? 0 : (int)session.getAttribute("receiptId");
		// 根据任务taskId获得线路
		Threads thread = inspectionService.getThreaddByTask(taskId);
		session.setAttribute("inspectionThreadId", thread.getId());
		// 通过线路threadId获得所有杆塔
		List<Tower> towers = inspectionService.getTowerByThread(thread.getId());
		Map<String, Object> map = new HashMap<>();
		map.put("thread", thread);
		map.put("towers", towers);
		return map;
	}
	
	
	/*
	 * 所有可用巡检员
	 */
	@ResponseBody
	@RequestMapping(value="getInspectionStaff")
	public List<User> getInspectionStaff(){
		return inspectionService.getInspectionStaff("inspection_staff");
	}
	
	/*
	 * 得到所有缺陷类型
	 */
	@ResponseBody
	@RequestMapping(value="getAllFlaw")
	public List<Flaw> getAllFlaw(){
		return inspectionService.getAllFlaw();
	}
	
	/*
	 * 缺陷等级
	 */
	@ResponseBody
	@RequestMapping(value="getFlawGrade")
	public List<Systemparam> getGradeParam(){
		return inspectionService.getSystemParam("GRADE_FLAW");
	}
	
	/*
	 * 得到杆塔缺陷
	 */
	@ResponseBody
	@RequestMapping(value="getTowerFlaw")
	public Flawconfirm getTowerFlaw(Flawconfirm flawconfirm,HttpSession session){
		int taskId = (int)session.getAttribute("receiptId");
		flawconfirm.setTaskId(taskId);
		Flawconfirm f = inspectionService.getTowerFlaw(flawconfirm);
		System.out.println("flawId:"+f);
		return f;
	}
	
	
	/*
	 * 分页查询所有巡检数据
	 */
	@ResponseBody
	@RequestMapping(value="getInspectionPage")
	public Map<String, Object> getInspectionPage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,String operate,
			Inspection inspection,String startDate,String endDate,
			HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return null;
		}
		/*System.out.println("taskcoding:"+inspection.getCoding()+",threadcoding:"+inspection.getThread()+",state:"+inspection.getState());
		System.out.println("creater:"+inspection.getCreater()+",startDate:"+startDate+",endDate:"+endDate);*/
		Pager<Inspection> pager = inspectionService.getInspectionPage(pageIndex, pageSize,user.getId(),operate,inspection,startDate,endDate);
		Map<String, Object> map = new HashMap<>();
		map.put("total", pager.getSumSize());
		map.put("rows", pager.getData());
		return map;
	}
	
	/*
	 * 制定巡检任务
	 */
	@ResponseBody
	@RequestMapping(value="saveInspection")
	public boolean saveInspection(Inspection inspection,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		inspection.setCreater(user.getId()+"");
		inspectionService.makeInspection(inspection);
		return true;
	}
	
	/*
	 * 分配巡检任务
	 */
	@ResponseBody
	@RequestMapping(value="allotInspection")
	public boolean allotInspection(int taskId,String users,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}				
		String[] s = users.split(",");
		int[] userId=new int[s.length];
		int count=0;
		for (int i = 0; i < s.length; i++) {
			userId[count++]=Integer.parseInt(s[i]);
		}
		inspectionService.allotInspection(taskId, userId, user.getId());
		return true;
	}
	
	/*
	 * 取消巡检任务
	 */
	@ResponseBody
	@RequestMapping(value="cancelInspection")
	public boolean cancelInspection(@RequestParam("taskId") int taskId,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("coding", "INSPECTION_STATE");
		map.put("creater", user.getId());
		map.put("taskId", taskId);
		map.put("settingName", "已取消");
		inspectionService.updateInspectionState(map);
		inspectionService.updateInspectionDate(map);
		return true;
	}
	
	
	/*
	 * 执行 巡检任务
	 */
	@ResponseBody
	@RequestMapping(value="executeInspection")
	public boolean executeInspection(@RequestParam("taskId") int taskId,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("coding", "TASK_STATE");
		map.put("creater", user.getId());
		map.put("taskId", taskId);
		map.put("settingName", "执行中");
		inspectionService.updateInspectionState(map);
		inspectionService.updateInspectionDate(map);
		return true;
	}
	
	/*
	 *  保存回执录入
	 */
	@ResponseBody
	@RequestMapping(value="saveExecuteReceipt")
	public boolean saveExecuteReceipt(Flawconfirm flawconfirm,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		/*if (flawconfirm.getFlawId()=="") {
			flawconfirm.setFlawId(null);
		}
		if (flawconfirm.getFlawGrade()=="") {
			flawconfirm.setFlawGrade(null);
		}*/
		flawconfirm.setUserId(user.getId());
		int taskId = session.getAttribute("receiptId") == null ? 0:(int)session.getAttribute("receiptId");
		int threadId = (int)session.getAttribute("inspectionThreadId");
		flawconfirm.setTaskId(taskId);
		flawconfirm.setThreadId(threadId);
		if(inspectionService.checkFlawRecord(flawconfirm)>0){
			// 修改
			inspectionService.updateFlawConfirm(flawconfirm);
			Map<String, Object> map = new HashMap<>();
			map.put("creater", user.getId());
			map.put("taskId", taskId);
			inspectionService.updateInspectionDate(map);
		}else{
			// 第一次保存
			inspectionService.saveInspectionFlaw(flawconfirm);
		}
		return true;
	}
	
	@RequestMapping("/inspectionTaskQuery")
	public String inspectionTakQuery(@RequestParam("id")int id,Model model) {
		Inspection inspection = inspectionService.getInspectionTaskById(id);
		Systemparam sp = systemParamService.getSystemparamById(inspection.getTask().getStateInteger());
		Task task = inspection.getTask();
		task.setState(sp.getSettingName());
		task.setCreatedDate(task.getCreatedDate().split(" ")[0]);
		inspection.setTask(task);
		Threads threads = threadService.getThreadById(inspection.getThreadId());
		List<Tower> towers = inspectionService.getTowerByThread(inspection.getThreadId());
		List<User> users =  inspectionService.getInspectionTackStaff(id);
		if(users.size()==0) {
			model.addAttribute("staffs", "无");
		}else {
			model.addAttribute("staffs", users);
		}
		model.addAttribute("threads", threads);
		model.addAttribute("inspection", inspection);
		model.addAttribute("towers", towers);
		return "inspectionTaskQuery";
	}
	
	@RequestMapping("/onclickTowerFlawInfo")
	@ResponseBody
	public Flawconfirm  onclickTowerFlawInfo(@RequestParam("towerCoding")String towerCoding,@RequestParam("taskId")int taskId) {
		Tower tower = towerService.checkCoding(towerCoding);
		Flawconfirm  fc = inspectionService.getFlawInfoByTowerId(tower.getId(),taskId);
		return fc;
	}
	
	
	/*
	 * 巡检任务上传回执
	 */
	@ResponseBody
	@RequestMapping(value="executeReceipt")
	public boolean executeReceipt(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		int taskId = session.getAttribute("receiptId") == null ? 0:(int)session.getAttribute("receiptId");
		inspectionService.updateFlawRecord(taskId);
		Map<String, Object> map = new HashMap<>();
		map.put("coding", "TASK_STATE");
		map.put("creater", user.getId());
		map.put("taskId", taskId);
		map.put("settingName", "已完成");
		inspectionService.updateInspectionState(map);
		inspectionService.updateInspectionDate(map);
		return true;
	}
}
