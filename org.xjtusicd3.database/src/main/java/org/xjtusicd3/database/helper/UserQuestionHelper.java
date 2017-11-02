package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.RobotAnswerPersistenceMapper;
import org.xjtusicd3.database.mapper.UserPersistenceMapper;
import org.xjtusicd3.database.mapper.UserQuestionPersistenceMapper;
import org.xjtusicd3.database.model.ClassifyPersistence;
import org.xjtusicd3.database.model.RobotAnswerPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.database.model.UserQuestionPersistence;

public class UserQuestionHelper
{
	public static void main(String[] args)
	{
		System.out.println(getUserQuestion());
	}
	//获取用户问题信息
		public static List<UserQuestionPersistence> getUserQuestion()
		{
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			List<UserQuestionPersistence> userlist = mapper.getUserQuestion();
			session.close();
			return userlist;
		}
		
		//获取用户问题信息
				public static List<UserQuestionPersistence> getUserQuestion(String UserQuestionId)
				{
					SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
					UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
					List<UserQuestionPersistence> userlist = mapper.getUserQuestionById(UserQuestionId);
					session.close();
					return userlist;
				}
		
		//删除用户问题信息
		public static void deleteUserQuestion(String userquestionid) 
		{
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			mapper.deleteUserQuestion(userquestionid);  
			session.close();
			
		}
		
		/**
		 * author:zzl
		 * abstract:记录用户提问记录
		 * data:2017年10月22日18:43:47
		 */
		public static void addUserQuestion(String userQuestionId, String userQuestionTitle, String time, int isFaq, String userId) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			mapper.addUserQuestion(userQuestionId,userQuestionTitle,time,isFaq,userId);
			session.close();
			
		}
		
		//获取用户提问问题Id
		public static String queationUserId(String userId, String comment) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			String questionId = mapper.queationUserId(userId, comment);
			session.close();
			return questionId;
		}
		
		//用户满意度问答表
		public static void addUserSaticfaction(String robotAnswerId, int saticfaction, String questionId, String answerId) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			RobotAnswerPersistenceMapper mapper = session.getMapper(RobotAnswerPersistenceMapper.class);
			mapper.addUserSaticfaction(robotAnswerId,saticfaction,questionId,answerId);
			session.close();
			
		}
		
		//查看用户提问问题标题
		public static String getNameById(String questionId) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			String title = mapper.getNameById(questionId);
			session.close();
			return title;
		}
		
		//获得用户满意度
		public static List<RobotAnswerPersistence> getUserSaticfaction(String userquestionid) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			List<RobotAnswerPersistence> saticfaction = mapper.getUserSaticfaction(userquestionid);
			session.close();
			return saticfaction;
		}
		
		//获取应答表中问题对应的知识库答案id
		public static String getFaqAnswerIdByQuestionId(String userQuestionId) {
			SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
			UserQuestionPersistenceMapper mapper = session.getMapper(UserQuestionPersistenceMapper.class);
			String faqAnswerId = mapper.getFaqAnswerIdByQuestionId(userQuestionId);
			session.close();
			return faqAnswerId;
		}
	
}
