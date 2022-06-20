package co.jp.netwisdom.dto;

public class UserRigisterDto {
	
	private String username;
	private String password;
	private String sex;
	private String major;
	private String intro;
	private String[] hobby;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public String getMajor() {
		return major;
	}

	public String getIntro() {
		return intro;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
