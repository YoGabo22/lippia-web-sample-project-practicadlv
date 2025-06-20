@TPFinal @MyAccountRegistration
Feature: MyAccountRegistration

  Background:
    Given The client is in the Home Page
    And The client is in 'My Account' Menu

  @RegistrationError
  Scenario Outline: Registration with empty Email or password
    When The client enters '<emails>' in the register email textbox
    And The client enters '<passwords>' in the register password textbox
    And The client click the Login button
    Then The registration must fail with a warning message '<message>'


    Examples:
      | emails                | passwords | message                                      |
      | pruebaperez@gmail.com |           | Error: Please enter an account password.     |
      |                       |           | Error: Please provide a valid email address. |

