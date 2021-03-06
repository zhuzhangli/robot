package org.xjtusicd3.partner.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.xjtusicd3.database.helper.AnswerHelper;
import org.xjtusicd3.database.helper.ClassifyHelper;
import org.xjtusicd3.database.helper.CollectionHelper;
import org.xjtusicd3.database.helper.CommentHelper;
import org.xjtusicd3.database.helper.QuestionHelper;
import org.xjtusicd3.database.helper.ShareHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.AnswerPersistence;
import org.xjtusicd3.database.model.CollectionPersistence;
import org.xjtusicd3.database.model.CommentPersistence;
import org.xjtusicd3.database.model.LogPersistence;
import org.xjtusicd3.database.model.QuestionPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.partner.view.Faq2_faqContentView;
import org.xjtusicd3.partner.view.Faq3_faqContentView;
import org.xjtusicd3.partner.view.Faq_CommendView;
import org.xjtusicd3.partner.view.Faq_UserDynamics;
import org.xjtusicd3.partner.view.Faq2_faqUserView;
import org.xjtusicd3.partner.view.Faq3_faqAnswer;

public class QuestionService {
	/*
	 * faq2_知识列表
	 */
	public static List<Faq2_faqContentView> faqlist_faq2(String ClassifyId,int pageNow){
		List<Faq2_faqContentView> faq2Views = new ArrayList<Faq2_faqContentView>();
		List<QuestionPersistence> questionPersistences = QuestionHelper.faq2_faqlist(ClassifyId,pageNow);
		for(QuestionPersistence questionPersistence:questionPersistences){
			List<Faq2_faqUserView> user_faq2Views = new ArrayList<Faq2_faqUserView>();
			String userId = QuestionHelper.faq2_userId(questionPersistence.getFAQQUESTIONID());
			List<UserPersistence> userPersistences = QuestionHelper.faq2_userlist(userId);
			for(UserPersistence userPersistence:userPersistences){
				Faq2_faqUserView user_faq2View = new Faq2_faqUserView(userPersistence);
				user_faq2Views.add(user_faq2View);
			}
			
			Faq2_faqContentView faq2View  = new Faq2_faqContentView(questionPersistence);
			faq2View.setuList(user_faq2Views);
			List<CommentPersistence> commentPersistences = CommentHelper.getComment(questionPersistence.getFAQQUESTIONID());
			int number = commentPersistences.size();
			faq2View.setCommentNumber(number);
			faq2Views.add(faq2View);
		}
		return faq2Views;
	}
	/*
	 * faq3_知识内容
	 */
	public static List<Faq3_faqContentView> faq3_faqcontent(String QuestionId){
		List<Faq3_faqContentView> faq3Views = new ArrayList<Faq3_faqContentView>();
		List<QuestionPersistence> faqPersistences = QuestionHelper.faq3_faqcontent(QuestionId);
		for(QuestionPersistence faqPersistence:faqPersistences){
			List<Faq2_faqUserView> user_faq2Views = new ArrayList<Faq2_faqUserView>();
			List<Faq3_faqAnswer> faq3_faqAnswers = new ArrayList<Faq3_faqAnswer>();
			String userId = QuestionHelper.faq2_userId(faqPersistence.getFAQQUESTIONID());
			List<UserPersistence> userPersistences = QuestionHelper.faq2_userlist(userId);
			List<AnswerPersistence> answerPersistences = AnswerHelper.faq3_faqContent(QuestionId);
			for(UserPersistence userPersistence:userPersistences){
				Faq2_faqUserView user_faq2View = new Faq2_faqUserView(userPersistence);
				user_faq2Views.add(user_faq2View);
			}
			for(AnswerPersistence answerPersistence:answerPersistences){
				Faq3_faqAnswer faq3_faqAnswer = new Faq3_faqAnswer(answerPersistence);
				faq3_faqAnswers.add(faq3_faqAnswer);
			}
			Faq3_faqContentView faq3View = new Faq3_faqContentView(faqPersistence);
			faq3View.setuList(user_faq2Views);
			faq3View.setFaqAnswers(faq3_faqAnswers);
			faq3Views.add(faq3View);
		}
		return faq3Views;
	}
	/*
	 * zyq_ajax_FAQ的增加
	 */
	public static void saveFAQ(String useremail,String title,String keywords,String subspecialCategoryId,String description,String risk_prompt,String faqcontent){
		QuestionPersistence questionPersistence = new QuestionPersistence();
		String questionid = UUID.randomUUID().toString();
		questionPersistence.setFAQQUESTIONID(questionid);
		questionPersistence.setFAQTITLE(title);
		questionPersistence.setFAQKEYWORDS(keywords);
		questionPersistence.setFAQCLASSIFYID(subspecialCategoryId);
		questionPersistence.setCOLLECTION("0");
		questionPersistence.setSCAN("0");
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		questionPersistence.setMODIFYTIME(time);
		questionPersistence.setFAQDESCRIPTION(description);
		questionPersistence.setMODIFYNUMBER("1");
		questionPersistence.setFAQSTATE(1);
		QuestionHelper.save(questionPersistence);
		
		AnswerPersistence answerPersistence = new AnswerPersistence();
		answerPersistence.setFAQANSWERID(UUID.randomUUID().toString());
		answerPersistence.setFAQCONTENT(faqcontent);
		answerPersistence.setFAQQUESTIONID(questionid);
		List<UserPersistence> list = UserHelper.getEmail(useremail);
		answerPersistence.setUSERID(list.get(0).getUSERID());
		AnswerHelper.save(answerPersistence);
	}
	
	/**
	 * author:zzl
	 * abstract:FAQ的增加
	 * data:2017年9月22日12:00:25
	 */
	public static void saveFAQ2(String username, String title, String keywords, String subspecialCategoryId,String description, String risk_prompt, String faqcontent) {
		QuestionPersistence questionPersistence = new QuestionPersistence();
		String questionid = UUID.randomUUID().toString();
		questionPersistence.setFAQQUESTIONID(questionid);
		questionPersistence.setFAQTITLE(title);
		questionPersistence.setFAQKEYWORDS(keywords);
		questionPersistence.setFAQCLASSIFYID(subspecialCategoryId);
		questionPersistence.setCOLLECTION("0");
		questionPersistence.setSCAN("0");
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		questionPersistence.setMODIFYTIME(time);
		questionPersistence.setFAQDESCRIPTION(description);
		questionPersistence.setMODIFYNUMBER("1");
		//待审核为1
		questionPersistence.setFAQSTATE(1);
		List<UserPersistence> list = UserHelper.getUserInfo(username);
		questionPersistence.setUSERID(list.get(0).getUSERID());
		QuestionHelper.save(questionPersistence);
		
		AnswerPersistence answerPersistence = new AnswerPersistence();
		answerPersistence.setFAQANSWERID(UUID.randomUUID().toString());
		answerPersistence.setFAQCONTENT(faqcontent);
		answerPersistence.setFAQQUESTIONID(questionid);
		//List<UserPersistence> list = UserHelper.getUserInfo(username);
		answerPersistence.setUSERID(list.get(0).getUSERID());
		AnswerHelper.save(answerPersistence);
		
	}
	
	/*
	 * zyq_faq3_ajax_分享的增加
	 */
	public static void saveShare(String userId,String faqquestionId){
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		ShareHelper.saveShare(UUID.randomUUID().toString(),userId,time,faqquestionId);
	}
	public static void saveShare2(String userId,String faqquestionId){
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		ShareHelper.saveShare2(UUID.randomUUID().toString(),userId,time,faqquestionId);
	}
	/*
	 * zyq_FAQ页面_用户动态
	 */
	public static List<Faq_UserDynamics> userDynamics(){
		List<Faq_UserDynamics> userDynamics = new ArrayList<Faq_UserDynamics>();
		List<QuestionPersistence> questionPersistences = QuestionHelper.faq_userDynamics();
		System.out.println("questionPersistences："+questionPersistences.size());
		for(QuestionPersistence questionPersistence:questionPersistences){
			Faq_UserDynamics faq_UserDynamics = new Faq_UserDynamics();
			List<AnswerPersistence> answerPersistences = AnswerHelper.faq3_faqContent(questionPersistence.getFAQQUESTIONID());
			List<UserPersistence> userPersistences = UserHelper.getUserNameById(answerPersistences.get(0).getUSERID());
			faq_UserDynamics.setFaqId(questionPersistence.getFAQQUESTIONID());
			faq_UserDynamics.setFaqTitle(questionPersistence.getFAQTITLE());
			faq_UserDynamics.setTime(questionPersistence.getMODIFYTIME());
			if (questionPersistence.getMODIFYNUMBER().equals("1")) {
				faq_UserDynamics.setHow("发布");
			}else {
				faq_UserDynamics.setHow("修改");
			}
			faq_UserDynamics.setUserId(userPersistences.get(0).getUSERID());
			faq_UserDynamics.setUserName(userPersistences.get(0).getUSERNAME());
			userDynamics.add(faq_UserDynamics);
		}
		return userDynamics;
	}
	
	/**
	 * author:zzl
	 * abstract:获取已登录用户推荐列表
	 * data:2017年9月15日09:19:48
	 */
	public static List<Faq_CommendView> user_recommend_Limit(String userid, int startnum) {
		//Faq_CommendView中信息不全、后续可补充
		List<Faq_CommendView> faq_CommendViews = new ArrayList<Faq_CommendView>();
		List<LogPersistence> logPersistences = LogService.getLogs(userid);
		for (int i = 0; i < logPersistences.size(); i++) {
			String log = logPersistences.get(i).getUrl();
			System.out.println("日志："+log);
			//String log1 = log.toString();
			//System.out.println("日志2："+log);
			if (log.indexOf("/faq3.html?q=") != -1) {
				String a[] = log.split("=");
				String questionId = a[a.length-1];
				String faq_classifyId = QuestionHelper.faqclassify(questionId);		
				String parentId = ClassifyHelper.faq_parentId(faq_classifyId);
				List<QuestionPersistence> questionPersistences = QuestionHelper.questionView(parentId,startnum);
				for (QuestionPersistence questionPersistence:questionPersistences) {
					Faq_CommendView faq_CommendView = new Faq_CommendView();
					faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
					faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
					//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
					faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
					faq_CommendView.setSCAN(questionPersistence.getSCAN());
					faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
					faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
					List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
					faq_CommendView.setCOMMENTSUM(commentPersistences.size());
					List<UserPersistence> userInfo = UserHelper.getUserNameById(questionPersistence.getUSERID());
					faq_CommendView.setFAQUSERNAME(userInfo.get(0).getUSERNAME());
					faq_CommendView.setFAQUSERIMAGE(userInfo.get(0).getAVATAR());
					System.out.println(questionPersistence.getFAQTITLE());					
					faq_CommendViews.add(faq_CommendView);
				}
				System.out.println("执行的是第二个推荐mmmmmmmmmmmmmm");
				break;
			}
			if (i == logPersistences.size()) {
				//zzl_用户首次登录时还没有log记录_依旧用faq_recommend_Limit推荐
				List<QuestionPersistence> questionPersistences = QuestionHelper.faq_recommend_Limit(startnum);
				for (QuestionPersistence questionPersistence:questionPersistences) {
					Faq_CommendView faq_CommendView = new Faq_CommendView();
					faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
					faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
					//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
					faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
					faq_CommendView.setSCAN(questionPersistence.getSCAN());
					faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
					faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
					List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
					faq_CommendView.setCOMMENTSUM(commentPersistences.size());
					faq_CommendViews.add(faq_CommendView);				
				}
				System.out.println("执行的是第一个推荐lllllllllllllllll");
			}
		}
		
		
				
//		if (logPersistences.size()==0) {
//			//zzl_用户首次登录时还没有log记录_依旧用faq_recommend_Limit推荐
//			List<QuestionPersistence> questionPersistences = QuestionHelper.faq_recommend_Limit(startnum);
//			for (QuestionPersistence questionPersistence:questionPersistences) {
//				Faq_CommendView faq_CommendView = new Faq_CommendView();
//				faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
//				faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
//				//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
//				faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
//				faq_CommendView.setSCAN(questionPersistence.getSCAN());
//				faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
//				faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
//				List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
//				faq_CommendView.setCOMMENTSUM(commentPersistences.size());
//				faq_CommendViews.add(faq_CommendView);				
//			}
//			System.out.println("执行的是第一个推荐");
//		}else {
//			//暂时按照最新的浏览记录推荐，待改进
//			//String logUrl = "";
//			for(int i=0;i<logPersistences.size();i++){
//				System.out.println("用户日志："+"i" +logPersistences.get(i).getUrl());
//				System.out.println("xxxxxxxxxxx"+logPersistences.get(i).getUrl());
//				if((logPersistences.get(i).getUrl().indexOf("/faq3.html?q="))!=-1){
//					//zzl_用户有log记录且日志前缀有faq3字样_截取/faq3.html?q=之后的ID号
//					System.out.println("第几条记录"+i);
//					StringBuffer logUrl = logPersistences.get(0).getUrl();
//					String logUrl1 = logUrl.toString();
//			        String a[] = logUrl1.split("/");
//
//					//logMethod = logPersistences.get(i).getLogMethod();						
//						String questionId = a[a.length-1];
//						String faq_classifyId = QuestionHelper.faqclassify(questionId);		
//						String parentId = ClassifyHelper.faq_parentId(faq_classifyId);
//						List<QuestionPersistence> questionPersistences = QuestionHelper.questionView(parentId,startnum);
//						for (QuestionPersistence questionPersistence:questionPersistences) {
//							Faq_CommendView faq_CommendView = new Faq_CommendView();
//							faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
//							faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
//							//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
//							faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
//							faq_CommendView.setSCAN(questionPersistence.getSCAN());
//							faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
//							faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
//							List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
//							faq_CommendView.setCOMMENTSUM(commentPersistences.size());
//							System.out.println(questionPersistence.getFAQTITLE());					
//							faq_CommendViews.add(faq_CommendView);
//						}
//						System.out.println("执行的是第二个推荐");
//						break;
//				}
//					}else {
//						//zzl_已登录用户log记录不符合要求_依旧用faq_recommend_Limit推荐
//						List<QuestionPersistence> questionPersistences = QuestionHelper.faq_recommend_Limit(startnum);
//						for (QuestionPersistence questionPersistence:questionPersistences) {
//							Faq_CommendView faq_CommendView = new Faq_CommendView();
//							faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
//							faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
//							//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
//							faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
//							faq_CommendView.setSCAN(questionPersistence.getSCAN());
//							faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
//							faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
//							List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
//							faq_CommendView.setCOMMENTSUM(commentPersistences.size());
//							faq_CommendViews.add(faq_CommendView);				
//						}
//						System.out.println("执行的是第三个推荐");
//						break;
//					}	
				
	//		}
		//}
		return faq_CommendViews;
	}
	/**
	 * author:zzl
	 * abstract:获取未登录用户推荐列表
	 * data:2017年9月15日19:46:03
	 */
	public static List<Faq_CommendView> faq_recommend_Limit(int startnum) {
		//Faq_CommendView中信息不全、后续可补充
		List<Faq_CommendView> faq_CommendViews = new ArrayList<Faq_CommendView>();
		List<QuestionPersistence> questionPersistences = QuestionHelper.faq_recommend_Limit(startnum);
		for (QuestionPersistence questionPersistence:questionPersistences) {
			Faq_CommendView faq_CommendView = new Faq_CommendView();
			faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());			
			faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
			//List<CollectionPersistence> collectionPersistences = CollectionHelper.agreeInfo(questionPersistence.getFAQQUESTIONID());
			faq_CommendView.setCOLLECTION(questionPersistence.getCOLLECTION());
			faq_CommendView.setSCAN(questionPersistence.getSCAN());
			faq_CommendView.setMODIFYTIME(questionPersistence.getMODIFYTIME());;
			faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
			List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(questionPersistence.getFAQQUESTIONID());
			faq_CommendView.setCOMMENTSUM(commentPersistences.size());
			//List<UserPersistence> userInfo = UserHelper.getUserNameById(userDynamics.get(0).getUserId());
			List<UserPersistence> userInfo = UserHelper.getUserNameById(questionPersistence.getUSERID());
			faq_CommendView.setFAQUSERNAME(userInfo.get(0).getUSERNAME());
			faq_CommendView.setFAQUSERIMAGE(userInfo.get(0).getAVATAR());
			faq_CommendViews.add(faq_CommendView);			
		}
		return faq_CommendViews;
	}
	/**
	 * author:zzl
	 * abstract:推荐知识_根据收藏量推荐前4个
	 * data:2017年9月17日19:47:28
	 */
	public static List<Faq_CommendView> faqInfo(String faqParentId) {
		System.out.println("进入推荐知识");
		List<Faq_CommendView> faq_CommendViews = new ArrayList<Faq_CommendView>();
		List<QuestionPersistence> questionPersistences = QuestionHelper.faqInfo_limit(faqParentId);
		System.out.println(questionPersistences.size());
		for (QuestionPersistence questionPersistence:questionPersistences) {
			Faq_CommendView faq_CommendView = new Faq_CommendView();
			faq_CommendView.setFAQQUESTIONID(questionPersistence.getFAQQUESTIONID());
			faq_CommendView.setFAQTITLE(questionPersistence.getFAQTITLE());
			faq_CommendView.setFAQDESCRIPTION(questionPersistence.getFAQDESCRIPTION());
			System.out.println(questionPersistence.getFAQTITLE());
			faq_CommendViews.add(faq_CommendView);
		}		
		
		return faq_CommendViews;
		
	}
	
	/**
	 * author:zzl
	 * abstract:faq收藏数加一
	 * data:2017年9月29日08:56:06
	 */
	public static void faqcollection(String questionId) {
		List<QuestionPersistence> list = QuestionHelper.faqcollection(questionId);
		int faqCollection = Integer.parseInt(list.get(0).getCOLLECTION());
		++faqCollection;
		QuestionHelper.updateFAQCollection(questionId, Integer.toString(faqCollection));
	}
	
	/**
	 * author:zzl
	 * abstract:faq收藏数减一
	 * data:2017年9月29日09:03:08
	 */
	public static void faqcollection2(String questionId) {
		List<QuestionPersistence> list = QuestionHelper.faqcollection(questionId);
		int faqCollection = Integer.parseInt(list.get(0).getCOLLECTION());
		--faqCollection;
		QuestionHelper.updateFAQCollection(questionId, Integer.toString(faqCollection));
		
	}
	
}
