# Credit Card Validation API

### How To Build and Run the API

Pre-requisites
--------------
JDK 1.8.x 

Technologies/ Libraries used

    Java 8
    Spring boot
    Spring boot security
    Mockito
    AssertJ

#### How to run and deploy
Go to the project root directory and run following commands (using gradle wrapper)
###### To build the application
    ./gradlew build    or just gradle build (if gradle is installed)
    
###### To Run the application    
    ./gradlew bootRun or just gradle bootRun (if gradle is installed)


## Access the API
Please use one of the below tools to access the application 
  1. Postman either stand alone or Ext to chorome 
  2. SOAP UI 


=======================================================================
## API Information
The Credit Card  information API provides 

    1   Given a list of transaction and a threshold it would determine the fradulant transaction


## How to use the API (All requests should have the header key/value  API-KEY xJ9a34fo, and please select the media type to JSON. Please find the sample request from postman)
key 		:   API-KEY
Value   :   xJ9a34fo

# Validate Credit Card Transaction 
### validate Credit card transaction  url/Request Method POST  : http://localhost:8080/api/v0/creditCard/creditCardTransaction
### use the header values with the key API-KEY and value xJ9a34fo ( This can be further enhanced to authenticate the request using a CustomUserAuthenticationFilter instead of GenericFilterBean
### use the below request for both 

## Sample Request for validateCreditCardTransactionReq
{
    "validateCreditCardTransactionReq": {
        "threshold": 15,
        "creditCardTransactions": [
            "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 10.00",
            "10d7ce2f43e35fa57d1bbf8b1e3, 2014-04-29T13:15:54, 17.00",
            "10d7ce2f43e35fa57d1bbf8b1e1, 2014-04-29T13:15:54, 6.00",
            "10d7ce2f43e35fa57d1bbf8b1e4, 2014-04-29T13:15:54, 15.00"
        ]
    }
}
### Sample response 
		{
		    "validateCreditCardTransactionRes": {
		        "errorMessage": null,
		        "responseStatus": "Success",
		        "fraudulantHashedCreditCardNumbers": [
		            "10d7ce2f43e35fa57d1bbf8b1e1",
		            "10d7ce2f43e35fa57d1bbf8b1e3"
		        ]
		    }
		}


## Security Features     
####If you do not have a valid Auth Token, the API will return following error
        HTTP STATUS 403 
	  {
	    "timestamp": 1504014130145,
	    "status": 403,
	    "error": "Forbidden",
	    "message": "You are not authorised to access this function",
	    "path": "/api/v0/creditCard/creditCardTransaction"
	}
#Validations
## the transaction list should have all three values separated by the comma 
   
    
# Further enhancement and limitations 
## Include Spring AspectJ /AOP concepts  to intercept the request/response and log the request/response 
## Replace the in memory database with RDMS such as mysql, postgres
## Use JpaRepository or spring CrudRepository which will build the ORM support 

     
    
    