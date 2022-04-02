package edu.web.service;

import java.util.List;

import edu.web.domain.User;
import edu.web.persistence.BoardDao;
import edu.web.persistence.UserDao;
import edu.web.persistence.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	private BoardDao boardDao;
	
	//Singleton 패턴
	private static UserServiceImpl instance = null;
	private UserServiceImpl () {
		userDao = UserDaoImpl.getInstance();
		
	}
	public static UserServiceImpl getInstance () {
		if(instance == null) {
			instance = new UserServiceImpl(); 
		}		
		return instance;
	}	

	@Override
	public List<User> select() {
		return userDao.read();
	}
	@Override
	public int joinNewUser(User user) {
		int result = 0;
		result = userDao.join(user);
		return result;
	}
	@Override
	public User select(String userId) {

		User user = userDao.read(userId);	
		return user;
	}


}