package com.vw.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ConsumerDto {

	@NotBlank(message="ID cannot be left blank")
	private String consumerId;
	
	@NotBlank(message="Name cannot be left blank")
	private String consumerName;
	
	@NotBlank(message="Type cannot be left blank")
	@Pattern(regexp="^(Individual|Organization)$", message="Type can only be either 'Individual' or 'Organization'")
	private String consumerType;
	
	public ConsumerDto() {	}

	public ConsumerDto(String consumerId, String consumerName, String consumerType) {
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
