package com.gm.service;

public class GreetingsServiceHello implements GreetingsServiceInterface {

	@Override
	public void sayGreeting(String name) {
		System.out.println("Hello " + name);
	}
}
