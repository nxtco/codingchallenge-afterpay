package com.coding.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.coding.challenge.api.ApplicationConstants;
import com.coding.challenge.api.ValidationException;
import com.coding.challenge.domain.CreditCardTransaction;
import com.coding.challenge.domain.CreditTransactionID;
import com.coding.challenge.dto.ValidateCreditCardTransactionRequest;
import com.coding.challenge.dto.ValidateCreditCardTransactionResponse;

@Service("fraudulentService")
public class FraudulentServiceImpl implements FraudulentService
{
	
	 private static String REGEX = ",";

	 private static Logger 	LOGGER = Logger.getLogger(FraudulentServiceImpl.class);
	
	@Override
	public ValidateCreditCardTransactionResponse validateTransactions(ValidateCreditCardTransactionRequest request) throws ValidationException
	{
		ValidateCreditCardTransactionResponse 	response 					     = new ValidateCreditCardTransactionResponse();
		try
		{
			Double 								threshold					     = request.getThreshold();
			List<CreditCardTransaction> 			creditCardTransactionList        = populateCreditCardTransaction(request.getCreditCardTransactions());
			
		    Map<CreditTransactionID, Double> 	map 				= creditCardTransactionList.stream()
			    		 												.collect(Collectors.groupingBy(CreditCardTransaction::getCreditCardTransactionId,
			    		 												 Collectors.summingDouble(CreditCardTransaction::getAmount)));
		    List<String>   fraudulantHashedCreditCardNumbers   	= new ArrayList<String>();
		    map.keySet().forEach(e -> 
		    						{
		    							if(map.get(e) > threshold)
		    							{
		    								fraudulantHashedCreditCardNumbers.add(e.getCreditCardNumber());
		    							}
		    						});
		    
	
		    response.setFraudulantHashedCreditCardNumbers(fraudulantHashedCreditCardNumbers);
		    response.setErrorMessage(null);
		    response.setResponseStatus(ApplicationConstants.SUCCESS);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in validateTransactions "+e.getMessage());
			throw new ValidationException(e);
		}
		return response;
	}
	
	
	
	private List<CreditCardTransaction>  populateCreditCardTransaction(List<String> transactionList) throws ValidationException
	{
		List<CreditCardTransaction> creditCardTransactionList 	= new ArrayList<>();

		ToDoubleFunction<String> 	convertPrice  				= (str)-> Double.parseDouble(str.trim());
		
		Function<String,String> 	trimFunction 				= (i)-> i.trim();
		for(String e :transactionList)
		{
			String[] split = e.split(REGEX);
			if(split == null || split.length != 3)
			{
				LOGGER.error(" Invalid Transaction String");
				throw new ValidationException("Invalid Transaction String");
			}
			creditCardTransactionList.add(
								new CreditCardTransaction(trimFunction.apply(split[0]), trimFunction.apply(split[1]), 
														  convertPrice.applyAsDouble(split[2])));
			
		};

		return creditCardTransactionList;
	}

}
