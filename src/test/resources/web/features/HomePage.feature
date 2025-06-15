Feature: HomePage

  Background:
    Given The client is in the Home Page

  @HomePageThreeSliders @TP4
    #Caso 1
  Scenario: Home Page with three Sliders only
    When The client tap on Shop menu button
    And The client tap on Home menu button
    Then The client view the Home Page has '3' Sliders only


  @HomePageThreeArrivals @TP4
    #Caso 2
  Scenario: Home Page with '3' Arrivals only
    When The client tap on Shop menu button
    And The client tap on Home menu button
    Then The client view the Home Page has '3' Arrivals only

  @AddBooksToBasket  @TP4
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

  @tpFinal


    @ArrivalsAddBasketCheckoutGateway
  Scenario Outline: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
    When The client click in the image <BookName> in the Arrivals
    And The client click the Add to Basket button
    And The client click on View Basket button
      #Este paso sería el 12 de la lista, solo que no estaba bien especificado el "item link"
    #En el siguiente step, que sería el 14 de la lista, en la lista está mal redactado, indica que Total debe ser siempre más chico que SubTotal, porque
    #se agregan impuestos, y es justamente al revés. Al agregarle impuestos al SubTotal, Total es más grande.
    And Subtotal is Lower than Total because Taxes
    And The client click the Proceed to Checkout button
    And The client fill his details in billing details form
    And select the <payment> method
    Then The coupon textbox is clickable


    Examples:
      | BookName      | payment                 |
      | Selenium Ruby | Direct Bank Transfer    |
      | Selenium Ruby | Check Payments          |
      | Selenium Ruby | Cash on Delivery        |
      | Selenium Ruby | PayPal Express Checkout |

    Examples:
      | BookName             | payment                 |
      | Thinking in HTML     | Direct Bank Transfer    |
      | Thinking in HTML     | Check Payments          |
      | Thinking in HTML     | Cash on Delivery        |
      | Thinking in HTML     | PayPal Express Checkout |
      | Mastering JavaScript | Direct Bank Transfer    |
      | Mastering JavaScript | Check Payments          |
      | Mastering JavaScript | Cash on Delivery        |
      | Mastering JavaScript | PayPal Express Checkout |

  @ArrivalsAddBasketCheckoutGatewayPlaceOrder
  Scenario Outline: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    When The client click in the image <BookName> in the Arrivals
    And The client click the Add to Basket button
    And The client click on View Basket button
      #Este paso sería el 12 de la lista, solo que no estaba bien especificado el "item link"
    #En el siguiente step, que sería el 14 de la lista, en la lista está mal redactado, indica que Total debe ser siempre más chico que SubTotal, porque
    #se agregan impuestos, y es justamente al revés. Al agregarle impuestos al SubTotal, Total es más grande.
    And Subtotal is Lower than Total because Taxes
    And The client click the Proceed to Checkout button
    And The client fill his details in billing details form
    And select the <payment> method
    And The coupon textbox is clickable
    And The client click the Place Order button
    Then The client is in the Order Received page

    Examples:
      | BookName      | payment                 |
      | Selenium Ruby | Direct Bank Transfer    |
      | Selenium Ruby | Check Payments          |
      | Selenium Ruby | Cash on Delivery        |
      | Selenium Ruby | PayPal Express Checkout |

    Examples:
      | BookName             | payment                 |
      | Thinking in HTML     | Direct Bank Transfer    |
      | Thinking in HTML     | Check Payments          |
      | Thinking in HTML     | Cash on Delivery        |
      | Thinking in HTML     | PayPal Express Checkout |
      | Mastering JavaScript | Direct Bank Transfer    |
      | Mastering JavaScript | Check Payments          |
      | Mastering JavaScript | Cash on Delivery        |
      | Mastering JavaScript | PayPal Express Checkout |
    #Metodo de pago PayPal no funciona, algo esperable de una página que simula una compra como tal

