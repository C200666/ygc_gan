package co.jp.netwisdom.dto;

public class HobbyDto {
	
	private String hobby;
	
	
	public String getHobby(){
		return hobby;
	}
	public void setHobby(String hobby){
		this.hobby = hobby;
	}
	
	
	public HobbyDto(String hobby){
		super();
		this.hobby = hobby;
	}
	public HobbyDto(){
		super();
	}
	
}
