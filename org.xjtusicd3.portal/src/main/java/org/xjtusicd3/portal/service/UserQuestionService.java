package org.xjtusicd3.portal.service;

 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.xjtusicd3.database.helper.AnswerHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.helper.UserQuestionHelper;
import org.xjtusicd3.database.model.RobotAnswerPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.database.model.UserQuestionPersistence;
import org.xjtusicd3.portal.view.IncidentindexView;

public class UserQuestionService
{
	public static List<UserQuestionPersistence> getUserQuestion() 
	{
		List<UserQuestionPersistence> userquestionlist = UserQuestionHelper.getUserQuestion();
		return userquestionlist;
		
	}
	/*
	 * incidentindex_userQuestion展示
	 */
	public static List<IncidentindexView> incidentindexViews() 
	{
		List<IncidentindexView> incidentindexViews = new ArrayList<IncidentindexView>();
		List<UserQuestionPersistence> userQuestionPersistences = UserQuestionHelper.getUserQuestion();
		for (UserQuestionPersistence userQuestionPersistence : userQuestionPersistences)
		{
			IncidentindexView incidentindexView = new IncidentindexView();
			incidentindexView.setUserQuestionTime(userQuestionPersistence.getQUESTIONTIME());
			incidentindexView.setUserQuestionId(userQuestionPersistence.getUSERQUESTIONID());
			incidentindexView.setUserQuestionTitle(userQuestionPersistence.getQUESTIONTITLE());
			List<UserPersistence> userPersistences =UserHelper.getUserNameById(userQuestionPersistence.getUSERID());
			incidentindexView.setUserName(userPersistences.get(0).getUSERNAME());
			incidentindexViews.add(incidentindexView);
		}
		
		
		return incidentindexViews;
	}
	
	/*
	 * zzl_事件待处理_查看问题详情
	 */
	public static List<IncidentindexView> getUserQuestionDetail(String UserQuestionId) 
	{
		List<IncidentindexView> incidentindexViews = new ArrayList<IncidentindexView>();
		List<UserQuestionPersistence> userQuestionPersistences = UserQuestionHelper.getUserQuestion(UserQuestionId);
		for (UserQuestionPersistence userQuestionPersistence : userQuestionPersistences)
		{
			IncidentindexView incidentindexView = new IncidentindexView();
			incidentindexView.setUserQuestionTime(userQuestionPersistence.getQUESTIONTIME());
			incidentindexView.setUserQuestionId(userQuestionPersistence.getUSERQUESTIONID());
			incidentindexView.setUserQuestionTitle(userQuestionPersistence.getQUESTIONTITLE());
			List<UserPersistence> userPersistences =UserHelper.getUserNameById(userQuestionPersistence.getUSERID());
			incidentindexView.setUserName(userPersistences.get(0).getUSERNAME());
			incidentindexViews.add(incidentindexView);
		}
		
		
		return incidentindexViews;
	}
	
	
	/*
	 * zzl_事件已处理_查看问题详情
	 */
	public static List<IncidentindexView> getUserQuestionDetail2(String UserQuestionId) 
	{
		List<IncidentindexView> incidentindexViews = new ArrayList<IncidentindexView>();
		List<UserQuestionPersistence> userQuestionPersistences = UserQuestionHelper.getUserQuestion(UserQuestionId);
		for (UserQuestionPersistence userQuestionPersistence : userQuestionPersistences)
		{
			IncidentindexView incidentindexView = new IncidentindexView();
			incidentindexView.setUserQuestionTime(userQuestionPersistence.getQUESTIONTIME());
			incidentindexView.setUserQuestionId(userQuestionPersistence.getUSERQUESTIONID());
			incidentindexView.setUserQuestionTitle(userQuestionPersistence.getQUESTIONTITLE());
			List<UserPersistence> userPersistences =UserHelper.getUserNameById(userQuestionPersistence.getUSERID());
			incidentindexView.setUserName(userPersistences.get(0).getUSERNAME());
			
			//获取应答表中问题对应的知识库答案id
			String faqAnswerId = UserQuestionHelper.getFaqAnswerIdByQuestionId(UserQuestionId);
			
			//获取faqanswerId相对应的内容
			String faqContent = AnswerHelper.getContentById(faqAnswerId);
			incidentindexView.setFaqAnswer(faqContent);
			
			incidentindexViews.add(incidentindexView);
		}
		
		
		return incidentindexViews;
	}
	
	
	
	
	
	
	//get analysis result of user question
	public static String dataAnalysis()
	{
		Date date=new Date();
		
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        String problemTime = format.format(date);
        System.out.println(problemTime);
		return null;
		
	}
	public static void main(String[] args)
	{
		dataAnalysis();
	}
	
	
	/**
	 * author:zzl
	 * abstract:待处理事件_当用户对系统回复的答案不满意时，tbl_robotAnswer问答表中满意字段置为0
	 * data:2017年10月31日10:04:34
	 */
	public static List<IncidentindexView> questionUnresolved() {
		//未处理
		List<IncidentindexView> questionUnresolved = new ArrayList<IncidentindexView>();
		
		List<UserQuestionPersistence> userQuestionPersistences = UserQuestionHelper.getUserQuestion();
		for(UserQuestionPersistence userQuestionPersistence:userQuestionPersistences){
			IncidentindexView incidentindexView = new IncidentindexView();
			/*
			 * 未处理为 0
			 * 已处理为 1
			 */
			List<RobotAnswerPersistence> robotAnswerlist= UserQuestionHelper.getUserSaticfaction(userQuestionPersistence.getUSERQUESTIONID());
			if (robotAnswerlist.size()!=0) {
				if (robotAnswerlist.get(0).getSATICFACTION() == 0) {
					incidentindexView.setUserQuestionTitle(userQuestionPersistence.getQUESTIONTITLE());
					List<UserPersistence> list = UserHelper.getUserNameById(userQuestionPersistence.getUSERID());				
					incidentindexView.setUserName(list.get(0).getUSERNAME());
					incidentindexView.setUserQuestionTime(userQuestionPersistence.getQUESTIONTIME());
					incidentindexView.setUserQuestionId(userQuestionPersistence.getUSERQUESTIONID());
					questionUnresolved.add(incidentindexView);
				}
			}
		}
		return questionUnresolved;
	}

		public static List<IncidentindexView> questionResolved() {
			//已处理
			List<IncidentindexView> questionResolved = new ArrayList<IncidentindexView>();
			
			List<UserQuestionPersistence> userQuestionPersistences = UserQuestionHelper.getUserQuestion();
			for(UserQuestionPersistence userQuestionPersistence:userQuestionPersistences){
				IncidentindexView incidentindexView = new IncidentindexView();
				/*
				 * 未处理为 0
				 * 已处理为 1
				 */
				List<RobotAnswerPersistence> robotAnswerlist= UserQuestionHelper.getUserSaticfaction(userQuestionPersistence.getUSERQUESTIONID());
				if (robotAnswerlist.size()!=0) {
					if (robotAnswerlist.get(0).getSATICFACTION() == 1) {
					incidentindexView.setUserQuestionTitle(userQuestionPersistence.getQUESTIONTITLE());
					List<UserPersistence> list = UserHelper.getUserNameById(userQuestionPersistence.getUSERID());				
					incidentindexView.setUserName(list.get(0).getUSERNAME());
					incidentindexView.setUserQuestionTime(userQuestionPersistence.getQUESTIONTIME());
					incidentindexView.setUserQuestionId(userQuestionPersistence.getUSERQUESTIONID());
					questionResolved.add(incidentindexView);
					
					}					
				}
			}
			return questionResolved;
		}
	
}
	
