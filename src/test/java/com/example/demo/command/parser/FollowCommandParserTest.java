package com.example.demo.command.parser;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.command.Command;
import com.example.demo.command.FollowCommand;
import com.example.demo.command.parser.FollowCommandParser;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class FollowCommandParserTest {

	@InjectMocks
	private FollowCommandParser parser;
	
	@Mock
	private UserRepository users;
	
	@Mock
	private User charlie;
	@Mock
	private User bob;
	
	@Before
	public void setup() {
		when(users.getOrCreate("Charlie")).thenReturn(charlie);
		when(users.getOrCreate("Bob")).thenReturn(bob);
	}

	@Test
	public void testCanHandle() {
		boolean canHandle = parser.canHandle("Charlie follows Bob");
		assertTrue(canHandle);
	}
	
	@Test
	public void testCanHandleWithUnparsableLine() {
		boolean canHandle = parser.canHandle("NOT_PARSABLE");
		assertFalse(canHandle);
	}

	@Test
	public void testParse() {
		Command command = parser.parse("Charlie follows Bob");
		
		assertTrue(command instanceof FollowCommand);
		
		FollowCommand followCommand = (FollowCommand)command;
		User user = followCommand.getUser();
		assertEquals(charlie, user);
		
		User friend = followCommand.getFriend();
		assertEquals(bob, friend);
	}
}
