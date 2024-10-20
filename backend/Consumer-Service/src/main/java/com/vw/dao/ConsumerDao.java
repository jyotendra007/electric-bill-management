package com.vw.dao;

import java.util.List;

import com.vw.model.Consumer;
import com.vw.model.ConsumerDto;

public interface ConsumerDao {
	
	public Consumer addConsumer(ConsumerDto dto);
	
	public Consumer getSingleConsumer(String consumerId);
	
	public List<Consumer> getAllConsumers();
	
	public List<Consumer> getAllIndividuals();
	
	public List<Consumer> getAllOrganizations();
	
	public Consumer updateConsumer(String consumerId, ConsumerDto dto);
	
	public String deleteConsumers(String consumerId);
	
	public List<Consumer> addMultipleConsumers(List<ConsumerDto> dtos);
	
	public boolean consumerExists(String consumerId);
	
	//later add pagination concept to remove 3 list method

}
