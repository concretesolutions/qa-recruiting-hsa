#Author: malave.luis.89@gmail.com
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

Feature: add status

  Scenario: add a state by the front camera
    Given enter the application
    When enter to menu status
    And click button to add status
    And select front camera
    And click button take picture
    And visualize picture
    And add message to state
    |is a good selfie for whatsapp|
    Then upload status

  Scenario Outline: add a state in text
    Given enter the application
    When enter to menu status
    And click button pencil
    And write a <text> to visualize
    And select a <color> for my text
    And click button send
    And add message to state
    Then upload status
 
 	Examples:
 		|text            |color|
 		|my status writte|black|

 		
 		