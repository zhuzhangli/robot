package org.xjtusicd3.portal.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.xjtusicd3.database.helper.AnswerHelper;
import org.xjtusicd3.database.helper.QuestionHelper;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.UserPersistence;

public class QuestionService {
	/**
	 * author:zzl
	 * abstract:FAQ的增加
	 * data:2017年9月22日12:00:25
	 */
	public static void saveFAQ2(String username, String title, String keywords, String subspecialCategoryId,String description, String faqcontent) {
	//	QuestionPersistence questionPersistence = new QuestionPersistence();
		String questionid = UUID.randomUUID().toString();
//		questionPersistence.setFAQQUESTIONID(questionid);
//		questionPersistence.setFAQTITLE(title);
//		questionPersistence.setFAQKEYWORDS(keywords);
//		questionPersistence.setFAQCLASSIFYID(subspecialCategoryId);
//		questionPersistence.setCOLLECTION("0");
//		questionPersistence.setSCAN("0");
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
//		questionPersistence.setMODIFYTIME(time);
//		questionPersistence.setFAQDESCRIPTION(description);
//		questionPersistence.setMODIFYNUMBER("1");
		//待审核为1
//		questionPersistence.setFAQSTATE(2);
		List<UserPersistence> list = UserHelper.getUserInfo(username);
	//	questionPersistence.setUSERID(list.get(0).getUSERID());
		//QuestionHelper.save(questionPersistence);
		
		//添加到知识库问题列表
		QuestionHelper.insertIntoFaqQuestion(questionid,title,keywords, subspecialCategoryId,"0","0",time, description,"1","2",list.get(0).getUSERID() );
		
		
		//AnswerPersistence answerPersistence = new AnswerPersistence();
		//answerPersistence.setFAQANSWERID(UUID.randomUUID().toString());
		//answerPersistence.setFAQCONTENT(faqcontent);
		//answerPersistence.setFAQQUESTIONID(questionid);
		//List<UserPersistence> list = UserHelper.getUserInfo(username);
		//answerPersistence.setUSERID(list.get(0).getUSERID());
		//AnswerHelper.save(answerPersistence);
		
		//添加至知识库答案列表
		AnswerHelper.insertIntoFaqAnswer(UUID.randomUUID().toString(),faqcontent,questionid,list.get(0).getUSERID());
		
	}
}
