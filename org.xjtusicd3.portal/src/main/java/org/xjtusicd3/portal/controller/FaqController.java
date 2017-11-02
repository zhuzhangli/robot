package org.xjtusicd3.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.common.util.JsonUtil;
import org.xjtusicd3.database.helper.QuestionHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.portal.service.FaqService;
import org.xjtusicd3.portal.view.FaqView;
import org.xjtusicd3.portal.view.KnowledgeindexView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class FaqController {
	/*
	 * zpz_showFAQ
	 */
	@RequestMapping(value="knowledgeindex",method=RequestMethod.GET)
    public ModelAndView  knowledge(){
 	   ModelAndView mv=new ModelAndView("knowledgeindex");
 	   List<KnowledgeindexView> knowledgeindexViews = FaqService.knowledgeindexViews();
 	   String result = FaqService.konwStatisticsView();
 	   int faqTotal = QuestionHelper.getFaqTotal1();
 	   mv.addObject("faqList", knowledgeindexViews);
 	   mv.addObject("result", result);
 	   mv.addObject("total",faqTotal);
 	   return mv;
    }

	/*
	 * ZPZ_deleteFAQ
	 */
	@ResponseBody
	@RequestMapping(value={"/deleteFAQ"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/html;charset=UTF-8")
	public void deleteUser(HttpServletRequest request){
		String faqId = request.getParameter("FAQID");
		QuestionHelper.deleteFAQ(faqId);
		System.out.println(faqId);
	}
	
	/*
	 * zpz_showFAQInfoDetail
	 */
	@RequestMapping(value="showFAQ",method=RequestMethod.GET)
	public ModelAndView showUserInfo(String u){
		List<KnowledgeindexView> knowledgeindexViews = FaqService.getFAQinfo_id(u);
		ModelAndView modelAndView = new ModelAndView("showFAQ");
		modelAndView.addObject("faqInfoList", knowledgeindexViews);
		return modelAndView;
	}
	/*
	 * zpz_ajax_addProblemToFAQ
	 */
	@ResponseBody
	@RequestMapping(value={"/addProblemToFAQ"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String addProblemToFAQ(HttpServletRequest request,HttpSession session){
		String problemID = request.getParameter("problemID");
		JSONObject jsonObject = new JSONObject();
		//将社区问题及最佳答案添加至知识库
		FaqService.addProblemToFAQ(problemID);
		jsonObject.put("value", "1");
		String result = JsonUtil.toJsonString(jsonObject);
		return result;
	}
	
	/*
	 * personal_个人信息添加
	 */
	@RequestMapping(value="/addToFaq",method=RequestMethod.POST)
	public String addToFaq(FaqView faqView,HttpServletRequest request,HttpSession session){

		//zzl_获得前台用户名
		String username = (String) session.getAttribute("UserName");

		if (username==null) {
			return "redirect:login.html";
		}else {
			List<UserPersistence> list = UserHelper.getUserInfo(username);

			String title = faqView.getFAQTITLE();
			String keywords = faqView.getFAQKEYWORDS();

			System.out.println("社区问题："+title);
			System.out.println("社区问题："+keywords);
		
			return "redirect:index.html";
		}
	}
}
