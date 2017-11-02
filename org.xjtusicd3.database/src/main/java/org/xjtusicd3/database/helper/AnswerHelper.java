package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.AnswerPersistenceMapper;
import org.xjtusicd3.database.model.AnswerPersistence;

public class AnswerHelper {
	/*
	 * zyq_spider_知识库答案的添加
	 */
	public static void save(AnswerPersistence answerPersistence){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		AnswerPersistenceMapper mapper = session.getMapper(AnswerPersistenceMapper.class);
		mapper.save(answerPersistence);
		session.close();
	}
	/*
	 * zyq_faq3_知识内容
	 */
	public static List<AnswerPersistence> faq3_faqContent(String QuestionId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		AnswerPersistenceMapper mapper  = session.getMapper(AnswerPersistenceMapper.class);
		List<AnswerPersistence> list = mapper.faq3_faqContent(QuestionId);
		session.close();
		return list;
	}
	
	/*
	 * zyq_notice_ajax_查询FAQ评论通知
	 */
	public static List<AnswerPersistence> notice_faqanswerList(String userId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		AnswerPersistenceMapper mapper  = session.getMapper(AnswerPersistenceMapper.class);
		List<AnswerPersistence> list = mapper.notice_faqanswerList(userId);
		session.close();
		return list;
	}
	
	//获取faqanswerId相对应的内容
	public static String getContentById(String faqAnswerId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		AnswerPersistenceMapper mapper  = session.getMapper(AnswerPersistenceMapper.class);
		String content = mapper.getContentById(faqAnswerId);
		session.close();
		return content;
	}
	
	//添加至知识库答案列表
	public static void insertIntoFaqAnswer(String faqAnswerId, String faqcontent, String questionid, String userid) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		AnswerPersistenceMapper mapper  = session.getMapper(AnswerPersistenceMapper.class);
		 mapper.insertIntoFaqAnswer(faqAnswerId,  faqcontent, questionid, userid);
		session.close();
		
	}
	
}
