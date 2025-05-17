Feature: Shop

  Background:
    Given The client is in the Home Page
    And The client is in Shop Menu

  @ShopCategories
  Scenario Outline: ShopProductCategories
    When The client click on '<category>' button
    Then The client is in the '<category>' Page
    Examples:
      | category   |
      | Android    |
      | HTML       |
      | JavaScript |
      | selenium   |

  @ShopSorting
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