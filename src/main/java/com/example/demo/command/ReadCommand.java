/**
 * 
 */
package com.example.demo.command;

import com.example.demo.console.Console;
import com.example.demo.user.Message;
import com.example.demo.user.User;


public class ReadCommand implements Command {
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public ReadCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(Console console) {
		for (Message message : user.getMessages()) {
			console.write(message);
		}
	}

}
