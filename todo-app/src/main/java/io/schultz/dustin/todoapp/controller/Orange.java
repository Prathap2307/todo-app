package io.schultz.dustin.todoapp.controller;

import org.springframework.stereotype.Service;

@Service("orangeComponent")
public class Orange implements BeanTestInterface {
	
	public void orangeComponentTestFn() {
		System.out.println("orangeComponentTestFn ----------------------------------------->");
	}

	@Override
	public String findWhichFruit() {
		// TODO Auto-generated method stub
		System.out.println("orange fruit ----------------------------------------->");
		
		return "orange";
	}

}
