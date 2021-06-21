/**
 * 
 */
package com.example.demo.command;

import java.util.List;

import com.example.demo.console.Console;
import com.example.demo.user.Message;
import com.example.demo.user.User;


public class WallCommand implements Command {
	
	private User user;

	public User getUser() {
		return user;
	}

	public WallCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(Console console) {
		List<Message> wall = user.getWall();
		
		for (Message message : wall) {
			console.write(message);
		}
	}
}
