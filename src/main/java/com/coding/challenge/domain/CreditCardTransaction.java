package com.coding.challenge.domain;

public class CreditCardTransaction
{

	final CreditTransactionID creditCardTransactionId;
	
	final Double amount;

	
	public CreditCardTransaction(String creditCardNumber,String timeStamp, Double amount)
	{
		this.creditCardTransactionId = new CreditTransactionID(creditCardNumber, timeStamp);
		this.amount = amount;
	}


	public CreditTransactionID getCreditCardTransactionId() {
		return creditCardTransactionId;
	}


	public Double getAmount() {
		return amount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((creditCardTransactionId == null) ? 0 : creditCardTransactionId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) 
	 {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardTransaction other = (CreditCardTransaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (creditCardTransactionId == null) {
			if (other.creditCardTransactionId != null)
				return false;
		} else if (!creditCardTransactionId.equals(other.creditCardTransactionId))
			return false;
		return true;
	}
	
	

	
}
