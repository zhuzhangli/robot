package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xjtusicd3.common.util.JsonUtil;
import org.xjtusicd3.database.helper.AgreeHelper;
import org.xjtusicd3.database.helper.CollectionHelper;
import org.xjtusicd3.database.helper.CommentHelper;
import org.xjtusicd3.database.helper.CommunityAnswerHelper;
import org.xjtusicd3.database.helper.QuestionHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.AgreePersistence;
import org.xjtusicd3.database.model.CollectionPersistence;
import org.xjtusicd3.database.model.CommentPersistence;
import org.xjtusicd3.database.model.CommunityAnswerPersistence;
import org.xjtusicd3.database.model.CommunityQuestionPersistence;
import org.xjtusicd3.database.model.QuestionPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.partner.service.CommentService;
import org.xjtusicd3.partner.service.CommunityService;
import org.xjtusicd3.partner.view.Question2_CommunityReplayView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class CommentController {
	/*
	 * zyq_faq3_ajax_添加评论
	 */
	@ResponseBody
	@RequestMapping(value={"/saveComment"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/html;charset=UTF-8")
	public String saveComment(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String faqtitle = request.getParameter("faqtitle");
		String comment = request.getParameter("comment");
		String useremail = (String) session.getAttribute("UserEmail");
		if (useremail==null) {
			return "0";
		}else {
			List<UserPersistence> uList = UserHelper.getEmail(useremail);
			List<QuestionPersistence> faqlist = QuestionHelper.faq3_faqcontent_title(faqtitle);
			CommentService.addComment(uList.get(0).getUSERID(),faqlist.get(0).getFAQQUESTIONID(),comment);
			return "1";
		}
	 }
	/*
	 * zyq_question_ajax_添加评论
	 */
	@ResponseBody
	@RequestMapping(value={"/addComment"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/html;charset=UTF-8")
	public String addComment(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail"); 
		String url = (String) session.getAttribute("urlPath");
		String questionId = request.getParameter("questionId");
		String commentContent = request.getParameter("commentContent");
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			//判断评论是否重复提交
			List<UserPersistence> userPersistences = UserHelper.getEmail(useremail); 
			List<CommunityAnswerPersistence> communityAnswerPersistences = CommunityAnswerHelper.question_IsCommunityAnswer(userPersistences.get(0).getUSERID(), commentContent,questionId);
			if (communityAnswerPersistences.size()==0) {
				CommunityService.addComment(userPersistences.get(0).getUSERID(), commentContent, questionId);
				jsonObject.put("value", "1");
				jsonObject.put("url",url);
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
				
			}else{
				jsonObject.put("value", "2");
				jsonObject.put("url",url);
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}
		}
	}
	/*
	 * zyq_question2_ajax_添加评论的回复
	 */
	@ResponseBody
	@RequestMapping(value={"/saveCommunityComment"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/html;charset=UTF-8")
	public String saveCommunityComment(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail"); 
		String questionId = request.getParameter("questionId");
		String answerId = request.getParameter("answerId");
		String content = request.getParameter("content");
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			List<UserPersistence> userPersistences = UserHelper.getEmail(useremail);
			//判断回复是否重复提交
			List<CommentPersistence> commentPersistences = CommentHelper.question2_getComment2(answerId, userPersistences.get(0).getUSERID(), content);
			if (commentPersistences.size()==0) {
				CommentService.saveCommunityComment(userPersistences.get(0).getUSERID(), questionId, content, answerId);
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
				
			}else{
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}
		}
	}
	/*
	 * zyq_question2_ajax_查看更多评论
	 */
	@ResponseBody
	@RequestMapping(value={"/getMoreComment"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String getMoreComment(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail");
		String questionId = request.getParameter("questionId");
		String answerId = request.getParameter("answerId");
		int startnumber = Integer.parseInt(request.getParameter("startnumber"));
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else{
			List<Question2_CommunityReplayView> list = CommentService.question2_CommunityReplayViews(questionId, answerId, startnumber);
			List<CommentPersistence> commentPersistences = CommentHelper.question2_getComment(questionId, answerId);
			jsonObject.put("value", "1");
			jsonObject.put("endnumber", startnumber+list.size());
			jsonObject.put("commentList", list);
			jsonObject.put("totalnumber", commentPersistences.size());
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}
	}
	/*
	 * zyq_question2_ajax_点赞
	 */
	@ResponseBody
	@RequestMapping(value={"/saveAgreeAnswer"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String saveAgreeAnswer(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail");
		String answerId = request.getParameter("answerId");
		List<AgreePersistence> agreePersistences = AgreeHelper.getAgree(useremail, answerId);
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			if (agreePersistences.size()==0) {
				AgreeHelper.saveAgree(useremail, answerId);
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}else {
				AgreeHelper.deleteAgree(agreePersistences.get(0).getAGREEID());
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}
		}
	}
	/*
	 * zyq_question_ajax_点赞
	 */
	@ResponseBody
	@RequestMapping(value={"/saveAgreeAnswer2"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String saveAgreeAnswer2(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail");
		String questionId = request.getParameter("questionId");
		List<CommunityAnswerPersistence> communityAnswerPersistences = CommunityAnswerHelper.question_iscurrentAnswer(questionId, 1);
		String answerId = communityAnswerPersistences.get(0).getCOMMUNITYANSWERID();
		List<AgreePersistence> agreePersistences = AgreeHelper.getAgree(useremail, answerId);
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			if (agreePersistences.size()==0) {
				AgreeHelper.saveAgree(useremail, answerId);
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}else {
				AgreeHelper.deleteAgree(agreePersistences.get(0).getAGREEID());
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}
		}
	}
	/*
	 * zyq_question2_ajax_收藏
	 */
	@ResponseBody
	@RequestMapping(value={"/saveCollectionAnswer"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String saveCollectionAnswer(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail");
		String answerId = request.getParameter("answerId");
		List<CollectionPersistence> collectionPersistences = CollectionHelper.getCollection(useremail, answerId);
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			if (collectionPersistences.size()==0) {
				CollectionHelper.saveCollection(useremail, answerId);
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}else {
				CollectionHelper.deleteCollection(collectionPersistences.get(0).getCOLLECTIONID());
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject); 
				return result;
			}
		}
	}
	/*
	 * zyq_question2_ajax_设为最佳答案
	 */
	@ResponseBody
	@RequestMapping(value={"/saveBestAnswer"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String saveBestAnswer(HttpServletRequest request,HttpSession session){
		String useremail = (String) session.getAttribute("UserEmail");
		String answerId = request.getParameter("answerId");
		JSONObject jsonObject = new JSONObject();
		if (useremail==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}else {
			CommunityAnswerHelper.saveBestAnswer(answerId);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject); 
			return result;
		}
	}
}