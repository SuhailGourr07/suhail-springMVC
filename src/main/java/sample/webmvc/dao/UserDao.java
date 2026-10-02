package sample.webmvc.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sample.webmvc.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public User saveUser(User user) {
		System.out.println("hibernateTemplate called");
		 hibernateTemplate.save(user);
		 return user;
		
	}

	public User getUser(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	public void deleteUser(int id) {

		User user = hibernateTemplate.get(User.class, id);
		
		hibernateTemplate.delete(user);
	}
	
}
