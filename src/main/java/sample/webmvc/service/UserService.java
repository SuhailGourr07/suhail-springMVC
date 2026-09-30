package sample.webmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.webmvc.dao.UserDao;
import sample.webmvc.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public User getUser(int id) {
		User user = userDao.getUser(id);
		if(user == null) {
			System.out.println("User not found with " + id);
			return null;
		}
		return user;
	}
	
	
	public boolean updateUser(int id,String name,String gender,String address)
	{
	User user = userDao.getUser(id);
	if(user == null) {
		return false;
	}
	user.setName(name);
	user.setGender(gender);
	user.setAddress(address);
	
	userDao.updateUser(user);
	return true;
	}
	}
