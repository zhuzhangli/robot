package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.common.util.JsonUtil;
import org.xjtusicd3.database.helper.ClassifyHelper;
import org.xjtusicd3.database.model.ClassifyPersistence;
import org.xjtusicd3.partner.annotation.SystemControllerLog;
import org.xjtusicd3.partner.service.ClassifyService;
import org.xjtusicd3.partner.service.EquipmentService;
import org.xjtusicd3.partner.view.Personal3_EquipmentView;

@Controller
public class ClassifyController {
	/*
	 * robot_分类
	 */
	@RequestMapping(value="robot",method=RequestMethod.GET)
	@SystemControllerLog(description = "robot_分类")
	public ModelAndView classifyName(HttpSession session,HttpServletRequest request,String e,String r){
		ModelAndView modelAndView = new ModelAndView("robot");
		String string = ClassifyService.classify();
		modelAndView.addObject("string",string);
//		List<Personal3_EquipmentView> list = EquipmentService.personal3_EquipmentView();
//		mv.addObject("personal3_list", list);
//		String macAddress = request.getParameter("macAddress");
//		System.out.println("macAddress:"+macAddress);
		String urlPath = request.getServletPath();
		session.setAttribute("urlPath", urlPath);
		return modelAndView;
	}
	/*
	 * faq、faq1_右侧的第一级分类
	 */
	@ResponseBody
	@RequestMapping(value={"/getFirstLevel"},method={org.springframework.web.bind.annotation.RequestMethod.GET},produces="text/plain;charset=UTF-8")
	@SystemControllerLog(description = "faq、faq1_右侧的第一级分类")
	public  String search(HttpServletResponse response){
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		List<ClassifyPersistence> classifyPersistences = ClassifyHelper.classifyName1();
		if (classifyPersistences == null || classifyPersistences.size()==0) {
			return null;
		}			
		String result = JsonUtil.toJsonString(classifyPersistences);
		return result;
	 }
	/*
	 * ajax获取第二级分类
	 */
	@ResponseBody
	@RequestMapping(value={"/getSecondLevel"},method={org.springframework.web.bind.annotation.RequestMethod.GET},produces="text/plain;charset=UTF-8")
	@SystemControllerLog(description = "faq、faq1_获取第二级分类")
	public  String faq1_ClassifyName(String classifyId,HttpServletResponse response){
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		List<ClassifyPersistence> classifyPersistences = ClassifyHelper.faq1_ClassifyName(classifyId);
		if (classifyPersistences == null || classifyPersistences.size()==0) {
			return null;
		}			
		String result = JsonUtil.toJsonString(classifyPersistences);
		return result;
	 }
	
}
