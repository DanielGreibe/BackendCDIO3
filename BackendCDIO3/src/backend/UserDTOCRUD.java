package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("userDTO")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserDTOCRUD implements CRUDInterface{

	static Map<Integer, UserDTO> users = new HashMap<>();
		/* Creates some dummy data to test */
   static {
	   List<String> user1roles = new ArrayList<String>();
	   user1roles.add("Administrator");
	   user1roles.add("Farmaceut");
	   List<String> user2roles = new ArrayList<String>();
	   user2roles.add("Laborant");
	      users.put(1, new UserDTO(1, "DanielGreibe", "DG", "123456-7890", "Password"));
	      users.put(2, new UserDTO(2, "MrErickson", "MR", "098765-4321", "Password2"));
	      users.get(1).setRoles(user1roles);
	      users.get(2).setRoles(user2roles);
   }
   
	@GET
	@Path("{userId}")
	public UserDTO getUserDTO(@PathParam("userId") int userId) {
		return users.get(userId);
	}

	@GET
	public Map<Integer, UserDTO> getUserDTO() {
		return users;
	}

	@POST
	@Path("create")
	public void createUserDTO(UserDTO userDTO) {
		/* Creates an ingredient and puts it in the list */
		
			users.put(userDTO.getUserId(), userDTO);
		}

	@GET
	@Path("{userId}/{userName}/{ini}/{cpr}/{password}")
	public void updateUserDTO(@PathParam("userId") int userId, @PathParam("userName") String userName, @PathParam("ini") String ini, @PathParam("cpr") String cpr, @PathParam("password") String password) {
		UserDTO currentUser;
		currentUser = users.get(userId);
		
		currentUser.setUserId(userId);
		currentUser.setUserName(userName);
		currentUser.setIni(ini);
		currentUser.setCpr(cpr);
		currentUser.setPassword(password);
	}

	@DELETE
	@Path("{userId}")
	public void deleteUserDTO(@PathParam("userId") int userId) {
		users.remove(userId);	
	}

}
