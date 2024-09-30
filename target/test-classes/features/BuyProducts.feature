Feature: Product purchase flow on SauceDemo

  Scenario: Buy two products and complete the purchase
    Given the user is on the SauceDemo homepage
    When the user logs in with the username standard_user and the password secret_sauce
    And the user adds the products
    |Sauce Labs Backpack|
    |Sauce Labs Bike Light|
    And the user views the cart and proceeds to checkout with the following data:
    | firstName | lastName  | postalCode  |
    |   Alex    |  Galvis   |   540005    |
    And the user completes the purchase
    Then the user should see the confirmation message Thank you for your order!