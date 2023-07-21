package io.schultz.dustin.todoapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.schultz.dustin.todoapp.TestModal.Product;
import io.schultz.dustin.todoapp.exceptions.ProductNotfoundException;

@RestController
public class ProductServiceController {
	
	@Autowired
	private BeanTest BeanTestPP;

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { // throw
																												// new
																												// ProductNotfoundException();
		if (!productRepo.containsKey(id)) {
			throw new ProductNotfoundException();
		}
		
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/productsResponseEntity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> productsResponseEntity(@PathVariable("id") String id, @RequestBody Product product) { 
		
		Map<String, Object> obj = new HashMap<>();
		
		if (!productRepo.containsKey(id)) {
			throw new ProductNotfoundException();
		}
		System.out.println("test -->");
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		//return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		
		obj.put("Message", "Product is updated successfully");
		//obj.put("Product is updated successfully", productRepo);
		
		return ResponseEntity.accepted().body(obj);
	}

	@RequestMapping(value = "/productsMap", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> updateProduct() {
		
		Map<String, Object> accountHeadDetails = new HashMap<>();
		Product mini = new Product();
		mini.setId("1");
		mini.setName("prathap");
		accountHeadDetails.put("UpdatedDetails", mini);
		
		
		 ObjectMapper objectMapper = new ObjectMapper();
	 		try {
	 			 System.out.println("ObjectMapper -->" +  	objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountHeadDetails));
			
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	 		
		return ResponseEntity.accepted().body(accountHeadDetails);
	}

}
