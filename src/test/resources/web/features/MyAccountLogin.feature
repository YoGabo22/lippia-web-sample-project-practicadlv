@MyAccountLogin
Feature: MyAccountLogin

  Background:
    Given The client is in the Home Page
    And The client is in 'My Account' Menu

  @LoginError @TP4
  Scenario Outline: LoginError
    When The client enters '<emails>' in the email textbox
    And The client enters '<passwords>' in the password textbox
    And The client click the Login button
    Then The Login must fail with a warning message '<message>'

    @InvalidEmail @TP4
    Examples:
      | emails                | passwords       | message                                                                                                                                   |
      | pruebaperez@gmail     | passwordsegura3 | Error: The username pruebaperez@gmail is not registered on this site. If you are unsure of your username, try your email address instead. |
      |                       | passwordsegura3 | Error: Username is required.                                                                                                              |
      | gaboacademy@gmail.com |                 | Error: Password is required.                                                                                                              |


  @Login @TP4
  Scenario: LoginOk
    When The client enters 'gaboacademy@gmail.com' in the email textbox
    And The client enters '!ClaveSegura2025' in the password textbox
    And The client click the Login button
    Then Go to Home Page button

  @tpFinal


  @LoginErrorCaseSensitive
  Scenario: Login-Handles case sensitive
    When The client enters 'GABOACADEMY@gmail.com' in the email textbox
    And The client enters '!CLAVESEGURA2025' in the password textbox
    And The client click the Login button
    Then The registration must fail with a warning message "Error: The password you entered for the username GABOACADEMY@gmail.com is incorrect. Lost your password?"


  @LoginAuthentication @Do
  Scenario: Login-Authentication
    When The client enters 'gaboacademy@gmail.com' in the email textbox
    And The client enters '!ClaveSegura2025' in the password textbox
    And The client click the Login button
    And The client click the Logout button
    And The client press Back button
    And The client is in 'My Account' Menu
    Then The email textbox is clickable
