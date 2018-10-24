package com.coding.challenge.domain;
import static com.coding.challenge.TestDataObjectMother.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CreditTransactionTest 
{
	@Test
	public void shouldReturnTrueIfCreditCardTransactionIsMeaningfullyEqual()
	{
		CreditCardTransaction  creditCardTransaction    = getCreditCardTransaction();
		CreditCardTransaction  creditCardTransactionTwo = getCreditCardTransaction();
		boolean 			   isEqual 			        = creditCardTransaction.equals(creditCardTransactionTwo);
		Assertions.assertThat(isEqual).isTrue();
	}
	
	
	@Test
	public void shouldReturnFalseIfCreditCardTransactionIsMeaningfullyEqual()
	{
		CreditCardTransaction  creditCardTransaction    = getCreditCardTransaction();
		CreditCardTransaction  creditCardTransactionTwo = getCreditCardTransactionObjTwo();
		boolean 			   isEqual                  = creditCardTransaction.equals(creditCardTransactionTwo);
		Assertions.assertThat(isEqual).isFalse();
	}
	
	@Test
	public void shouldReturnTheSamehashCodeForEqualObjects()
	{
		CreditCardTransaction  creditCardTransaction    = getCreditCardTransaction();
		
		String hashedCreditCardNumber = "10d7ce2f43e35fa57d1bbf8b1e4";
		String timestamp              = "2014-04-29T13:15:54";
    		Double price				       = 10.0;
    	
		CreditCardTransaction  creditCardTransactionTwo =  new CreditCardTransaction(hashedCreditCardNumber,timestamp,price);
		Assertions.assertThat(creditCardTransaction.hashCode()).isEqualTo(creditCardTransactionTwo.hashCode());
	}
	

}
