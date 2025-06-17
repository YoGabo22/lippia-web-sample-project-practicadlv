@tpFinal
Feature: MyAccount

  Background:
    Given The client is in the Home Page
    And The client is in 'My Account' Menu

  @AccountDetails
  Scenario: My Accounts-Account Details
    When The client enters 'gaboacademy@gmail.com' in the email textbox
    And The client enters '!ClaveSegura2025' in the password textbox
    And The client click the Login button
    And The client click the Account Details button
    Then The client is in Account Details page

  @AccountLogOut
  Scenario: My Accounts-Log-Out
    When The client enters 'gaboacademy@gmail.com' in the email textbox
    And The client enters '!ClaveSegura2025' in the password textbox
    And The client click the Login button
    And The client click the Logout button
    And The client is in 'My Account' Menu
    Then The email textbox is clickable