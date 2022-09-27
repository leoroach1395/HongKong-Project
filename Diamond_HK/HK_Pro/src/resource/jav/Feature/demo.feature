Feature: verify the overall functionality of the application

Background: user login with correct credentials
Given user enter the 'https://staging.dicqinfotech.com/en/'
And user should see the page title as 'Diamond ICQ - Sell Your Jewellery - new'
When user click on the signin button
And user enters username 'cristianoronaldocr7506@gmail.com' 
And user enters password 'Cristiano07'
And user click the login button

Scenario: verify the BuyDiamonds module funtionality
Given user should see the page title as 'Diamond ICQ - Sell Your Jewellery - new'
And user enters the buy diamonds module
And user should see the page title as 'Buy Diamonds And Jewelry Online At Best Price - Hong Kong '
When user choose and click the shape 
And user view the choosed product using by click and Navigates to Buy diamond 
And user click buy diamond and Navigates to Shopping cart
And user update the cart by using click
And user click the Proceed to checkout and it Navigates to Shipping Address
And User Enter the first Name 'cristiano'
And User Enter the Last Name 'ronaldo'
And User Enter the First address 'Nem Nagar, Pandesara'
And User Enter the Second address 'Udhna'
And User Enter the city 'surat'
And User Select the country 
And User Enter the state 'Gujarat'
And User Enter the Postalcode '335009'
And User Select the country and Enter the contact num '9282364991'


