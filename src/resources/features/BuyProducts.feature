Feature: buy products on the website

  Scenario Outline: check product purchase
    Given the <actor> access to the web site
    And <actor> login with valid <user> and <password>
    When <actor> adds <amount> products to the cart
    Then <actor> can view the <amount> products added to the shopping cart
    And <actor> fills out the purchase form <firstName> <lastName> <PostalCode>
    And <actor> can Checkout until confirmation <confirmationMessage>

    Examples:
      | actor | user            | password       | amount | firstName | lastName  | PostalCode | confirmationMessage         |
      | jhon  | "standard_user" | "secret_sauce" | 2      | "Josue "  | "Presley" | "05105"    | "Thank you for your order!" |