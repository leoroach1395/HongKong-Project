Feature: verify the overall functionality of the application

Background: user login with correct credentials
Given user enter the 'https://staging.dicqinfotech.com/en/'
And user should see the page title as 'Diamond ICQ - Sell Your Jewellery - new'

Scenario: verify the BuyDiamonds module funtionality
Given user enters the buy diamonds module
Then user view the choosed product using by click and Navigates to Buy diamond 
Then user click buy diamond and Navigates to Shopping cart
Then user click the Proceed to checkout and it Navigates to Shipping Address
When User Enter the first Name 'cristiano'
When User Enter the Last Name 'ronaldo'
And User Enter the First address 'Nem Nagar, Pandesara'
And User Enter the Second address 'Udhna'
And User Enter the city 'surat'
And User Select the country 
And User Enter the state 'Gujarat'
And User Enter the Postalcode '335009'
Then User Select the country and Enter the contact num '9282364991'


