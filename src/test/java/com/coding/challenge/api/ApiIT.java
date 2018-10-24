package com.coding.challenge.api;

import com.coding.challenge.BaseIntegrationTest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.coding.challenge.TestDataObjectMother.*;
import static com.coding.challenge.api.ApplicationConstants.*;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiIT extends BaseIntegrationTest {


   
    @Test
    public void shouldReturnListOfFraudulantCreditCardTransactionForGivenThreshold() 
    {

        RestAssured
                .given()
                    .port(port)
                    .contentType(JSON)
                    .header(getValidAuthHeader())
                    .body(getValidateCreditCardTransactionRequest())
                .when()
                    .post(CREDITACARD_TRANSACTION+CREDIT_CARD_TRANSACTION)
                .then()
                    .statusCode(SC_OK)
                    .body("validateCreditCardTransactionRes.responseStatus", equalTo("Success"))
                    .body("validateCreditCardTransactionRes.fraudulantHashedCreditCardNumbers.size()", equalTo(2));
    }
    
    
    @Test
    public void shouldHaveAndErrorMessageForInvalidTransaction()
    {
    	 RestAssured.defaultParser = Parser.JSON; 
    	 RestAssured
         .given()
             .port(port)
             .contentType(JSON)
             .header(getValidAuthHeader())
             .body(getInvalidValidateCreditCardTransactionRequest())
         .when()
             .post(CREDITACARD_TRANSACTION+CREDIT_CARD_TRANSACTION)
         .then()
             .statusCode(SC_OK)
             .body("validateCreditCardTransactionRes.responseStatus", equalTo(ApplicationConstants.FAILURE));
    }
    
    
    @Test
    public void shouldThrowAnAPIErroWhenHeadeValuesAreNotPresented()
    {
    	 RestAssured
         .given()
             .port(port)
             .contentType(JSON)
             .body(getValidateCreditCardTransactionRequest())
         .when()
             .post(CREDITACARD_TRANSACTION+CREDIT_CARD_TRANSACTION)
         .then()
             .statusCode(SC_FORBIDDEN);
    }
    
    
    
	

}
