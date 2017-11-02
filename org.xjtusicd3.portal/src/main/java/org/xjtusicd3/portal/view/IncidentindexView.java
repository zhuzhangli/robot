package org.xjtusicd3.portal.view;

public class IncidentindexView 
{
	private String userQuestionTitle;
	private String userName;
	private String userQuestionTime;
	private String UserQuestionId;
	private String faqAnswer; //zzl_已处理问题对应的答案
		
	public String getUserQuestionId()
	{
		return UserQuestionId;
	}
	public void setUserQuestionId(String userQuestionId)
	{
		UserQuestionId = userQuestionId;
	}
	public String getUserQuestionTitle() {
		return userQuestionTitle;
	}
	public void setUserQuestionTitle(String userQuestionTitle) {
		this.userQuestionTitle = userQuestionTitle;
	}
	 
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserQuestionTime() {
		return userQuestionTime;
	}
	public void setUserQuestionTime(String userQuestionTime) {
		this.userQuestionTime = userQuestionTime;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	
}
