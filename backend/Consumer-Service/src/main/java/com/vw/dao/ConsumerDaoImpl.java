package com.vw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vw.exception.ConsumerNotFoundException;
import com.vw.model.Consumer;
import com.vw.model.ConsumerDto;
import com.vw.repository.ConsumerRepository;

@Component
public class ConsumerDaoImpl implements ConsumerDao {
	
	@Autowired
	private ConsumerRepository repo;

	@Override
	public Consumer addConsumer(ConsumerDto dto) {
		Consumer consumer = new Consumer();
		consumer.setConsumerId(dto.getConsumerId());
		consumer.setConsumerName(dto.getConsumerName());
		consumer.setConsumerType(dto.getConsumerType());
		repo.save(consumer);
		return consumer;
	}

	@Override
	public Consumer getSingleConsumer(String consumerId) {
		return repo.findById(consumerId).orElseThrow(()-> new ConsumerNotFoundException("consumer record for ID : "+consumerId+" not available"));
	}

	@Override
	public List<Consumer> getAllConsumers() {
		return repo.findAll();
	}

	@Override
	public List<Consumer> getAllIndividuals() {
		List<Consumer> individualConsumers = getAllConsumers()
				.stream()
//				.filter(p->p.getConsumerType().equals("Individual")) // here getConsumerType() can return null
				.filter(p->"Individual".equals(p.getConsumerType())) //it will avoid the NullPointerException
				.collect(Collectors.toList());
		return individualConsumers;
	}

	@Override
	public List<Consumer> getAllOrganizations() {
		List<Consumer> organizationConsumers = getAllConsumers()
				.stream()
//				.filter(p->p.getConsumerType().equals("Organization"))
				.filter(p->"Organization".equals(p.getConsumerType()))
				.collect(Collectors.toList());
		return organizationConsumers;
	}

	@Override
	public Consumer updateConsumer(String consumerId, ConsumerDto dto) {
		Consumer consumer = getSingleConsumer(consumerId);
		consumer.setConsumerName(dto.getConsumerName());
		consumer.setConsumerType(dto.getConsumerType());
		repo.save(consumer);
		return consumer;
	}

	@Override
	public String deleteConsumers(String consumerId) {
		Consumer consumer = getSingleConsumer(consumerId);
		repo.delete(consumer);
		return "record removed";
	}

	@Override
	public List<Consumer> addMultipleConsumers(List<ConsumerDto> dtos) {
		List<Consumer> consumersList = new ArrayList<>();
		
		for(ConsumerDto dto: dtos) {
			Consumer consumer = new Consumer();
			consumer.setConsumerId(dto.getConsumerId());
			consumer.setConsumerName(dto.getConsumerName());
			consumer.setConsumerType(dto.getConsumerType()); 	
			//remember, if there is multiple fields then use a custom method to set all.
			
			consumersList.add(consumer);
		}
		
		return repo.saveAll(consumersList);
	}

	@Override
	public boolean consumerExists(String consumerId) {
		return repo.existsById(consumerId);
	}

}
