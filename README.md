# homeworkAssg
## Problem Statement
Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome.

* Scenario to automate:
  1. Login using existing account
  2. Perform a search on home page from a pool of key words given below
  3. Identify an item from the result set that you can add to cart
  4. Add the item to cart
  5. Validate that item added is present in the cart and is the only item in the cart
  
### Test Data:
* Search terms: tv, socks, dvd, toys, iPhone.
* A Test account is created.

## Solution

### Assumptions
* Remove items from the cart if cart is not empty already.
* The code will be used to test for search terms from test data.
* The selected item should have only color. There should not be any option to choose color or size while adding item to cart.
* 'Add to Cart' button is reponsive all the time. Sometime it donot respond with selenium driver whihc cause test case to fail.


