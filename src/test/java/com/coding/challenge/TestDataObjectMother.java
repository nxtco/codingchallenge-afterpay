package com.coding.challenge;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.domain.CreditCardTransaction;
import com.coding.challenge.dto.ValidateCreditCardTransactionRequest;

public class TestDataObjectMother {


    
	private static String TRANSACTION_ONE 			= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 10.00";
	private static String TRANSACTION_TWO 			= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 6.00";
	private static String TRANSACTION_THREE 			= "10d7ce2f43e35fa57d1bbf8b1e3, 2014-04-29T13:15:54, 17.00";
	private static String TRANSACTION_FOUR 			= "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54, 15.00";
    private static String TRANSACTION_FIVE 			= "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54";
    private static Double THRESHOLD					= 15.0;
    private static Double THRESHOLD_TWO				= 15.0;
    private static Double THRESHOLD_THREE			= 10.0;
    private static String HASHED_CREDIT_CARD_ONE 	= "10d7ce2f43e35fa57d1bbf8b1e4";
    private static String HASHED_CREDIT_CARD_TWO 	= "10d7ce2f43e35fa57d1bbf8b1e5";
    private static String TIMESTAMP         		 	= "2014-04-29T13:15:54";
  
    
    public static ValidateCreditCardTransactionRequest getValidateCreditCardTransactionRequest()
    {
    		  ValidateCreditCardTransactionRequest  request = new ValidateCreditCardTransactionRequest();
	
		      List<String> creditCardTransactionList = new ArrayList<String>();
		      creditCardTransactionList.add(TRANSACTION_ONE);
		      creditCardTransactionList.add(TRANSACTION_TWO);
		      creditCardTransactionList.add(TRANSACTION_THREE);
		      creditCardTransactionList.add(TRANSACTION_FOUR);
		      
		      request.setCreditCardTransactions(creditCardTransactionList);
		      request.setThreshold(THRESHOLD);
	    
	    	  return request;
    	
    }
    
    public static ValidateCreditCardTransactionRequest getInvalidValidateCreditCardTransactionRequest()
    {
    		  ValidateCreditCardTransactionRequest request = getValidateCreditCardTransactionRequest();
    		  request.getCreditCardTransactions().add(TRANSACTION_FIVE);
	    	  return request;
    	
    }
    
    
    
    public static CreditCardTransaction getCreditCardTransaction()
    {
	    	CreditCardTransaction creditCardTransaction= new CreditCardTransaction(HASHED_CREDIT_CARD_ONE,TIMESTAMP,THRESHOLD_THREE);
	    	return creditCardTransaction;
    }
    
    public static CreditCardTransaction getCreditCardTransactionObjTwo()
    {
	    	CreditCardTransaction creditCardTransaction= new CreditCardTransaction(HASHED_CREDIT_CARD_TWO,TIMESTAMP,THRESHOLD_TWO);
	    	return creditCardTransaction;
    	
    }
    
   
  
}

