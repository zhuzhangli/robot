package org.xjtusicd3.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.common.util.JsonUtil;
import org.xjtusicd3.database.helper.ClassifyHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.helper.UserQuestionHelper;
import org.xjtusicd3.database.model.ClassifyPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.database.model.UserQuestionPersistence;
import org.xjtusicd3.portal.service.UserQuestionService;
import org.xjtusicd3.portal.view.IncidentindexView;
 
@Controller
public class UserQuestionController
{
	/*
	 * zpz_得到userQuestion
	 */
	@RequestMapping(value="incidentindex",method=RequestMethod.GET)
	public ModelAndView userQuestion(){
		
		ModelAndView mv = new ModelAndView("incidentindex");
		
		/*
		 * 待处理事件
		 * 当用户对系统回复的答案不满意时，tbl_robotAnswer问答表中满意字段 = 0
		 */
		List<IncidentindexView> questionUnresolved = UserQuestionService.questionUnresolved();
		
		
		/*
		 * 已处理事件
		 * 当用户对系统回复的答案满意时，tbl_robotAnswer问答表中满意字段 = 1
		 */
		List<IncidentindexView> questionResolved = UserQuestionService.questionResolved();
		
		
		mv.addObject("questionUnresolved",questionUnresolved);
		mv.addObject("questionResolved",questionResolved);
		mv.addObject("UnresolvedCounts", questionUnresolved.size());
		mv.addObject("ResolvedCounts", questionResolved.size());
		
		//String result = JsonUtil.toJsonString(incidentindexViews);
		//System.out.println(result);
		return mv;
		
	}
	
	/*
	 * zzl_事件待处理_查看问题详情
	 */
	@RequestMapping(value="showUserQuestion",method=RequestMethod.GET)
	public ModelAndView showUserQuestion(String q){
		List<IncidentindexView> incidentindexViews = UserQuestionService.getUserQuestionDetail(q);
		ModelAndView modelAndView = new ModelAndView("showUserQuestion");
		modelAndView.addObject("userQuestionInfoList", incidentindexViews);
		return modelAndView;
	}
	
	
	/*
	 * zzl_事件已处理_查看问题详情
	 */
	@RequestMapping(value="showUserQuestion2",method=RequestMethod.GET)
	public ModelAndView showUserQuestion2(String q){
		List<IncidentindexView> incidentindexViews = UserQuestionService.getUserQuestionDetail2(q);
		ModelAndView modelAndView = new ModelAndView("showUserQuestion2");
		
		List<ClassifyPersistence> classifyPersistences = ClassifyHelper.classifyName1();
		if (classifyPersistences == null || classifyPersistences.size()==0) {
			return null;
		}
				
		modelAndView.addObject("userQuestionInfoList", incidentindexViews);
		modelAndView.addObject("FirstLevel", classifyPersistences);
		
		return modelAndView;
	}
	
	
	/*
	 * zpz_user problem data
	 */
	
//	/*
//	 * ZPZ_deleteUserQuestion
//	 */
//	@ResponseBody
//	@RequestMapping(value={"/deleteUserQuestion"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/html;charset=UTF-8")
//	public void deleteUser(HttpServletRequest request){
//		String userQuestionId = request.getParameter("userquestionid");
//		UserQuestionHelper.deleteUserQuestion(userQuestionId);
//		System.out.println(userQuestionId);
//	}
//	
//	
	
}
