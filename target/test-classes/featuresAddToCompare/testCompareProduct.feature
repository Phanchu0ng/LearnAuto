@TestAddProductToCompare
Feature: Add to Compare Test Case
  @ClearCompareList
  Scenario: Add Product To Compare Successful
    Given Login to website with username and password
      |email|pass|
      |chuongpt@maillinator.com|123456a@|
    When Click add product to compare list
      |product|
      |product1|
      |product2|
    Then Verify Product in compare page
      |product|
      |product1|
      |product2|