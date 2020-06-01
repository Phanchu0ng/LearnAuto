@sortByFeature
  Feature: Check Sort By Price

    Scenario: Check Sort By Price
    Given Go to home page
      When Go to Product Listing Page https://demo.smartosc.com/women/tops-women/jackets-women.html
      And click on list display
      And click on Sort by price
      Then Get List Price