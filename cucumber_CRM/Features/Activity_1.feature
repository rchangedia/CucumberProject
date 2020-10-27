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
@Count_Dashlets
Feature: Counting Dashlets

Scenario: Open the homepage and count the number of the dashlets on the page
    Given Open the browser to the ​Alchemy CRM​ site and login
    Then Count the number of Dashlets on the homepage
    And Print the number and title of each Dashlet into the console
    And Close the browser