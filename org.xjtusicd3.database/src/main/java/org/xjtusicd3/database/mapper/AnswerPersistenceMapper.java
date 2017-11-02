package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.AnswerPersistence;

public interface AnswerPersistenceMapper extends IBaseDao<AnswerPersistence, String>{
	/*
	 * zyq_faq3_知识内容
	 */
	@Select("SELECT * FROM TBL_FAQanswer WHERE FAQQUESTIONID=#{0}")
	public List<AnswerPersistence> faq3_faqContent(String QuestionId);
	/*
	 * zyq_notice_ajax_查询FAQ评论通知
	 */
	@Select("SELECT * FROM TBL_FAQanswer WHERE USERID=#{0}")
	public List<AnswerPersistence> notice_faqanswerList(String userId);
	
	//获取faqanswerId相对应的内容
	@Select("SELECT FAQCONTENT FROM TBL_FAQanswer WHERE FAQANSWERID=#{0}")
	public String getContentById(String faqAnswerId);
	
	
	//添加至知识库答案列表
	@Insert("INSERT INTO TBL_FAQanswer(FAQANSWERID,FAQCONTENT,FAQQUESTIONID,USERID) "
			+ "VALUES (#{0},#{1},#{2},#{3}")
	public void insertIntoFaqAnswer(String faqAnswerId, String faqcontent, String questionid, String userid);
	
}
