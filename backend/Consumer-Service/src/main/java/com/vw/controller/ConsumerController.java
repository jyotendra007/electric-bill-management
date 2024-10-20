package com.vw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vw.model.Consumer;
import com.vw.model.ConsumerDto;
import com.vw.service.ConsumerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
	
	@Autowired
	private ConsumerService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addConsumer(@Valid @RequestBody ConsumerDto dto) {
		if (service.consumerExists(dto.getConsumerId())) { // Check if the consumer already exists
	        return new ResponseEntity<>("Consumer with ID : "+dto.getConsumerId()+" already exists.", HttpStatus.CONFLICT);
	    }
		Consumer consumer = service.addConsumer(dto);
		return new ResponseEntity<>(consumer, HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{consumerId}")
	public ResponseEntity<Consumer> getSingleConsumer(@PathVariable String consumerId) {
		Consumer consumer = service.getSingleConsumer(consumerId);
		return new ResponseEntity<>(consumer, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Consumer>> getAllConsumers(){
		List<Consumer> list = service.getAllConsumers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/individuals")
	public ResponseEntity<List<Consumer>> getAllIndividuals(){
		List<Consumer> list = service.getAllIndividuals();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/organizations")
	public ResponseEntity<List<Consumer>> getAllOrganizations(){
		List<Consumer> list = service.getAllOrganizations();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PatchMapping("/id/{consumerId}")
	public ResponseEntity<Consumer> updateConsumer(@PathVariable String consumerId, @Valid @RequestBody  ConsumerDto dto) {
		Consumer consumer = service.updateConsumer(consumerId, dto);
		return new ResponseEntity<>(consumer, HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{consumerId}")
	public ResponseEntity<String> deleteConsumers(@PathVariable String consumerId) {
		String msg = service.deleteConsumers(consumerId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/add-multiple-consumers")
	public ResponseEntity<List<Consumer>> addMultipleConsumers(@Valid @RequestBody List<ConsumerDto> dtos){
		List<Consumer> list = service.addMultipleConsumers(dtos);
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}

}
