/**
 * 
 */
package com.example.demo.console;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.example.demo.user.Message;
import com.example.demo.user.User;


@Component
public class MessageFormatter {
	
	public String format(Message message) {
		StringBuilder line = new StringBuilder();

		User author = message.getAuthor();
		line.append(author.getName());

		line.append(" - ");
		line.append(message.getText());

		ZonedDateTime messageTime = message.getSentTime();
		long seconds = messageTime.until(ZonedDateTime.now(), ChronoUnit.SECONDS);

		if (seconds < 60) {
			line.append(" (").append(seconds).append(" seconds ago)");
		} else {
			long minutes = messageTime.until(ZonedDateTime.now(), ChronoUnit.MINUTES);
			line.append(" (").append(minutes).append(" minutes ago)");
		}
		
		return line.toString();
	}

}
