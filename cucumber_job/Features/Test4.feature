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

 
    Feature: Using Examples table to post a job
  @PostJob1
  Scenario Outline: Posting a job using Examples table
    Given Open browser with Alchemy Jobs site
    When User clicks on Post Job
    Then user enters "<email>","<jobTitle>","<description>","<ApplnEmail>","<companyName>" and click on Preview button
    Then user clicks on Submit button
    Then Go to the Jobs site
    And Confirm job listing "<jobTitle1>" is shown on page
    

    Examples: 
      | email  | jobTitle | description  | ApplnEmail | companyName | jobTitle1 |
      | teste790@hotmail.com | BDD1 tester | BDD | test15@ibm.com | IBM | BDD tester |
      | teste789@hotmail.com | UFT tester | UFT | test13@ibm.com | IBM | UFT tester |
      | test567@hotmail.com | tosca tester | BDD | test14@ibm.com | IBM | tosca tester |
    
    