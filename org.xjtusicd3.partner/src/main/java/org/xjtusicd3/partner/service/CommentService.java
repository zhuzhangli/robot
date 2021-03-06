package org.xjtusicd3.partner.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.xjtusicd3.database.helper.AnswerHelper;
import org.xjtusicd3.database.helper.CommentHelper;
import org.xjtusicd3.database.helper.CommunityAnswerHelper;
import org.xjtusicd3.database.helper.CommunityQuestionHelper;
import org.xjtusicd3.database.helper.ITHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.AnswerPersistence;
import org.xjtusicd3.database.model.CommentPersistence;
import org.xjtusicd3.database.model.CommunityAnswerPersistence;
import org.xjtusicd3.database.model.ITPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.partner.view.Faq1_UserActive;
import org.xjtusicd3.partner.view.Faq2_faqUserView;
import org.xjtusicd3.partner.view.Faq3_CommentReplyView;
import org.xjtusicd3.partner.view.Faq3_CommentView;
import org.xjtusicd3.partner.view.Question2_CommunityReplayView;


public class CommentService {
	/*
	 * zyq_faq3_ajax_添加评论
	 */
	public static void addComment(String userid, String faqquestionid, String comment,String faquserid) {
		Date date=new Date();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = format.format(date);
	    //查看是否回答自己的FAQ
	    List<AnswerPersistence> answerPersistences = AnswerHelper.faq3_faqContent(faqquestionid);
	    int isnotice = 0;
	    if (userid.equals(answerPersistences.get(0).getUSERID())) {
			isnotice = 0;
		}else {
			isnotice = 1;
		}
		CommentHelper.saveComment(UUID.randomUUID().toString(),faqquestionid,null,userid,comment,time,"0",isnotice,faquserid);
	}
	/*
	 * zyq_question2_ajax_添加评论的回复
	 */
	public static void saveCommunityComment(String userid,String communityquestionId,String comment,String answerId){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = format.format(date);
	    //查看是否回复了自己的评论
	    List<CommunityAnswerPersistence> communityAnswerPersistences = CommunityAnswerHelper.question_CommunityAnswerId(answerId);
	    int isnotice = 0;
	    if (userid.equals(communityAnswerPersistences.get(0).getUSERID())) {
			isnotice = 0;
		}else {
			isnotice = 1;
		}
	    CommentHelper.saveComment(UUID.randomUUID().toString(), null, communityquestionId, userid, comment, time, answerId,isnotice,null);
	}
	/*
	 * zyq_question2_ajax_添加评论的回复的回复
	 */
	public static void saveCommunityReply(String userid,String communityquestionId,String comment,String answerId,String touserId){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = format.format(date);
	    int isnotice = 1;
	    CommentHelper.saveComment(UUID.randomUUID().toString(), null, communityquestionId, userid, comment, time, answerId,isnotice,touserId);
	}
	/*
	 * zyq_faq3_ajax_添加评论的回复
	 */
	public static void saveFaqComment(String userid,String faqquestionId,String comment,String commentId,String duo){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = format.format(date);
	    //查看是否回复了自己的评论
	    List<CommentPersistence> commentPersistences = CommentHelper.faq3_getCommentById(commentId);
	    int isnotice = 0;
	    if (userid.equals(commentPersistences.get(0).getUSERID())) {
			isnotice = 0;
		}else {
			isnotice = 1;
		}
	    if (duo.equals("1")) {
	    	CommentHelper.saveComment(UUID.randomUUID().toString(), faqquestionId, null, userid, comment, time, commentId,isnotice,commentPersistences.get(0).getUSERID());
		}else {
			CommentHelper.saveComment(UUID.randomUUID().toString(), faqquestionId, null, userid, comment, time, commentId,isnotice,null);
		}
	}
	/*
	 * zyq_faq3_获得评论列表
	 */
	public static List<Faq3_CommentView> faq3_comment(String questionId,int startnumber) {
		List<Faq3_CommentView> faq3_CommentViews = new ArrayList<Faq3_CommentView>();
		List<CommentPersistence> commentPersistences = CommentHelper.getCommentMore(questionId,startnumber,"0");
		for(CommentPersistence commentPersistence : commentPersistences){
			List<Faq2_faqUserView> faq2_faqUserViews = new ArrayList<Faq2_faqUserView>();
			List<UserPersistence> userPersistences = UserHelper.getEmail_id(commentPersistence.getUSERID());
			for(UserPersistence userPersistence:userPersistences){
				Faq2_faqUserView userView = new Faq2_faqUserView(userPersistence);
				faq2_faqUserViews.add(userView);
			}
			List<Faq3_CommentReplyView> faq3_CommentReplyViews = new ArrayList<Faq3_CommentReplyView>();
			List<CommentPersistence> list = CommentHelper.faq3_getCommentReply(commentPersistence.getCOMMENTID());
			List<CommentPersistence> commentPersistences2 = CommentHelper.faq3_getCommentReply_Limit(commentPersistence.getCOMMENTID(),0);
			for(CommentPersistence commentPersistence2:commentPersistences2){
				Faq3_CommentReplyView faq3_CommentReplyView = new Faq3_CommentReplyView();
				List<UserPersistence> userNameList = UserHelper.getEmail_id(commentPersistence2.getUSERID());
				faq3_CommentReplyView.setUserName(userNameList.get(0).getUSERNAME());
				List<CommentPersistence> cList = CommentHelper.faq3_getCommentById(commentPersistence2.getCOMMENTPARENTID());
				List<UserPersistence> toUserNameList = UserHelper.getEmail_id(cList.get(0).getUSERID());
				faq3_CommentReplyView.setToUserName(toUserNameList.get(0).getUSERNAME());
				faq3_CommentReplyView.setTime(commentPersistence2.getCOMMENTTIME());
				faq3_CommentReplyView.setComment(commentPersistence2.getCOMMENTCONTENT());
				faq3_CommentReplyView.setCommentId(commentPersistence2.getCOMMENTID());
				faq3_CommentReplyView.setParrentId(commentPersistence2.getCOMMENTPARENTID());
				List<CommentPersistence> commentPersistences3 = CommentHelper.faq3_getCommentById(commentPersistence2.getCOMMENTPARENTID());
				if (commentPersistences3.get(0).getCOMMENTPARENTID().equals("0")&&commentPersistence2.getTOUSERID()==null) {
					faq3_CommentReplyView.setToUserName(null);
				}else {
					List<UserPersistence> userPersistences2 = UserHelper.getEmail_id(commentPersistence2.getTOUSERID());
					faq3_CommentReplyView.setToUserName(userPersistences2.get(0).getUSERNAME());
				}
				faq3_CommentReplyViews.add(faq3_CommentReplyView);
			}
			Faq3_CommentView faq3_CommentView = new Faq3_CommentView(commentPersistence);
			faq3_CommentView.setUserViews(faq2_faqUserViews);
			faq3_CommentView.setReplyViews(faq3_CommentReplyViews);
			faq3_CommentView.setCommentId(commentPersistence.getCOMMENTID());
			faq3_CommentView.setCommentNumber(Integer.toString(list.size()));
			faq3_CommentViews.add(faq3_CommentView);
		}
		return faq3_CommentViews;
	}
	/*
	 * zyq_question2_获得更多的回复
	 */
	public static List<Question2_CommunityReplayView> question2_CommunityReplayViews(String questionId,String answerId,Integer startnumber){
		List<Question2_CommunityReplayView> question2_CommunityReplayViews = new ArrayList<Question2_CommunityReplayView>();
		List<CommentPersistence> commentPersistences = CommentHelper.question2_getMoreComment(questionId, answerId, startnumber);
		for(CommentPersistence commentPersistence:commentPersistences){
			Question2_CommunityReplayView question2_CommunityReplayView = new Question2_CommunityReplayView();
			question2_CommunityReplayView.setCommunity(commentPersistence.getCOMMENTCONTENT());
			question2_CommunityReplayView.setTime(commentPersistence.getCOMMENTTIME());
			List<UserPersistence> userPersistences = UserHelper.getEmail_id(commentPersistence.getUSERID());
			question2_CommunityReplayView.setUserImage(userPersistences.get(0).getAVATAR());
			question2_CommunityReplayView.setUserName(userPersistences.get(0).getUSERNAME());
			question2_CommunityReplayViews.add(question2_CommunityReplayView);
		}
		return question2_CommunityReplayViews;
	}
	/*
	 * zyq_faq3_获得更多的回复
	 */
	public static List<Faq3_CommentReplyView> faq3_CommentReplyViews(String commentId,int startnumber){
		List<Faq3_CommentReplyView> faq3_CommentReplyViews = new ArrayList<Faq3_CommentReplyView>();
		List<CommentPersistence> commentPersistences = CommentHelper.faq3_getCommentReply_Limit(commentId, startnumber);
		for(CommentPersistence commentPersistence:commentPersistences){
			Faq3_CommentReplyView faq3_CommentReplyView = new Faq3_CommentReplyView();
			faq3_CommentReplyView.setComment(commentPersistence.getCOMMENTCONTENT());
			faq3_CommentReplyView.setCommentId(commentPersistence.getCOMMENTID());
			faq3_CommentReplyView.setTime(commentPersistence.getCOMMENTTIME());
			List<UserPersistence> userPersistences = UserHelper.getEmail_id(commentPersistence.getUSERID());
			if (commentPersistence.getTOUSERID()!=null) {
				List<UserPersistence> userPersistences2 = UserHelper.getEmail_id(commentPersistence.getTOUSERID());
				faq3_CommentReplyView.setToUserName(userPersistences2.get(0).getUSERNAME());
			}
			faq3_CommentReplyView.setUserName(userPersistences.get(0).getUSERNAME());
			faq3_CommentReplyView.setParrentId(commentPersistence.getCOMMENTPARENTID());
			faq3_CommentReplyViews.add(faq3_CommentReplyView);
		}
		return faq3_CommentReplyViews;
	}
	/*
	 * zyq_question2_设为最佳答案
	 */
	public static void saveBestAnswer(String questionId,String answerId) {
		CommunityAnswerHelper.saveBestAnswer(answerId);
		CommunityQuestionHelper.updateBestAnswer(questionId);
	}
	/*
	 * zyq_faq1_查看活跃用户
	 */
	public static List<Faq1_UserActive> faq1_userActive() {
		List<Faq1_UserActive> faq1_UserActives = new ArrayList<Faq1_UserActive>();
  	    Date date=new Date();
  	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	    String time = format.format(date);
		List<CommentPersistence> commentPersistences = CommentHelper.faq1_userActive(time);
		for(CommentPersistence commentPersistence:commentPersistences){
			Faq1_UserActive faq1_UserActive = new Faq1_UserActive();
			faq1_UserActive.setUserId(commentPersistence.getUSERID());
			List<UserPersistence> userPersistences = UserHelper.getEmail_id(commentPersistence.getUSERID());
			faq1_UserActive.setUserImage(userPersistences.get(0).getAVATAR());
			List<ITPersistence> itPersistences = ITHelper.IT(commentPersistence.getUSERID());
			if (itPersistences.size()!=0) {
				faq1_UserActive.setWork(itPersistences.get(0).getGOODWORK());
			}
			faq1_UserActive.setUserName(userPersistences.get(0).getUSERNAME());
			faq1_UserActive.setFaqNumber(commentPersistence.getNUM());
			faq1_UserActives.add(faq1_UserActive);
		}
		return faq1_UserActives;
	}
	/*
	 * zyq_faq1_查看活跃用户_按周查询
	 */
	public static List<Faq1_UserActive> faq1_userActive_week() {
		List<Faq1_UserActive> faq1_UserActives = new ArrayList<Faq1_UserActive>();
  	    Date date=new Date();

  	    Calendar c = Calendar.getInstance();
  	    c.setTime(date);
  	    c.add(Calendar.DAY_OF_MONTH, 1);
  	    
  	    Date tomorrow = c.getTime();
  	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	    String time = format.format(tomorrow);
  	    
  	    String time2 = getdate(-7);
  	    System.out.println("time1:"+time);
  	    System.out.println("time2:"+time2);
		List<CommentPersistence> commentPersistences = CommentHelper.faq1_userActiveWeek(time,time2);
		System.out.println("周活跃用户："+commentPersistences.size());
		for(CommentPersistence commentPersistence:commentPersistences){
			Faq1_UserActive faq1_UserActive = new Faq1_UserActive();
			faq1_UserActive.setUserId(commentPersistence.getUSERID());
			List<UserPersistence> userPersistences = UserHelper.getEmail_id(commentPersistence.getUSERID());
			faq1_UserActive.setUserImage(userPersistences.get(0).getAVATAR());
			List<ITPersistence> itPersistences = ITHelper.IT(commentPersistence.getUSERID());
			if (itPersistences.size()!=0) {
				faq1_UserActive.setWork(itPersistences.get(0).getGOODWORK());
			}
			faq1_UserActive.setUserName(userPersistences.get(0).getUSERNAME());
			faq1_UserActive.setFaqNumber(commentPersistence.getNUM());
			faq1_UserActives.add(faq1_UserActive);
		}
		return faq1_UserActives;
	}
	public static String getdate(int i){ // //获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
		 Date dat = null;
		 Calendar cd = Calendar.getInstance();
		 cd.add(Calendar.DATE, i);
		 dat = cd.getTime();
		 SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time = dformat.format(dat);
		 return time;
	 }
	
	/**
	 * author:zzl
	 * abstract:获取未登录用户推荐问题评论信息
	 * data:2017年9月15日19:42:02
	 */
	public static int commentInfo(String faqquestionid) {
		List<CommentPersistence> commentPersistences = CommentHelper.commentInfo(faqquestionid);		
		return commentPersistences.size();
	}
	
	
	
}
