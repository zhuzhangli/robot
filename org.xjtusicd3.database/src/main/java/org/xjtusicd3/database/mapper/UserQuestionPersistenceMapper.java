package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.ClassifyPersistence;
import org.xjtusicd3.database.model.QuestionPersistence;
import org.xjtusicd3.database.model.RobotAnswerPersistence;
import org.xjtusicd3.database.model.UserPersistence;
import org.xjtusicd3.database.model.UserQuestionPersistence;

public interface UserQuestionPersistenceMapper extends IBaseDao<UserQuestionPersistence, String>
{
	//zpz_获取用户问题
		@Select("SELECT * FROM TBL_UserQuestion ORDER BY QUESTIONTIME DESC")
		List<UserQuestionPersistence> getUserQuestion();
		
	//zpz _find userQuestion by UserQuestionId
				@Select("SELECT * FROM TBL_UserQuestion WHERE USERQUESTIONID=#{0}")
				List<UserQuestionPersistence> getUserQuestionById(String userQuestionId);
		
	//zpz_删除用户问题信息
		@Delete("DELETE FROM TBL_UserQuestion WHERE TBL_User.USERQUESTIONID=#{0}")
		public void deleteUserQuestion(String userQuestionId);
		
		//zzl_记录用户提问记录_2017年10月22日18:43:47
		@Insert("INSERT INTO TBL_UserQuestion(TBL_UserQuestion.USERQUESTIONID,TBL_UserQuestion.QUESTIONTITLE,TBL_UserQuestion.QUESTIONTIME,TBL_UserQuestion.ISFAQ,TBL_UserQuestion.USERID)"
				+ " VALUES (#{0},#{1},#{2},#{3},#{4})")
		void addUserQuestion(String userquestionid, String questiontitle, String questiontime, int isFaq,
				String userid);
		
		//获取用户提问问题Id
		@Select("SELECT USERQUESTIONID FROM TBL_UserQuestion WHERE USERID=#{0} AND QUESTIONTITLE=#{1} ORDER BY QUESTIONTIME DESC LIMIT 1")
		String queationUserId(String userId, String comment);

		//查看用户提问问题标题
		@Select("SELECT QUESTIONTITLE FROM TBL_UserQuestion WHERE USERQUESTIONID=#{0} ")
		String getNameById(String questionId);
		
		//获得用户满意度
		@Select("SELECT * FROM TBL_RobotAnswer WHERE USERQUESTIONID=#{0} ")
		List<RobotAnswerPersistence> getUserSaticfaction(String userquestionid);

		//获取应答表中问题对应的知识库答案id
		@Select("SELECT FAQANSWERID FROM TBL_RobotAnswer WHERE USERQUESTIONID=#{0} ")
		String getFaqAnswerIdByQuestionId(String userQuestionId);
		
		
}
