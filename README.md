# Transaction Isolation level 

### SpringBoot 

In this example, we have a database table called "Invoices" and a REST endpoint at localhost:port/invoices. Multiple requests may concurrently send the same data to this endpoint/table using a POST request. To handle this, we use a method that checks for a record with a unique identifier (UUID) in the database. If a record is found, we update it. Otherwise, we create a new record and save it.

However, without a strong isolation level, duplicate records may be inserted into the table. To prevent this, we use a transaction isolation level to ensure that only one transaction can access the table at a time, thus avoiding any conflicts that could result in redundant data being inserted.


### Libraries
* Spring boot framework
* Spring boot JPA
* Spring boot web
* lombok
* postgresql as database

### Sample Curl request 
curl.exe -XPOST -H "Content-Type: application/json" -d '{"uuid": "b8850aa4-ff08-4598-b5e2-0a68f8d7ac91", "amount":100}' http://localhost:9009/invoices

