package com.coding.challenge.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonPropertyOrder
                ({    
                     "errorMessage",
                     "responseStatus",
                     "fraudulantHashedCreditCardNumbers"
                })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT) 
@JsonTypeName(value ="validateCreditCardTransactionRes")
public class ValidateCreditCardTransactionResponse 
{

	private String 			errorMessage;
	
	private String 			responseStatus;
	
	private List<String> 	fraudulantHashedCreditCardNumbers;
	
	
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public List<String> getFraudulantHashedCreditCardNumbers() {
		return fraudulantHashedCreditCardNumbers;
	}

	public void setFraudulantHashedCreditCardNumbers(List<String> fraudulantHashedCreditCardNumbers) {
		this.fraudulantHashedCreditCardNumbers = fraudulantHashedCreditCardNumbers;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
