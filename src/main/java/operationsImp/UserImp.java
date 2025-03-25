package operationsImp;

import dao.UserDAO;
import model.UserPojo;
import operations.UserOperations;

public class UserImp implements UserOperations {

	@Override
	public boolean userRegister(UserPojo us) {
		// TODO Auto-generated method stub
		return new UserDAO().userRegister(us);
	}

	@Override
	public boolean checkUser(String email) {
		// TODO Auto-generated method stub
		return new UserDAO().checkUser(email);
	}

	@Override
	public UserPojo login(String email, String password) {
		// TODO Auto-generated method stub
		return new UserDAO().login(email, password);
	}

	@Override
	public boolean updateProfile(UserPojo us) {
		// TODO Auto-generated method stub
		return new UserDAO().updateProfile(us);
	}

	@Override
	public boolean checkPassword(int id, String ps) {
		// TODO Auto-generated method stub
		return new UserDAO().checkPassword(id, ps);
	}

	@Override
	public boolean forgotPassword(String email, String phno, String password) {
		// TODO Auto-generated method stub
		return new UserDAO().forgotPassword(email, phno, password);
	}

}
