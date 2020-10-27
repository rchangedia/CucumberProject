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
@Schedule_meeting
Feature: Schedule a meeting and invite members

Scenario Outline: To schedule a meeting and include at least 3 invitees
    Given Open the browser to the ​Alchemy CRM​ site and login with the credentials provided
    Then Navigate to Activities -> Meetings -> Schedule a Meeting
    And Enter the details of the meeting "<meetingSubject>"
    And Search for members and add them to the meeting "<member_1>", "<member_2>", "<member_3>"
    And Click Save
    And Navigate to View Meetings page and confirm creation of the meeting "<meetingSubject>"
    And Close the Browser
    
Examples: 
      | meetingSubject | member_1 | member_2 | member_3 |
      | Meeting_001 | invitees_add_1 | invitees_add_2 | invitees_add_3 |