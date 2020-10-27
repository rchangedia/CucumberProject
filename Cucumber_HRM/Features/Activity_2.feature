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
@AddCandidate
Feature: Adding a candidate for recruitment

Scenario: Add information about a candidate for recruitment
    Given Open the OrangeHRM​ page and login with the credentials provided
    When Navigate to the Recruitment page and click on the Add button to add candidate information
    Then On the next page, fill in the details of the candidate
    And Upload a resume docx or pdf to the form    
    And Click Save
		Then Navigate back to the Recruitments page to confirm candidate entry    
    And Close the Browser
