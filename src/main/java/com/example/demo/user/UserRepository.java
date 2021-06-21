/**
 * 
 */
package com.example.demo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class UserRepository {
	
	private Map<String, User> users;
	
	public UserRepository() {
		users = new HashMap<String, User>();
	}
	
	public void add(User user) {
		users.put(user.getName(), user);
	}
	
	public User getOrCreate(String name) {
		
		if (exists(name)) {
			return get(name);
		} else {
			User user = new User(name);
			add(user);
			return user;
		}
	}
	
	public boolean exists(String name) {
		return users.containsKey(name);
	}
	
	public User get(String name) {
		return users.get(name);
	}

}
