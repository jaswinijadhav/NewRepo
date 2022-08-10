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

@tag
Feature: Adding User
Scenario: Add User Record
    Given I set POST user service api endpoint
    When send a POST HTTP request
    Then I receive valid Response

   
Scenario Outline: invalid user data
     Given I set POST user api endpoint <name> <age> <phone>
     When fill name field with  and fill age field with and phone field with 
     Then I should not able to see data
 Examples:
   |name  | age       |phone       |
   |  ""  |  "20"     |  "35667"   |

        
    
