package com.coding.challenge.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coding.challenge.dto.ValidateCreditCardTransactionRequest;
import com.coding.challenge.dto.ValidateCreditCardTransactionResponse;
import com.coding.challenge.service.FraudulentService;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static com.coding.challenge.api.ApplicationConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = CREDITACARD_TRANSACTION, produces = APPLICATION_JSON_VALUE)
public class RestAPIController {


    private static Logger 	LOGGER = Logger.getLogger(RestAPIController.class);
    
    @Autowired
    private FraudulentService fraudulentService;
    
    /*
     *Will give the list of fradulant transactions 
     * */
	@RequestMapping(value = CREDIT_CARD_TRANSACTION , method= RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
    public ValidateCreditCardTransactionResponse validateCreditCardTransaction(@Valid @RequestBody ValidateCreditCardTransactionRequest request)
    {
		ValidateCreditCardTransactionResponse response = new ValidateCreditCardTransactionResponse();;
	    try 
	    {
	    		response = fraudulentService.validateTransactions(request);
		} 
	    catch (ValidationException e) 
	    {
		    	LOGGER.info("Error in API "+e.getMessage());
		    	populateErrorResponse(response);
		}
	    return response;
    }
    
	/*
	 * Can be further enhanced to include an error message
	 * */
	private void populateErrorResponse(ValidateCreditCardTransactionResponse response)
	{
		response.setErrorMessage("Error in API ");
		response.setResponseStatus("Failure");
	}
    
	
	/*
	 * Only used to get the request and response 
	 * */
	@RequestMapping(value = "/retrieveValidateCreditCardTransactionRequest/{id}" , method= RequestMethod.GET)
	@ResponseBody
	public ValidateCreditCardTransactionRequest  retrieveValidateCreditCardTransactionRequest()
	{
		  ValidateCreditCardTransactionRequest request = new ValidateCreditCardTransactionRequest();
	      String transactionOne  	= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 10.00";
	      String transactionTwo  	= "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 6.00";
	      String transactionThree  	= "10d7ce2f43e35fa57d1bbf8b1e3, 2014-04-29T13:15:54, 17.00";
	      String transactionFour  	= "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54, 15.00";
	      List<String>  creditCardTransactionList = new ArrayList<String>();
	      
	      creditCardTransactionList.add(transactionOne);
	      creditCardTransactionList.add(transactionThree);
	      creditCardTransactionList.add(transactionTwo);
	      creditCardTransactionList.add(transactionFour);
	      
	      request.setCreditCardTransactions(creditCardTransactionList);
		  request.setThreshold(15.00);
	      
		return request;
	}
	
	
	
}
