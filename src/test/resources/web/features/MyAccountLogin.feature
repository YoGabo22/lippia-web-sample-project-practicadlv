Feature: MyAccountLogin

  Background:
    Given The client is in the Home Page
    And The client is in 'My Account' Menu

  @LoginError
  Scenario Outline: LoginError
    When The client enters '<emails>' in the email textbox
    And The client enters '<passwords>' in the password textbox
    And The client click the Login button
    Then The registration must fail with a warning message '<message>'

    @InvalidEmail
    Examples:
      | emails                | passwords       | message                                                                                                                                   |
      | pruebaperez@gmail     | passwordsegura3 | Error: The username pruebaperez@gmail is not registered on this site. If you are unsure of your username, try your email address instead. |
      |                       | passwordsegura3 | Error: Username is required.                                                                                                              |
      | gaboacademy@gmail.com |                 | Error: Password is required.                                                                                                              |


  @Login
  Scenario: LoginOk
    When The client enters 'gaboacademy@gmail.com' in the email textbox
    And The client enters '!ClaveSegura2025' in the password textbox
    And The client click the Login button
    Then Go to Home Page button