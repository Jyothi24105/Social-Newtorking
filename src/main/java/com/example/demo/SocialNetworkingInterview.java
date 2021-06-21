/**
 * 
 */
package com.example.demo;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkingInterview implements CommandLineRunner {
	
	@Inject
	private SocialNetwork network;

	@Override
	public void run(String... args) {
		network.start();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkingInterview.class, args);
	}
}
