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
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	public User getUser(int id) {
		return userDao.getUser(id);
		
	}

	@Transactional
	public void deleteUser(int id) {

		userDao.deleteUser(id);
		
	}

	@Transactional
	public void updateUser(User user) {

		userDao.updateUser(user);
	}
	}
