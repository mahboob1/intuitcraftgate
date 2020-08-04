Clone the repository. Then from project root directory run : mvn spring-boot:run
This will start the rest service in localhost at 8080 and can be accesses by postman or curl.
Following post command in postman will create payment and purchase tables in H2 DB. It connects to and checks in Stripe gateway for validation of customer and account number prior to storing the information in DB. Payment is data regarding account and customer, so payment table checks if the account/customer already entered, if not then payment table is populated with the new account/customer. Purchase table updated for every order.
------------------------------
http://localhost:8080/payment/add    with post body:
{
        "customerId": 1257,
        "accountNumber": 112358,
    "firstName": "John",
    "lastName": "Gavin",
        "emailAddress": "john.gavin@cetor.com",
        "addressDto": {
            "street": "Wild Villa Rd",        
            "city": "WildPort",
            "province": "BC",
            "country": "Canada"
        },
        "purchaseDto": {
            "item": "item01",        
            "amount": "100"
        }

}

---------------------------
 and return will be order entered.
After adding the payment following two curl commands will show entered payments and orders in H2 Table respectively:
curl http://localhost:8080/payment/listpayment
curl http://localhost:8080/payment/listorder
