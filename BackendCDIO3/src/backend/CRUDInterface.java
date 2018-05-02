package backend;

import java.util.Map;

public interface CRUDInterface {
	
	//Creates a new userDTO object
	public void createUserDTO(UserDTO userDTO);
		
	//Returns a single UserDTO object
	public UserDTO getUserDTO(int userId);
	
	//Returns all UserDTO objects
	public Map<Integer, UserDTO> getUserDTO();
	
	//Updates a currently existing userDTO object
	public void updateUserDTO(int userId, String userName, String ini, String cpr, String password);
	
	//Deletes a currently existing userDTO object
	public void deleteUserDTO(int userId);
}
