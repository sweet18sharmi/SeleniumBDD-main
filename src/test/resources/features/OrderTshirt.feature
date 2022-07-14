Feature: add and update product

  @order
  Scenario Outline: verify product added in cart page
    Given I am on homepage
    When I add products <Product1> <Product2> <Product3> <Product4>
    And I move to cart page
    Then I should see my products in cart
    When I search lowest priced product
    And I remove lowest priced product
    Then verify cart updated

    Examples: 
      | Product1                | Product2               |  Product3             | Product4     |
      | HOODIE-HAPPY-NINJA      | POSTER-FLYING-NINJA    |  T-SHIRT-HAPPY-NINJA  | T-SHIRT-PREMIUM-QUALITY        |


    