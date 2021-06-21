/**
 * 
 */
package com.example.demo.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	
	private String name;
	private Set<User> friends;
	private List<Message> messages;
	
	public User(String name) {
		this.name = name;
		this.friends = new HashSet<>();
		this.messages = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}

	public void postMessage(Message message) {
		messages.add(message);
	}
	
	public void addFriend(User friend) {
		friends.add(friend);
	}
	
	public Set<User> getFriends() {
		return Collections.unmodifiableSet(friends);
	}

	public List<Message> getWall() {
		List<Message> wall = new ArrayList<>();
		
		wall.addAll(messages);
		
		for (User friend : friends) {
			wall.addAll(friend.getMessages());
		}
		
		wall.sort((m1, m2) -> m2.getSentTime().compareTo(m1.getSentTime()));
		
		return wall;
	}
}
