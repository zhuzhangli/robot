package org.xjtusicd3.database.model;


import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;
@Table(tablename="Answer")
public class AnswerPersistence {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="AnswerId")
	private String AnswerId;
	@TableField(columnName="QuestionId")
	private String QuestionId;
	@TableField(columnName="FaqContent")
	private String FaqContent;
	@TableField(columnName="UserId")
	private String AnswerUserId;
	@TableField(columnName="FaqCollection")
	private int FaqCollection;
	@TableField(columnName="FaqScan")
	private int FaqScan;
	@TableField(columnName="FaqModifytime")
	private String FaqModifytime;
	@TableField(columnName="FaqWritetime")
	private int FaqWritetime;
	@TableField(columnName="FaqScore")
	private float FaqScore;
	
	public String getAnswerId() {
		return AnswerId;
	}
	public void setAnswerId(String answerId) {
		AnswerId = answerId;
	}
	public String getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(String questionId) {
		QuestionId = questionId;
	}
	public String getFaqContent() {
		return FaqContent;
	}
	public void setFaqContent(String faqContent) {
		FaqContent = faqContent;
	}
	public String getAnswerUserId() {
		return AnswerUserId;
	}
	public void setAnswerUserId(String answerUserId) {
		AnswerUserId = answerUserId;
	}
	public int getFaqCollection() {
		return FaqCollection;
	}
	public void setFaqCollection(int faqCollection) {
		FaqCollection = faqCollection;
	}
	public int getFaqScan() {
		return FaqScan;
	}
	public void setFaqScan(int faqScan) {
		FaqScan = faqScan;
	}
	public String getFaqModifytime() {
		return FaqModifytime;
	}
	public void setFaqModifytime(String faqModifytime) {
		FaqModifytime = faqModifytime;
	}
	public int getFaqWritetime() {
		return FaqWritetime;
	}
	public void setFaqWritetime(int faqWritetime) {
		FaqWritetime = faqWritetime;
	}
	public float getFaqScore() {
		return FaqScore;
	}
	public void setFaqScore(float faqScore) {
		FaqScore = faqScore;
	}
	
}
