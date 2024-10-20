package com.vw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="c0")
public class Consumer {
	
	@Id
	private String consumerId;
	private String consumerName;
	private String consumerType;
	
	public Consumer() {	}

	public Consumer(String consumerId, String consumerName, String consumerType) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.consumerType = consumerType;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerType() {
		return consumerType;
	}

	public void setConsumerType(String consumerType) {
		this.consumerType = consumerType;
	}
	
}
