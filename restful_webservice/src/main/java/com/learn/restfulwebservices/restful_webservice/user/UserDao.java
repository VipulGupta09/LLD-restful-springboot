package com.learn.restfulwebservices.restful_webservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDao {
	private static ArrayList<User> list = new ArrayList<User>();
	
	private int id=3;
	static {
		list.add(new User(1, "abc", new Date()));
		list.add(new User(2, "def", new Date()));
		list.add(new User(3, "ghi", new Date()));
	}
	
	public User createUser(User user) {
			user.setId(++id);
			list.add(user);
			return user;
	}
	
	public List<User> getAllUsers(){
		return list;
	}
	
	public int deleteUser(int id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()==id) {
				list.remove(i);
				return id;
			}
		}
		return -1;	
	}
	
	public User getUserDetails(int id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()==id) {
				
				return list.get(i);
			}
		}
		return null;	
	}
	
}
