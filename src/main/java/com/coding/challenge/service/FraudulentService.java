package com.coding.challenge.service;


import com.coding.challenge.api.ValidationException;
import com.coding.challenge.dto.ValidateCreditCardTransactionRequest;
import com.coding.challenge.dto.ValidateCreditCardTransactionResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface FraudulentService.
 */
public interface FraudulentService 
{
	
	/**
	 * Validate transactions.
	 *
	 * @param request the request
	 * @return the validate credit card transaction response
	 * @throws ValidationException the validation exception
	 */
	ValidateCreditCardTransactionResponse validateTransactions(ValidateCreditCardTransactionRequest request) throws ValidationException;

}
