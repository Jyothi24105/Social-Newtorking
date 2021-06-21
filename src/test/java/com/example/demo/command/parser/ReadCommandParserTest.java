package com.example.demo.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.command.Command;
import com.example.demo.command.ReadCommand;
import com.example.demo.command.parser.ReadCommandParser;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class ReadCommandParserTest {

	@InjectMocks
	private ReadCommandParser parser;

	@Mock
	private UserRepository users;

	@Mock
	private User alice;

	@Before
	public void setup() {
		when(users.getOrCreate("Alice")).thenReturn(alice);
	}

	@Test
	public void testCanHandle() {
		boolean canHandle = parser.canHandle("Alice");
		assertTrue(canHandle);
	}

	@Test
	public void testCanHandleWithUnparsableLine() {
		boolean canHandle = parser.canHandle("NOT_PARSABLE COMMAND");
		assertFalse(canHandle);
	}

	@Test
	public void testParse() {
		Command command = parser.parse("Alice");

		assertTrue(command instanceof ReadCommand);

		ReadCommand readCommand = (ReadCommand)command;
		User user = readCommand.getUser();
		assertEquals(alice, user);
	}
}
