package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.CommentPersistence;

public interface CommentPersistenceMapper extends IBaseDao<CommentPersistence, String>{
	/*
	 * zyq_faq3_ajax_添加评论
	 */
	@Insert("INSERT INTO TBL_Comment(COMMENTID,FAQQUESTIONID,COMMUNITYQUESTIONID,USERID,COMMENTCONTENT,COMMENTTIME,COMMENTPARENTID) VALUES (#{0},#{1},#{2},#{3},#{4},#{5},#{6})")
	void saveComment(String commentid, String faqquestionid, String communityquestionid, String userid,String commentcont, String commenttime, String commentparentid);
	/*
	 * zyq_faq3_查看评论
	 */
	@Select("SELECT * FROM TBL_Comment WHERE FAQQUESTIONID=#{0}")
	List<CommentPersistence> getComment(String faqquestionid);
	/*
	 * zyq_question2_查看回复
	 */
	@Select("SELECT * FROM TBL_Comment WHERE COMMUNITYQUESTIONID=#{0} AND COMMENTPARENTID=#{1} ORDER BY COMMENTTIME ASC")
	List<CommentPersistence> question2_getComment(String questionid, String parentId);
	/*
	 * zyq_question2_查看回复_前五条
	 */
	@Select("SELECT * FROM TBL_Comment WHERE COMMUNITYQUESTIONID=#{0} AND COMMENTPARENTID=#{1} ORDER BY COMMENTTIME ASC LIMIT 5")
	List<CommentPersistence> question2_getComment_Limit(String questionid, String parentId);
	/*
	 * zyq_question2_查看回复
	 */
	@Select("SELECT * FROM TBL_Comment WHERE COMMENTPARENTID=#{0} AND USERID=#{1} AND COMMENTCONTENT=#{2} ORDER BY COMMENTTIME ASC")
	List<CommentPersistence> question2_getComment2(String answerId, String userId, String content);
	/*
	 * zyq_question2_获得更多的回复
	 */
	@Select("SELECT * FROM TBL_Comment WHERE COMMUNITYQUESTIONID=#{0} AND COMMENTPARENTID=#{1} ORDER BY COMMENTTIME ASC LIMIT #{2},5 ")
	List<CommentPersistence> question2_getMoreComment(String questionId, String answerId, int startnumber);

}