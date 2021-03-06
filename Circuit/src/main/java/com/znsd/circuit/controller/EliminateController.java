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
import com.znsd.circuit.model.Personalwork;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;
import com.znsd.circuit.service.InspectionService;
import com.znsd.circuit.service.PersonalworkService;
import com.znsd.circuit.util.DateTime;
import com.znsd.circuit.util.MyFlaw;
import com.znsd.circuit.util.SeeEliminate;
import com.znsd.circuit.util.UpdateWait;

@Controller
@RequestMapping("/eliminate")
public class EliminateController {

	@Autowired
	private EliminateService eliminateService;

	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private PersonalworkService personalworkService;

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
		maps.put("rows", list);
		maps.put("total", list.size());
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
		//消缺任务的id
		session.setAttribute("idd", id);
		String coding = "es_flaw";
		List<User> list = eliminateService.getAlleliminateUser(coding);
		System.out.println("所有的existUserById消缺员....."+list);
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
		maps.put("total", list.size());
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
			String taskRemark, String alstr, HttpSession session) {
		//System.out.println("。。。。。"+str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		User user = (User) session.getAttribute("user");
		int taskman = user.getId();// 下发人
		String date = (String) session.getAttribute("date");// 登录时间
		System.out.println("登录时间： ：" + date + "下发人   " + taskman + "任务编码：：" + taskcoding + "  任务名称" + taskname
				+ "  任务单据" + taskbills + "  负责人" + mid + "  任务描述" + taskDesc + "  任务备注" + taskRemark + /*"  消缺员" + str*/
				 "  缺陷" + alstr + "  ");
		Map<String, Object> map1 = new HashMap<>();
		map1.put("taskcoding", taskcoding);
		map1.put("taskname", taskname);
		map1.put("taskman", taskman);
		map1.put("date", date);
		map1.put("taskRemark", taskRemark);
		map1.put("time", time);
		map1.put("taskDesc", taskDesc);
		map1.put("status", 4);
		eliminateService.insertTask(map1);
		/*if (str == "" || str == null) {
			map1.put("status", 4);
			eliminateService.insertTask(map1);
		} else {
			map1.put("status", 5);
			
		}*/

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
		/*int eid = eliminate.getId();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("eid", eid);*/
		/*if (str != "" || str != null) {
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
		}*/

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
	
	//已经存在的消缺员
	@RequestMapping("/existUser")
	@ResponseBody
	public List<User> existUser(Integer id) {
		List<User> list=eliminateService.existUserById(id);
		System.out.println("。。。。。。。。。分打发阿迪斯发  "+list);
		return list;
	}

	//分配消缺员
	@RequestMapping("/updateEliminateUserById")
	@ResponseBody
	public Map<String,Object> updateEliminateUserById(String str,HttpSession session) {
		Map<String,Object> map = new HashMap<String,Object>();
		int id = (int) session.getAttribute("idd");
		System.out.println("。。。    id。"+id+"str........+"+str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		User user = (User) session.getAttribute("user");
		int loginId = user.getId();
		/*int id = (int) session.getAttribute("idd");
		eliminateService.deleteFlawStaff(id);
*/
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
			
		}
		//将状态改为已分配
		eliminateService.update_allocated(id);
		//被分配的巡检员的回执录入人，生成一条待办任务，提醒他去执行这个任务
		Eliminate eliminate = eliminateService.getTaskByEliminateId(id);
		Personalwork personalwork = new Personalwork();
		personalwork.setTaskId(eliminate.getTaskId());
		personalwork.setIsAccomplish(0);
		personalwork.setUserId(Integer.parseInt(s[0]));
		personalwork.setName("消缺任务执行");
		personalwork.setBackDate(new DateTime().getDateTime());
		personalwork.setType("消缺任务");
		personalworkService.arriveWork(personalwork);
		map.put("userId", Integer.parseInt(s[0]));
		map.put("flag", "true");
		return map;
	}
	@RequestMapping("/removethis")
	public String removethis(HttpSession session,Integer userId) {
		int id = (int) session.getAttribute("idd");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eliminateId", id);
		map.put("userId", userId);
		eliminateService.removethis(map);
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
		List<MyFlaw> list = eliminateService.seeEliminateBytaskId(id);
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
		// 修改被驳回的任务
		@RequestMapping("/execu_updateTaskStatusReturnById")
		@ResponseBody
		public String execu_updateTaskStatusReturnById(Integer id, HttpSession session) {
			User user = (User) session.getAttribute("user");
			int userid = user.getId();
			Flawstaff flawStaff = eliminateService.selectEliminateByUserId(id, userid);

			if (null != flawStaff && flawStaff.getIsReceipter().equals("是")) {
				//这里应该是将状态改为待审核状态
				
				//eliminateService.execu_updateTaskstatus(id);
				return "true";
			}
			return "false";
		}
		@RequestMapping("/execu_updateTaskStatusReturn")
		public String execu_updateTaskStatusReturn(Integer id, HttpSession session,Model model,HttpServletRequest request) {
			SeeEliminate seeEliminate = eliminateService.seeEliminateById(id);
			// System.out.println("....."+seeEliminate);
			List<User> userList = eliminateService.getAllUserId(seeEliminate.getId());
			session.setAttribute("eliminateId", seeEliminate.getTaskId());
			model.addAttribute("userList", userList);
			request.setAttribute("seeEliminate", seeEliminate);
			model.addAttribute("save_eliminateId", id);
			return "update_return_eliminate_receipt";
		}
		
		@RequestMapping("/update_eliminate_receipte_return")
		@ResponseBody
		public String update_eliminate_receipte_return(Integer return_save_eliminateId,String return_final_report,String return_work_record,String return_success_desc) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("eliminateId", return_save_eliminateId);
			map.put("taskCompletionDesc", return_success_desc);
			map.put("extensionRecord", return_work_record);
			map.put("finalReport", return_final_report);
			int count = eliminateService.update_receipte(map);
			if (count > 0) {
				//将任务状态改成待审核的状态
				eliminateService.execu_updateTaskstatusAudit(return_save_eliminateId);
				return "true";
			}
			return "false";
		}
	//修改分分配的其他信息
		@RequestMapping("/update_wait_eliminate")
		public String update_wait_eliminate(Integer id,Model model,HttpSession session) {
			System.out.println("。。。。。。。。。id"+id);
			UpdateWait updateWait= eliminateService.select_update_wait(id);
			System.out.println("。。。。。。"+updateWait);
			model.addAttribute("updateWait",updateWait);
			int taskid = updateWait.getTaskId();
			session.setAttribute("taskid", taskid);
			return "update_wait_eliminate";
			
		}
		@RequestMapping("/update_manager")
		@ResponseBody
		public List<MyFlaw> update_manager(HttpSession session){
			int id = (int) session.getAttribute("taskid");
			List<MyFlaw> list = eliminateService.update_EliminateBytaskId(id);
			System.out.println("list........"+list);
			return list;
		}
		@RequestMapping("/removerecord")
		@ResponseBody
		public String removerecord(Integer id) {
			int count = eliminateService.delete_record(id);
			if(count>0) {
				return "true";
			}
			return "false";
		}
		@RequestMapping("/insertIntoRecord")
		@ResponseBody
		public String insertIntoRecord(int taskId,String str,HttpSession session) {
			int taskid = (int) session.getAttribute("taskid");
			String [] s = str.split(",");
			for (String string : s) {
				System.out.println("string......"+string);
				int id = Integer.parseInt(string);
				eliminateService.insertintoRecord(taskid,id);
				
			}
			return "true";
		}
		
		//保存修改待分配的任务
		@RequestMapping("/update_task_eliminate")
		@ResponseBody
		public String update_task_eliminate(String update_taskcoding,String update_taskname,String taskbills,Integer taskMan,
				String update_taskDesc,String update_taskRemark,Integer taskid,Integer eliminateId) {
			
			System.out.println("。。。。taskbills"+taskbills+"taskman...."+taskMan);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("workBills",taskbills);
			map.put("taskMan", taskMan);
			map.put("eliminateId", eliminateId);
			int count = eliminateService.updateEliminate(map);
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("update_taskcoding", update_taskcoding);
			map1.put("update_taskname", update_taskname);
			map1.put("update_taskDesc", update_taskDesc);
			map1.put("update_taskRemark", update_taskRemark);
			map1.put("taskid",taskid);
			int count2 = eliminateService.updateTask(map1);
			if(count>0&&count2>0) {
				return "true";
			}
			return "false";
			
		}
}
