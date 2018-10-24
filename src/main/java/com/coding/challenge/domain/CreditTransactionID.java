package com.coding.challenge.domain;

public class CreditTransactionID 
{
	
	final  String creditCardNumber ;
	
	final   String timeStamp;
	

	public CreditTransactionID(String creditCardNumber, String timeStamp) 
	{
		super();
		this.creditCardNumber = creditCardNumber;
		this.timeStamp = timeStamp;
	}

	public String getCreditCardNumber() 
	{
		return creditCardNumber;
	}

	public String getTimeStamp() 
	{
		return timeStamp;
	}
	
	@Override
    public boolean equals(Object o) 
	{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditTransactionID that = (CreditTransactionID) o;

        if (!creditCardNumber.equals(that.creditCardNumber)) return false;
        if (!timeStamp.equals(that.timeStamp)) return false;

        return true;
    }

    @Override
    public int hashCode() 
    {
        int result = creditCardNumber.hashCode();
        result = 31 * result + timeStamp.hashCode();
        return result;
    }


}
