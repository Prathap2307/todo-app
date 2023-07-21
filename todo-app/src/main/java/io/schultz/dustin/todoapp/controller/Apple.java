package io.schultz.dustin.todoapp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("appleComponent")
public class Apple implements BeanTestInterface {

	@Override
	public String findWhichFruit() {
		// TODO Auto-generated method stub
		System.out.println("apple fruit ----------------------------------------->");
		
		return "apple";
	}
	
	

}
