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
@CreateLeads
Feature: Create leads using parameterization

Scenario: Open the Leads page and add multiple lead accounts using values passed from Feature file
    Given Open the browser to the ​Alchemy CRM​ site and login with the given credentials
    Then Navigate to Sales -> Leads -> Create Lead
    And Fill in the "Sales_003", "Lead_003" details to create lead accounts using the values passed from the Feature file
    Then Click Save to finish
    And Navigate to the View Leads page to see results "Sales_003 Lead_003"
    And Close Browser