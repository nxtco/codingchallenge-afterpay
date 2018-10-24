package com.coding.challenge.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonPropertyOrder
                ({    
                     "threshold",
                     "rejectReason"
                })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT) 
@JsonTypeName(value ="validateCreditCardTransactionReq")
public class ValidateCreditCardTransactionRequest 
{

	@JsonProperty("threshold")
	private Double 			threshold;
	
	@JsonProperty("creditCardTransactions")
	private List<String>  	creditCardTransactions;

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public List<String> getCreditCardTransactions() 
	{
		if(creditCardTransactions == null)
		{
			creditCardTransactions = new ArrayList<String>();
		}
		return creditCardTransactions;
	}

	public void setCreditCardTransactions(List<String> creditCardTransactions) {
		this.creditCardTransactions = creditCardTransactions;
	}
}
