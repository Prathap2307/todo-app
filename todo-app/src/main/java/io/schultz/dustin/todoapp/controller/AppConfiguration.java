package io.schultz.dustin.todoapp.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.schultz.dustin.todoapp.model.TodoList;


@Configuration
public class AppConfiguration {
	
	 @Bean
	   public TodoList getUseBeanNameTest(){
	      return new TodoList();
	   }

}
