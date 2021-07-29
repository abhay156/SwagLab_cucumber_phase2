@LoginFeature
Feature: Login feature
  Description: This feature will be used to login the Swag lab

  @PositiveLogin
  Scenario Outline: Verify Login Functionality with correct username and password
    Given User is on the Swag Lab application
    When User enters "<UserName>" and "<Password>"
    And User clicks on the login button
    Then User should be able to see the homepage

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  @NegativeLogin
  Scenario Outline: Verify the error message when we give incorrect username and password
    Given User is on the Swag Lab application
    When User enters incorrect "<IncorrectUserName>" and "<IncorrectPassword>"
    And User clicks on the login button
    Then User should be able to see the error "<Error>"

    Examples: 
      | IncorrectUserName | IncorrectPassword | Error                                                                     |
      | abhay123          | password@123      | Epic sadface: Username and password do not match any user in this service |
