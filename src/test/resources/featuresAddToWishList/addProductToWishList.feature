@AddProductToWishList
Feature: Add Product To Wish List Test Case
@ClearWishList
  Scenario: Add Product To Wish List Successful
  Given Login to website with username and password
  |email|pass|
  |chuongpt@maillinator.com|123456a@|
  When click add product to wishlist
  |product|
  |product1|
  |product2|
  Then Verify Product in Wish-List Page
    |product|
    |product1|
    |product2|