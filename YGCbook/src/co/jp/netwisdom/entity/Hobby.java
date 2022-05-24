package co.jp.netwisdom.entity;

public class Hobby {
	private String username;
	private String hobby;
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getHobby(){
		return hobby;
	}
	public void setHobby(String hobby){
		this.hobby = hobby;
	}
	
	
	public Hobby(String username,String hobby){
		super();
		this.username = username;
		this.hobby = hobby;
	}
	public Hobby(){
		super();
	}
	
}
