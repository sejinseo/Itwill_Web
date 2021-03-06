package edu.web.jsp07.persistence;

import static edu.web.jsp07.model.User.Entry.*;

import edu.web.jsp07.model.User;
public interface UserDao {
	//public static final 생략 가능 -> interface이기 때문에
	String SQL_CHECK_SIGNIN = String.format(
			"select * from %s where %s = ? and %s = ?",
			TABLE_USERS, COL_USERID, COL_PWD);
	User checkSignIn(String id, String pw); 
	
}