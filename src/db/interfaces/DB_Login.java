package db.interfaces;

import model.User;

public interface DB_Login {
	boolean verify(String username,String passwd);
	boolean verify(User user);
	User getUserBYid(String sid);

}
