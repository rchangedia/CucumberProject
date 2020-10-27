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

@PostJob
Feature: Posting a job using parameterization
  
  Scenario: Posting a job using parameterization
    Given Open browser with Alchemy Jobs site
    When User clicks on Post Job
    Then user enters "test79@hotmail.com","Selenium Tester","Tester","test387@IBM.com","IBM" and click on Preview button
    Then user clicks on Submit button
    Then Go to the Jobs site
    And Confirm job listing "Selenium Tester" is shown on page
    
