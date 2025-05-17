Feature: HomePage

  Background:
    Given The client is in the Home Page

  @HomePageThreeSliders
    #Caso 1
  Scenario: Home Page with three Sliders only
    When The client tap on Shop menu button
    And The client tap on Home menu button
    Then The client view the Home Page has '3' Sliders only


  @HomePageThreeArrivals
    #Caso 2
  Scenario: Home Page with '3' Arrivals only
    When The client tap on Shop menu button
    And The client tap on Home menu button
    Then The client view the Home Page has '3' Arrivals only

  @AddBooksToBasket @Smoke @Do
    #Caso 12
  Scenario Outline: AddBookstoBasket
    When The client click in the image <BookName> in the Arrivals
    And The client click the Add to Basket button
    And The client click on View Basket button
      #Este paso sería el 12 de la lista, solo que no estaba bien especificado el "item link"
    And The client increments Quantity value to '<BooksQuantity>'
    And The client click on Update Basket to reflect changes
    Then The Quantity change to '<BooksQuantity>' value



    Examples:
      | BookName      | BooksQuantity |
      | Selenium Ruby | 4             |

    Examples:
      | BookName             | BooksQuantity |
      | Thinking in HTML     | 4             |
      | Mastering JavaScript | 4             |





