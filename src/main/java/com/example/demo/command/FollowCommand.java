/**
 * 
 */
package com.example.demo.command;

import com.example.demo.console.Console;
import com.example.demo.user.User;


public class FollowCommand implements Command {
	
	private User user;
	private User friend;
	
	public User getUser() {
		return user;
	}

	public User getFriend() {
		return friend;
	}

	public FollowCommand(User user, User friend) {
		this.user = user;
		this.friend = friend;
	}

	@Override
	public void execute(Console console) {
		user.addFriend(friend);
	}

}
