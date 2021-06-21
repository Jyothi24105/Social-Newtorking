/**
 * 
 */
package com.example.demo.command.parser;

import com.example.demo.command.Command;

public interface CommandParser {
	
	public boolean canHandle(String line);
	
	public Command parse(String line);

}
