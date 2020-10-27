#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Create_Product
Feature: Creating a Product

Scenario Outline: To use an Examples table to add products
    Given Open the browser to the ​Alchemy CRM​ site and login with the credentials
    Then Navigate to All -> Products-> Create Product
    And Enter the details of the product "<productName>"
    And Click Save button
    And Go to the View Products page to see all products listed "<productName>"
    And Close browser
    
Examples: 
      | productName |
      | Product 1 |