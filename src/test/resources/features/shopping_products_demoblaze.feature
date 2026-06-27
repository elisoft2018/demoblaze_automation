Feature: Purchase products in Demoblaze

  As a customer
  I want to purchase products from the online store
  So that I can complete my purchase successfully

  Background:
    Given the customer opens the Demoblaze home page

  @shoppingFlow
  Scenario: Complete an end-to-end purchase successfully

    When the customer adds the following products to the shopping cart
      | product            |
      | Samsung galaxy s6  |
      | Nokia lumia 1520   |

    And the customer opens the shopping cart

    Then the shopping cart should display the selected products

    When the customer places the order with the following information
      | field   | value         |
      | Name    | John Robles   |
      | Country | Colombia      |
      | City    | Bogotá        |
      | Card    | 123456789012  |
      | Month   | June          |
      | Year    | 2026          |

    And the customer confirms the purchase

    Then the purchase should be completed successfully

    And the confirmation message should contain "Thank you for your purchase!"