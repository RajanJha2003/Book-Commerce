package operations;

import model.UserPojo;

public interface UserOperations {
	
	public boolean userRegister(UserPojo us);
	
	public boolean checkUser(String email);
	
	public UserPojo login(String email,String password);
	
	public boolean updateProfile(UserPojo us);
	
	public boolean checkPassword(int id,String ps);

}
