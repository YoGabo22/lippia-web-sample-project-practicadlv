@Shop
Feature: Shop

  Background:
    Given The client is in the Home Page
    And The client is in Shop Menu

  @ShopCategories @TP4
  Scenario Outline: ShopProductCategories
    When The client click on '<category>' button
    Then The client is in the '<category>' Page
    Examples:
      | category   |
      | Android    |
      | HTML       |
      | JavaScript |
      | selenium   |

  @ShopSorting @TP4
  Scenario Outline: Sorting
    When The client click on sorting '<SortCategory>' button
    Then The client see the Shop Page sorting by '<SortCategory>'
    Examples:
      | SortCategory               |
      | Sort by popularity         |
      | Sort by average rating     |
      | Sort by newness            |
      | Sort by price: low to high |
      | Sort by price: high to low |


  @tpFinal
    @ShopBasketReceived
  Scenario Outline: Shop-Add to Basket-View Basket through Item link
    When The client click the Add to Basket button of <BookName> in Shop Page
    And The client click on Basket button in Shop Page
      #Este paso sería el 6 de la lista, solo que no estaba bien especificado el "item link"
    #En el siguiente step, que sería el 14 de la lista, en la lista está mal redactado, indica que Total debe ser siempre más chico que SubTotal, porque
    #se agregan impuestos, y es justamente al revés. Al agregarle impuestos al SubTotal, Total es más grande.
    And Subtotal is Lower than Total because Taxes
    And The client click the Proceed to Checkout button
    And The client fill his details in billing details form
    And select the <payment> method
    And The client click the Place Order button
    Then The client is in the Order Received page


    Examples:
      | BookName                  | payment              |
      | Android Quick Start Guide | Direct Bank Transfer |
      | Android Quick Start Guide | Check Payments       |
      | Android Quick Start Guide | Cash on Delivery     |

    Examples:
      | BookName                         | payment                 |
      | Functional Programming in JS     | Direct Bank Transfer    |
      | Functional Programming in JS     | Check Payments          |
      | Functional Programming in JS     | Cash on Delivery        |
      | HTML5 Forms                      | Direct Bank Transfer    |
      | HTML5 Forms                      | Check Payments          |
      | HTML5 Forms                      | Cash on Delivery        |
      | HTML5 WebApp Develpment          | Direct Bank Transfer    |
      | HTML5 WebApp Develpment          | Check Payments          |
      | HTML5 WebApp Develpment          | Cash on Delivery        |
      | Selenium Ruby                    | Direct Bank Transfer    |
      | Selenium Ruby                    | Check Payments          |
      | Selenium Ruby                    | Cash on Delivery        |
      | Mastering JavaScript             | Direct Bank Transfer    |
      | Mastering JavaScript             | Check Payments          |
      | Mastering JavaScript             | Cash on Delivery        |
      | JS Data Structures and Algorithm | Direct Bank Transfer    |
      | JS Data Structures and Algorithm | Check Payments          |
      | JS Data Structures and Algorithm | Cash on Delivery        |
      | Thinking in HTML                 | Direct Bank Transfer    |
      | Thinking in HTML                 | Check Payments          |
      | Thinking in HTML                 | Cash on Delivery        |
      | Thinking in HTML                 | PayPal Express Checkout |

     #PayPal siempre falla, porque no existe una conección real para un cobro real
    Examples:
      | BookName                         | payment                 |
      | Android Quick Start Guide        | PayPal Express Checkout |
      | Functional Programming in JS     | PayPal Express Checkout |
      | HTML5 Forms                      | PayPal Express Checkout |
      | HTML5 WebApp Develpment          | PayPal Express Checkout |
      | Selenium Ruby                    | PayPal Express Checkout |
      | Mastering JavaScript             | PayPal Express Checkout |
      | JS Data Structures and Algorithm | PayPal Express Checkout |


  @ShopBasketCheckTaxes
  Scenario Outline: Shop-Add to Basket-View Basket-Tax Functionality
    When The client click the Add to Basket button of <BookName> in Shop Page
    And The client click on Basket button in Shop Page
      #Este paso sería el 6 de la lista, solo que no estaba bien especificado el "item link"
    #En el siguiente step, que sería el 14 de la lista, en la lista está mal redactado, indica que Total debe ser siempre más chico que SubTotal, porque
    #se agregan impuestos, y es justamente al revés. Al agregarle impuestos al SubTotal, Total es más grande.
    And Subtotal is Lower than Total because Taxes
    And The client click the Proceed to Checkout button
    And The client fill his details in billing details form
    And Check taxes value
    And The client select Argentina country
    Then The client check the taxes are lower in India


    @Do
    Examples:
      | BookName                  |
      | Android Quick Start Guide |

    Examples:
      | BookName                         |
      | Functional Programming in JS     |
      | HTML5 Forms                      |
      | HTML5 WebApp Develpment          |
      | Selenium Ruby                    |
      | Mastering JavaScript             |
      | JS Data Structures and Algorithm |
      | Thinking in HTML                 |
