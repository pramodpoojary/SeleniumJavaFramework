@tag
Feature: purchase the order from

  Background: 
    Given the user is on Ecommerce page

  @Regression
  Scenario Outline: Positive testing submitting order.
    Given the user logged in with <username> and <password>
    When I add product <productName>
    And Checkout <productName> and Submit the order
    Then Order gets placed

    Examples: 
      | username                | password  | productName     |
      | pramod@gmail.com        | Pramod123 | ZARA COAT 3     |
      | pramodpoojary@gmail.com | Pramod123 | ADIDAS ORIGINAL |
