package operations;

import model.UserPojo;

public interface UserOperations {
	
	public boolean userRegister(UserPojo us);
	
	public boolean checkUser(String email);

}
