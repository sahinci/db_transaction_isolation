# Transaction Isolation level 

### SpringBoot 

With this example we have a table in database as Invoices
We have a rest endpoint as localhost:port/invoices
Multiple concurrent request sending a same post data as request to the endpoint/table.
There is a method check by uuid , if there is a record found just update it.
If there is no record then create a new one and save it.
If there is not strong isolation level redundant/duplicate records inserting to table.
With transaction isolation level we are avoiding that case.


### Libraries
* Spring boot framework
* Spring boot JPA
* Spring boot web
* lombok
* postgresql as database

### Sample Curl request 
curl.exe -XPOST -H "Content-Type: application/json" -d '{"uuid": "b8850aa4-ff08-4598-b5e2-0a68f8d7ac91", "amount":100}' http://localhost:9009/invoices

