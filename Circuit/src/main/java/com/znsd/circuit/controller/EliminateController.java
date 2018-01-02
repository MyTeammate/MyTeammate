package com.znsd.circuit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;
import com.znsd.circuit.service.InspectionService;
import com.znsd.circuit.util.MyFlaw;

@Controller
@RequestMapping("/eliminate")
public class EliminateController {

	@Autowired
	private EliminateService eliminateService;

	@Autowired
	private InspectionService inspectionService;

	@RequestMapping("/eliminateflaw")
	public String eliminate() {
		return "eliminate_flaw";
	}

	@RequestMapping("/addeliminateflaw")
	public String eliminates() {
		return "add_eliminate_flaw";
	}

	// 查询出任务
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAll(@RequestParam("page") int page, @RequestParam("rows") int rows, String taskcoding,
			String workbills, String taskstatus, String xiapeople, String startdate, String enddate,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		int taskman = user.getId();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		map.put("userid", taskman);
		Map<String, Object> maps = new HashMap<String, Object>();
		// Map<String, Object> map2 = new HashMap<String, Object>();
		/*
		 * if(""==taskcoding||null==taskcoding||""==workbills||null==workbills||""==
		 * taskstatus||null==taskstatus
		 * ||""==xiapeople||null==xiapeople||""==startdate||null==startdate||""==enddate
		 * ||null==enddate) { int count = eliminateService.getCount(map);//总条数
		 * List<Eliminate> list = eliminateService.getAllTask(map);
		 * System.out.println("。。。。。。。。。。。"+list); maps.put("rows", list);
		 * maps.put("total", count); }else {
		 */
		if ("" != taskcoding || null != taskcoding || "" != workbills || null != workbills || "" != taskstatus
				|| null != taskstatus || "" != xiapeople || null != xiapeople || "" != startdate || null != startdate
				|| "" != enddate || null != enddate) {
			if("" != taskcoding && null != taskcoding) {
				map.put("taskcoding", "%" + taskcoding + "%");
			}
			if("" != workbills && null != workbills) {
				map.put("workbills", "%" + workbills + "%");
			}
			if("" != xiapeople && null != xiapeople) {
				map.put("xiapeople", "%" + xiapeople + "%");
			}
			if(taskstatus!="请选择") {
				map.put("taskstatus", taskstatus);
			}
			
			map.put("startdate", startdate);
			map.put("enddate", enddate);
			System.out.println("//////"+map);
		}

		int count = eliminateService.getCount(map);// 总条数
		List<Eliminate> list = eliminateService.getAllTask(map);
		System.out.println("，，，，，，，，，，，，，，" + list);
		maps.put("rows", list);
		maps.put("total", count);
		// }
		/*
		 * for (Eliminate eliminate : list) { eliminate.
		 * setOperation("<a href='#'>查看</a> | <a href='#'>分配任务</a> | <a href='#'>修改</a> | <a href='#'>取消</a>"
		 * ); }
		 */
		/*
		 * Eliminate eliminate = new Eliminate(); eliminate.setOperation(operation);
		 */

		return maps;
	}

	// 查询单据
	@RequestMapping("/getBills")
	@ResponseBody
	public List<Systemparam> getbills() {
		String str = "bills";
		List<Systemparam> list = eliminateService.getAllBills(str);
		return list;
	}

	// 查询线路管理员
	@RequestMapping("/getLineUser")
	@ResponseBody
	public List<User> getLineUser() {
		List<User> list = eliminateService.getAllLineUser();
		return list;
	}

	// 查询消缺员
	@RequestMapping("/getEliminateUser")
	@ResponseBody
	public List<User> getEliminateUser(Integer id,HttpSession session) {
		session.setAttribute("idd",id);
		String coding = "es_flaw";
		List<User> list = eliminateService.getAlleliminateUser(coding);
		return list;
	}

	@RequestMapping("/getEliminateUserById")
	@ResponseBody
	public List<User> getById(String str) {
		String[] s = str.split(",");
		List<User> list = new ArrayList<User>();
		User user = null;
		for (String string : s) {
			int id = Integer.parseInt(string);
			user = eliminateService.getAllUserEliminate(id);
			list.add(user);
		}
		return list;
	}

	// 修改状态
	@RequestMapping("/updateTaskStatusById")
	public String updateTaskStatusById(Integer id) {
		eliminateService.updateTaskstatus(id);
		return "eliminate_flaw";
	}

	// 查询缺陷确认表
	@RequestMapping("/flawConfirm")
	@ResponseBody
	public Map<String, Object> getFlawConfim(@RequestParam("page") int page, @RequestParam("rows") int rows) {
		Map<String, Object> map = new HashMap<String, Object>();

		int count = eliminateService.getCountByEliminate();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		List<MyFlaw> list = eliminateService.getAllMyFlaw(map);
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}

	// 通过id从巡检缺陷记录表查询已经巡检出的缺陷
	@RequestMapping("/flawConfirmById")
	@ResponseBody
	public List<MyFlaw> getflawConfirmById(String str) {
		String[] s = str.split(",");
		MyFlaw myFlaw = null;
		List<MyFlaw> list = new ArrayList<MyFlaw>();
		for (String string : s) {
			int id = Integer.parseInt(string);
			myFlaw = eliminateService.getAllMyFlawById(id);
			list.add(myFlaw);
		}
		return list;
	}

	// 制定消缺任务
	@RequestMapping("/insertEliminate")
	@ResponseBody
	public String insertEliminate(String taskcoding, String taskname, String taskbills, Integer mid, String taskDesc,
			String taskRemark, String str, String alstr, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		User user = (User) session.getAttribute("user");
		int taskman = user.getId();// 下发人
		String date = (String) session.getAttribute("date");// 登录时间
		System.out.println("登录时间： ：" + date + "下发人   " + taskman + "任务编码：：" + taskcoding + "  任务名称" + taskname
				+ "  任务单据" + taskbills + "  负责人" + mid + "  任务描述" + taskDesc + "  任务备注" + taskRemark + "  消缺员" + str
				+ "  缺陷" + alstr + "  ");
		Map<String, Object> map1 = new HashMap<>();
		map1.put("taskcoding", taskcoding);
		map1.put("taskname", taskname);
		map1.put("taskman", taskman);
		map1.put("date", date);
		map1.put("taskRemark", taskRemark);
		map1.put("time", time);
		map1.put("taskDesc", taskDesc);
		if(str==""||str==null) {
			map1.put("status",4);
			eliminateService.insertTask(map1);
		}else {
			map1.put("status",5);
			eliminateService.insertTask(map1);
		}
		
		System.out.println("。。。。。。。。。。。。。" + taskcoding);
		Task task = eliminateService.selectTaskById(taskcoding);
		int taskid = task.getId();
		/*
		 * map2.put("taskid", taskid); map2.put("mid", mid); map2.put("workBills",
		 * taskbills); map2.put("remark",taskRemark);
		 */
		Eliminate eliminate = new Eliminate();
		eliminate.setTaskId(taskid);
		eliminate.setWorkBills(taskbills);
		eliminate.setmId(mid);
		eliminate.setRemark(taskRemark);
		eliminateService.insertEliminate(eliminate);
		int eid = eliminate.getId();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("eid", eid);
		if(str!=""||str!=null) {
			String[] st = str.split(",");
			for (int i = 0; i < st.length; i++) {
				String string = st[i];
				map2.put("createBy", taskman);
				map2.put("createDate", time);
				map2.put("updateBy", taskman);
				map2.put("updateDate", time);
				if (i == 0) {
					int id = Integer.parseInt(string);
					map2.put("eid", eid);
					map2.put("userId", id);
					map2.put("isReceipter", 0);
					eliminateService.insertFlawStaff(map2);
				} else {
					int id = Integer.parseInt(string);
					map2.put("eid", eid);
					map2.put("userId", id);
					map2.put("isReceipter", 1);
					eliminateService.insertFlawStaff(map2);
				}
			}
		}
		
		Map<String, Object> map3 = new HashMap<>();
		String[] als = alstr.split(",");
		for (String string : als) {
			int id = Integer.parseInt(string);
			map3.put("xtaskid", taskid);
			map3.put("yetid", id);
			/*
			 * map3.put("createBy",taskman); map3.put("createDate",time);
			 * map3.put("updateBy",taskman); map3.put("updateDate",time);
			 * map3.put("status_flag", 0);
			 */
			eliminateService.insertEliminateRecord(map3);
		}
		// map1.put("taskbills",taskbills);
		return "true";
	}

	@RequestMapping("/getAllstatus")
	@ResponseBody
	public List<Systemparam> getAllStatus() {
		return inspectionService.getSystemParam("TASK_STATE");
	}
	//分配的状态下 再分配消缺员
	@RequestMapping("/updateEliminateUserById")
	@ResponseBody
	public String updateEliminateUserById(String str,HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		User user = (User) session.getAttribute("user");
		int loginId = user.getId();
		int id = (int) session.getAttribute("idd");
		eliminateService.deleteFlawStaff(id);
		System.out.println("。。。。。。。。str。。。。。。。"+str);
		String[] s = str.split(",");
		Flawstaff flawStaff = new Flawstaff();
		for (int i = 0; i < s.length; i++) {
			String string = s[i];
			int userid = Integer.parseInt(string);
			
			if(i==0) {
				flawStaff.setIsReceipter(0);
			}else {
				flawStaff.setIsReceipter(1);
			}
			flawStaff.setCreatedBy(loginId);
			flawStaff.setCreatedDate(time);
			flawStaff.setEliminateId(id);
			flawStaff.setUpdatedBy(loginId);
			flawStaff.setUpdatedDate(time);
			flawStaff.setUserId(userid);
			eliminateService.insertintoFlawStaff(flawStaff);
		}
		return "true";
	}
	@RequestMapping("/lookeliminateflaw")
	public String lookEliminate(Integer id) {
		return "see_eliminate_task";
	}
}
