@ProductSelection
Feature: Product feature
  Description: This feature will be used to login the Swag lab

  Background: 
    Given User is on the Swag Lab application
    When User enters "standard_user" and "secret_sauce"
    And User clicks on the login button
    Then User should be able to see the homepage

  Scenario Outline: Verify that user is able to add the single product to the cart
    Given User is on the homepage
    When User selects the "<Product>"
    And Click on the Add to cart button
    Then Product added successfully to the cart

    Examples: 
      | Product                 |
      | Sauce Labs Bolt T-Shirt |

  @DataTable
  Scenario: Verify that user is able to add multiple products to the cart using datatable
    Given User is on the homepage
    When User selects the product
      | Field    | Value                    |
      | Product1 | Sauce Labs Backpack      |
      | Product2 | Sauce Labs Bike Light    |
      | Product3 | Sauce Labs Fleece Jacket |
    And Click on the Add to cart button
    Then Product added successfully to the cart
