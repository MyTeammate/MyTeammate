package com.znsd.circuit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;
import com.znsd.circuit.service.InspectionService;
import com.znsd.circuit.util.MyFlaw;
import com.znsd.circuit.util.SeeEliminate;

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
			String workbills, String taskstatus, String xiapeople, String startdate, String enddate,
			HttpSession session, String operate) {
		Map<String, Object> map = new HashMap<String, Object>();

		User user = (User) session.getAttribute("user");
		int taskman=0;
		if(user!=null) {
		 taskman = user.getId();
		}
		
		// 找到角色对象
		Systemrole systemRole = eliminateService.selectRoleByUserId(taskman);
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		map.put("userid", taskman);
		map.put("operate", operate);
		// 塞角色编码
		map.put("coding", systemRole.getCoding());
		//map.put("taskman", taskman);
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
			if ("" != taskcoding && null != taskcoding) {
				map.put("taskcoding", "%" + taskcoding + "%");
			}
			if ("" != workbills && null != workbills) {
				map.put("workbills", "%" + workbills + "%");
			}
			if ("" != xiapeople && null != xiapeople) {
				map.put("xiapeople", "%" + xiapeople + "%");
			}
			if (taskstatus != "请选择") {
				map.put("taskstatus", taskstatus);
			}

			map.put("startdate", startdate);
			map.put("enddate", enddate);

		}

		int count = eliminateService.getCount(map);// 总条数
		List<Eliminate> list = eliminateService.getAllTask(map);
System.out.println("/////////////////////////"+list);
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
	public List<User> getEliminateUser(Integer id, HttpSession session) {
		session.setAttribute("idd", id);
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
		if (str == "" || str == null) {
			map1.put("status", 4);
			eliminateService.insertTask(map1);
		} else {
			map1.put("status", 5);
			eliminateService.insertTask(map1);
		}

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
		if (str != "" || str != null) {
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
					map2.put("isReceipter", "是");
					eliminateService.insertFlawStaff(map2);
				} else {
					int id = Integer.parseInt(string);
					map2.put("eid", eid);
					map2.put("userId", id);
					map2.put("isReceipter", "否");
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
	public List<Systemparam> getAllStatus(String coding) {
		return inspectionService.getSystemParam(coding);
	}

	// 分配的状态下 再分配消缺员
	@RequestMapping("/updateEliminateUserById")
	@ResponseBody
	public String updateEliminateUserById(String str, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		User user = (User) session.getAttribute("user");
		int loginId = user.getId();
		int id = (int) session.getAttribute("idd");
		eliminateService.deleteFlawStaff(id);

		String[] s = str.split(",");
		Flawstaff flawStaff = new Flawstaff();
		for (int i = 0; i < s.length; i++) {
			String string = s[i];
			int userid = Integer.parseInt(string);

			if (i == 0) {
				flawStaff.setIsReceipter("是");
			} else {
				flawStaff.setIsReceipter("否");
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
	public String lookEliminate(Integer eliminateId, HttpServletRequest request, Model model, HttpSession session) {
		SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
		// System.out.println("....."+seeEliminate);
		User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
		seeEliminate.setTaskfuzeUser(user.getName());
		List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
		// 保存任务id 用来获取当前任务的所有缺陷
		session.setAttribute("eliminateId", seeEliminate.getTaskId());
		model.addAttribute("userList", userList);
		request.setAttribute("seeEliminate", seeEliminate);

		return "see_eliminate_task";
	}

	// 一个任务对应的已选择的消缺
	@RequestMapping("/selectEliminateById")
	@ResponseBody
	public List<MyFlaw> selectEliminateById(HttpSession session) {
		int id = (int) session.getAttribute("eliminateId");
		System.out.println("id++++++" + id);
		List<MyFlaw> list = eliminateService.seeEliminateBytaskId(id);
		System.out.println("。。。。。。" + list);
		return list;
	}

	// 回执了
	@RequestMapping("/execution_receipt")
	public String skipExecutionReceipt() {
		return "eliminate_execution_receipt";
	}

	// 回执的分页+模糊查询
	@RequestMapping("/execution_task")
	@ResponseBody
	public Map<String, Object> getTaskByCondition(@RequestParam("page") int page, @RequestParam("rows") int rows,
			String receipt_taskcoding, String receipt_bills, String receipt_xiapeople, String receipt_startdate,
			String receipt_enddate, HttpSession session, String operate) {
		Map<String, Object> map = new HashMap<>();
		User user = (User) session.getAttribute("user");

		int taskman = user.getId();// 判断是谁下发的
		// 找到角色对象
		Systemrole systemRole = eliminateService.selectRoleByUserId(taskman);

		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		map.put("userid", taskman);
		map.put("operate", operate);
		// 塞角色编码
		map.put("coding", systemRole.getCoding());
		Map<String, Object> maps = new HashMap<String, Object>();
		if ("" != receipt_taskcoding && null != receipt_taskcoding) {
			map.put("receipt_taskcoding", "%" + receipt_taskcoding + "%");
		}
		if ("" != receipt_xiapeople && null != receipt_xiapeople) {
			map.put("receipt_xiapeople", "%" + receipt_xiapeople + "%");
		}
		if (receipt_bills != "请选择") {
			map.put("receipt_bills", receipt_bills);
		}
		if ("" != receipt_startdate && null != receipt_startdate) {
			map.put("receipt_startdate", receipt_startdate);
		}
		if ("" != receipt_enddate && null != receipt_enddate) {
			map.put("receipt_enddate", receipt_enddate);
		}

		int count = eliminateService.getCountByCondition(map);// 总条数
		List<Eliminate> list = eliminateService.getAllTaskByCondition(map);
		System.out.println("..........." + list);
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}

	// 回执的查看
	@RequestMapping("/lookeliminateflaw_receipte")
	public String lookEliminate_receipte(Integer eliminateId, HttpServletRequest request, Model model,
			HttpSession session) {
		SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
		// System.out.println("....."+seeEliminate);
		User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
		seeEliminate.setTaskfuzeUser(user.getName());
		List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
		session.setAttribute("eliminateId", seeEliminate.getTaskId());
		model.addAttribute("userList", userList);
		request.setAttribute("seeEliminate", seeEliminate);

		return "receipte_see_eliminate_task";
	}

	// 回执的执行
	// 修改状态
	@RequestMapping("/execu_updateTaskStatusById")
	@ResponseBody
	public String execu_updateTaskStatusById(Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int userid = user.getId();
		Flawstaff flawStaff = eliminateService.selectEliminateByUserId(id, userid);

		if (null != flawStaff && flawStaff.getIsReceipter().equals("是")) {
			eliminateService.execu_updateTaskstatus(id);
			return "true";
		}
		return "false";
	}

	// 保存回执录入之前查看
	@RequestMapping("/save_eliminateflaw_receipte")
	public String save_Eliminate_receipte(Integer eliminateId, HttpServletRequest request, Model model,
			HttpSession session) {
		SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
		// System.out.println("....."+seeEliminate);
		User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
		seeEliminate.setTaskfuzeUser(user.getName());
		List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
		session.setAttribute("eliminateId", seeEliminate.getTaskId());
		model.addAttribute("userList", userList);
		request.setAttribute("seeEliminate", seeEliminate);
		model.addAttribute("save_eliminateId", eliminateId);
		return "save_return_receipt";
	}

	// 消缺员回执 就是修改
	@RequestMapping("/update_eliminate_receipte")
	@ResponseBody
	public String update_eliminate_receipte(Integer save_eliminateId, String success_desc, String work_record,
			String final_report) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eliminateId", save_eliminateId);
		map.put("taskCompletionDesc", success_desc);
		map.put("extensionRecord", work_record);
		map.put("finalReport", final_report);
		int count = eliminateService.update_receipte(map);
		if (count > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("date", time);
			map2.put("eliminateId", save_eliminateId);
			eliminateService.updateActualDate(map2);
			eliminateService.execu_updateTaskstatusAudit(save_eliminateId);
			return "true";
		}
		return "false";
	}

	// 审核
	@RequestMapping("/audit_eliminate_user")
	@ResponseBody
	public String audit_eliminate_user(Integer eliminateId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		// 是否负责人getAllTaskByCondition
		Eliminate eliminate = eliminateService.midflag(eliminateId, userId);

		// 是否是下发人
		Task task = eliminateService.taskmanflag(eliminateId, userId);

		String str = "";
		// 既是负责人又是下发人
		if (eliminate != null && task != null) {
			str = "taskmid";
		}
		// 这是负责人
		if (eliminate != null && task == null) {
			str = "eliminate";
		}
		// 这是下发人
		if (task != null && eliminate == null) {
			str = "task";
		}
		return str;
	}

	// 负责人的页面
	@RequestMapping("/fuze_details")
	public String fuze_details(Integer eliminateId, HttpServletRequest request, Model model, HttpSession session) {
		SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
		// System.out.println("....."+seeEliminate);
		User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
		seeEliminate.setTaskfuzeUser(user.getName());
		List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
		session.setAttribute("eliminateId", seeEliminate.getTaskId());
		model.addAttribute("userList", userList);
		request.setAttribute("seeEliminate", seeEliminate);
		model.addAttribute("save_eliminateId", eliminateId);
		return "fuze_save_return_receipt";
	}

	// 负责人的意见
	@RequestMapping("/update_eliminate_receipte_fuze")
	@ResponseBody
	public String update_eliminate_receipte_fuze(Integer fuze_save_eliminateId, String fuze_receipte,
			Integer pass_select, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		map.put("fuze_save_eliminateId", fuze_save_eliminateId);
		map.put("fuze_receipte", fuze_receipte);
		map.put("pass_select", pass_select);
		int count = eliminateService.update_fuze(map);
		if (count > 0) {
			SeeEliminate seeEliminate = eliminateService.seeEliminateById(fuze_save_eliminateId);
			if (seeEliminate.getTaskPassed() == 0) {

				eliminateService.execu_updateTaskstatusSuccess(fuze_save_eliminateId);
			} else {
				eliminateService.execu_updateTaskstatusReturn(fuze_save_eliminateId);
			}

			return "true";
		}
		return "false";
	}

	// 下发人的页面
	@RequestMapping("/xiafa_details")
	public String xiafa_details(Integer eliminateId, HttpServletRequest request, Model model, HttpSession session) {
		SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
		// System.out.println("....."+seeEliminate);
		User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
		seeEliminate.setTaskfuzeUser(user.getName());
		List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
		session.setAttribute("eliminateId", seeEliminate.getTaskId());
		model.addAttribute("userList", userList);
		request.setAttribute("seeEliminate", seeEliminate);
		model.addAttribute("save_eliminateId", eliminateId);
		return "xiafa_save_return_receipt";
	}
	//下发人意见
	@RequestMapping("/update_eliminate_receipte_xiafa")
	@ResponseBody
	public String update_eliminate_receipte_xiafa(Integer xiafa_save_eliminateId,String xiafa_receipte) {
		System.out.println("xiafa_save_eliminateId。。。"+xiafa_save_eliminateId+"...xiafa_receipte"+xiafa_receipte);
		Map<String,Object> map = new HashMap<>();
		map.put("eliminateId",xiafa_save_eliminateId);
		map.put("xiafa_receipte", xiafa_receipte);
		int count = eliminateService.update_xiafa(map);
		if(count>0) {
			
			return "true";
		}
		return "false";
	}
	
	// 都是的页面
		@RequestMapping("/all_details")
		public String all_details(Integer eliminateId, HttpServletRequest request, Model model, HttpSession session) {
			SeeEliminate seeEliminate = eliminateService.seeEliminateById(eliminateId);
			// System.out.println("....."+seeEliminate);
			User user = eliminateService.getAllUserEliminate(seeEliminate.getTaskfuzeId());
			seeEliminate.setTaskfuzeUser(user.getName());
			List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
			session.setAttribute("eliminateId", seeEliminate.getTaskId());
			model.addAttribute("userList", userList);
			request.setAttribute("seeEliminate", seeEliminate);
			model.addAttribute("save_eliminateId", eliminateId);
			return "all_save_return_receipt";
		}
		//意见
		@RequestMapping("/update_eliminate_receipte_all")
		@ResponseBody
		public String update_eliminate_receipte_all(Integer all_save_eliminateId,String all_fuze_receipte,String all_xiafa_receipte,Integer all_pass_select) {
			Map<String,Object> map = new HashMap<>();
			map.put("all_save_eliminateId", all_save_eliminateId);
			map.put("all_fuze_receipte", all_fuze_receipte);
			map.put("all_xiafa_receipte", all_xiafa_receipte);
			map.put("all_pass_select", all_pass_select);
			int count = eliminateService.update_all(map);
			if(count>0) {
				SeeEliminate seeEliminate = eliminateService.seeEliminateById(all_save_eliminateId);
				if (seeEliminate.getTaskPassed() == 0) {

					eliminateService.execu_updateTaskstatusSuccess(all_save_eliminateId);
				} else {
					eliminateService.execu_updateTaskstatusReturn(all_save_eliminateId);
				}
				return "true";
			}
			return "false";
		}
}
