/**
 * 
 */
package com.example.demo.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.example.demo.command.Command;
import com.example.demo.command.ReadCommand;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@Component
public class ReadCommandParser implements CommandParser {

	private static final String READ_PATTERN = "^(?<name>[^\\s]*)$";

	@Inject
	private UserRepository users;

	@Override
	public boolean canHandle(String line) {
		return line.matches(READ_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(READ_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}

		String name = matcher.group("name");

		User user = users.getOrCreate(name);

		ReadCommand command = new ReadCommand(user);
		return command;
	}
}
