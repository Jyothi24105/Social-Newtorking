/**
 * 
 */
package com.example.demo.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.example.demo.user.Message;


@Component
public class Console {
	
	@Inject
	private MessageFormatter formatter;
	
	private BufferedReader reader;
	
	public Console() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String readCommand() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Failed reading from the console", e);
		}
	}
	
	public void write(Message message) {
		String line = formatter.format(message);
		write(line);
	}
	
	public void write(String text) {
		System.out.println(text);
	}
}
