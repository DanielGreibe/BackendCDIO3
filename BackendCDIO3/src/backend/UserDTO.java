package backend;

import java.util.List;

public class UserDTO {
	int userId;                     
	String userName;                
	String ini;                 
	String cpr;                 
	String password;
	List<String> roles;
	
	public UserDTO()
	{
		
	}
	
	public UserDTO(int userId, String userName, String ini, String cpr, String password) 
	{
		this.userId = userId;
		this.userName = userName;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
//		this.roles = roles;
	}
	//Public getter and setter functions
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
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public String getCpr() {
		return cpr;
	}
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
