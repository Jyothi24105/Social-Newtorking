/**
 * 
 */
package com.example.demo;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.command.Command;
import com.example.demo.command.parser.CommandParser;
import com.example.demo.command.parser.CommandParserRepository;
import com.example.demo.console.Console;

@Service
public class SocialNetwork {

	@Inject
	private Console console;

	@Inject
	private CommandParserRepository parserRepository;

	public void start() {
		String line;
		while ((line = console.readCommand()) != null) {
			parseAndExecuteCommand(line);
		}

		console.write("bye");
	}

	private void parseAndExecuteCommand(String line) {
		Optional<CommandParser> parser = parserRepository.findParser(line);
		if (parser.isPresent()) {
			Command command = parser.get().parse(line);
			command.execute(console);
		} else {
			console.write("Unknown command: " + line);
		}
	}
}
