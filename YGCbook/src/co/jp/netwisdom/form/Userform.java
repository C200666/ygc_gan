package co.jp.netwisdom.form;

import org.apache.struts.action.ActionForm;

public class Userform extends ActionForm {
	private String username;
	private String password;
	private String sex;
	private String major;
	private String intro;
	private String[] hobby;
	private String[] checkOne;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String[] getCheckOne() {
		return checkOne;
	}
	public void setCheckOne(String[] checkOne) {
		this.checkOne = checkOne;
	}
	
}
