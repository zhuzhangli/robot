package org.xjtusicd3.partner.view;

import org.xjtusicd3.database.model.UserPersistence;

public class User_faq2View {
	private int userId;
	private String userName;
	private String userImage;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public User_faq2View(UserPersistence userPersistence ){
		this.userId = userPersistence.getUserId();
		this.userName = userPersistence.getUserName();
		this.userImage = userPersistence.getUserImage();
	}
	public User_faq2View(){
		
	}
}