
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Positive testing submitting order.
  Given the user is on Ecommerce page
    When the user logged in with <username> and <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username                | password  | 
      | pramod@gmail.com        | Pramod1234 |

