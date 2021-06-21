/**
 * 
 */
package com.example.demo.user;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.user.Message;
import com.example.demo.user.User;


public class UserTest {
	
	private User user;
	private User friend;

	@Before
	public void setUp() throws Exception {
		user = new User("MyUser");
		friend = new User("Friend");
		user.addFriend(friend);
	}

	@Test
	public void testGetWallSorted() {
		ZonedDateTime now = ZonedDateTime.now();
		
		Message userMessage = new Message(user, now, "first message");
		user.postMessage(userMessage);

		Message friendMessage = new Message(friend, now.minusHours(1), "second message");
		friend.postMessage(friendMessage);
		
		List<Message> wall = user.getWall();
		assertEquals(2, wall.size());
		
		assertEquals(userMessage, wall.get(0));
		assertEquals(friendMessage, wall.get(1));
	}

}
