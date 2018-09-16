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

Feature: Calls a contact

  Scenario: Video Call a contact
    Given enter the application
    When enter to menu calls
    And click button with symbol phone+
    And click button with symbol magnifying glass 
    And search contact with talk 
    |mother| 
    And click button camera
    Then talk with contact


  Scenario Outline: call a contact
    Given enter the application
    When enter to menu calls
    And click button with symbol phone+
    And click button with symbol magnifying glass  
    And search <contact> with talk           
    Then talk with contact

    Examples: 
      | contact  | 
      | brother  |  
