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
import com.example.demo.command.WallCommand;
import com.example.demo.command.parser.WallCommandParser;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class WallCommandParserTest {

	@InjectMocks
	private WallCommandParser parser;

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
		boolean canHandle = parser.canHandle("Alice wall");
		assertTrue(canHandle);
	}

	@Test
	public void testCanHandleWithUnparsableLine() {
		boolean canHandle = parser.canHandle("NOT_PARSABLE");
		assertFalse(canHandle);
	}

	@Test
	public void testParse() {
		Command command = parser.parse("Alice wall");

		assertTrue(command instanceof WallCommand);

		WallCommand wallCommand = (WallCommand)command;
		User user = wallCommand.getUser();
		assertEquals(alice, user);
	}
}
