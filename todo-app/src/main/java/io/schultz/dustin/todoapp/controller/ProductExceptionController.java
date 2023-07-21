package io.schultz.dustin.todoapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.schultz.dustin.todoapp.exceptions.ItemsNullException;
import io.schultz.dustin.todoapp.exceptions.ProductNotfoundException;

@ControllerAdvice
public class ProductExceptionController {
	
	 @ExceptionHandler(value = ProductNotfoundException.class)
	   public ResponseEntity<Map<String, Object>> exception(ProductNotfoundException exception) {
		 
		 Map<String, Object> exceptionObj = new HashMap<>();
		 
		 System.out.println("exception -->"+ exception);
		 exceptionObj.put("exceptionMessage", "Product not found");
	    //  return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		 
		  return ResponseEntity.accepted().body(exceptionObj);
	   }
	 
	 @ExceptionHandler(value = ItemsNullException.class)
	   public ResponseEntity<Map<String, Object>> itemException() {
		 
		 Map<String, Object> exceptionObj = new HashMap<>();
		 
		// System.out.println("exception -->"+ exception);
		 exceptionObj.put("exceptionMessage", "item not found");
	    //  return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		 
		  return ResponseEntity.accepted().body(exceptionObj);
	   }

}
