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
* The selected item should not have any additional selection options like size, color etc. 
* 'Add to Cart' button is repond to click all the time. Sometime it does not respond with selenium driver which causes test case to fail.

### Instructions to run the code
* Copy the repo using command "git clone https://github.com/shilpasaini/homeworkAssg.git" .
* In Eclipse(JDK 1.8), import the project using Existing project in workspace.
* Make sure "chromerdriver.exe" is present in project directory.
* Open TestCase.java class
* Intilize the string 'itemToSearch'  with one of the searh item. The value should be in lower case.
* Right click on 'TestCase.java' and Run as 'JUnit Test'.


