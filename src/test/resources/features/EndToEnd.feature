Feature: Customer login and post-login validation

  Scenario: User creates a new account successfully
    Given the user navigates to the account creation page
    And the user is on the account creation page
    When the user enters valid account details
    Then the account should be created successfully

  Scenario: User searches products, manages cart, and completes checkout
    Given the user able to login
    When the user searches for a product
    And the user selects the baseball t-shirt product
    And the user selects the book
    And the user selects the shaving cream product
    And the user reload the page
    And the user click the Add to Cart Button
    And the user remove item from Cart
    Then the user able to Checkout the order


