package com.gm.service;

import com.gm.service.GreetingsProvider;
import com.gm.service.GreetingsServiceInterface;

public class Main {

	public static void main(String[] args) {

        GreetingsServiceInterface service = GreetingsProvider.getInstance().serviceImpl();
		
        service.sayGreeting("How are you?");

	}
}
