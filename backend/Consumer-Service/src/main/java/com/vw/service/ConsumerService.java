package com.vw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vw.dao.ConsumerDaoImpl;
import com.vw.model.Consumer;
import com.vw.model.ConsumerDto;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerDaoImpl impl;
	
	public Consumer addConsumer(ConsumerDto dto) {
		return impl.addConsumer(dto);
	}
	
	public Consumer getSingleConsumer(String consumerId) {
		return impl.getSingleConsumer(consumerId);
	}
	
	public List<Consumer> getAllConsumers(){
		return impl.getAllConsumers();
	}
	
	public List<Consumer> getAllIndividuals(){
		return impl.getAllIndividuals();
	}
	
	public List<Consumer> getAllOrganizations(){
		return impl.getAllOrganizations();
	}
	
	public Consumer updateConsumer(String consumerId, ConsumerDto dto) {
		return impl.updateConsumer(consumerId, dto);
	}
	
	public String deleteConsumers(String consumerId) {
		return impl.deleteConsumers(consumerId);
	}
	
	public List<Consumer> addMultipleConsumers(List<ConsumerDto> dtos){
		return impl.addMultipleConsumers(dtos);
	}
	
	public boolean consumerExists(String consumerId) {
		return impl.consumerExists(consumerId);
	}
}
