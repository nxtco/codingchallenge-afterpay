package com.coding.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.coding.challenge.api.ValidationException;
import com.coding.challenge.dto.ValidateCreditCardTransactionRequest;

import static com.coding.challenge.TestDataObjectMother.*;


public class FraudulentServiceTest 
{
	 private static Logger 	LOGGER = Logger.getLogger(FraudulentServiceTest.class);
	 
	 @InjectMocks
	 FraudulentService fraudulentService;// You can alternatively Autowire /even with other test engines 
	 
	 List<String>  creditCardTransactionList = new ArrayList<String>();
	 
	 @Before
	 public void setUp()
	 {
		  fraudulentService 		= new FraudulentServiceImpl();
	      MockitoAnnotations.initMocks(this);
	      
	      String transactionOne  	= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 10.00";
	      String transactionTwo  	= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 6.00";
	      String transactionThree  	= "10d7ce2f43e35fa57d1bbf8b1e3, 2014-04-29T13:15:54, 17.00";
	      String transactionFour  	= "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54, 15.00";
	      creditCardTransactionList.add(transactionOne);
	      creditCardTransactionList.add(transactionThree);
	      creditCardTransactionList.add(transactionTwo);
	      creditCardTransactionList.add(transactionFour);
	 }
	 
	 
	 @Test
	 public void shouldSuccessfullyReturnListOfFraudulentCreditCardTransactions()
	 {

		 ValidateCreditCardTransactionRequest request = getValidateCreditCardTransactionRequest();
		 
		 try 
		 {
			List<String> fraudulantCreditCardList = fraudulentService.validateTransactions(request).getFraudulantHashedCreditCardNumbers();
			Assertions.assertThat(fraudulantCreditCardList != null);
			Assertions.assertThat(fraudulantCreditCardList.size() == 2);
			
		 } catch (ValidationException e) 
		 {
			LOGGER.error("Error in validateTransactions Test method "+e.getMessage());
		 }
	 }
	 
	 @Test(expected = ValidationException.class)
	 public void shouldThrowAnExceptionForValidationErrors() throws  ValidationException
	 {
		 ValidateCreditCardTransactionRequest request 	= new ValidateCreditCardTransactionRequest();
		 // String with missing price
		 String 					invalidTransactionStr  	= "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54";
		 creditCardTransactionList.add(invalidTransactionStr);
		 request.setCreditCardTransactions(creditCardTransactionList);
		 request.setThreshold(15.00);
		 fraudulentService.validateTransactions(request);  
	 }
	 
	 

}
