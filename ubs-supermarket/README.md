#Business requirements:

### Design and implement supermarket checkout component with readable API that calculates the total price of a number of items.
### Checkout mechanism can scan items and return actual price (is stateful)
### Our goods are priced individually. In addition, some items are multi-priced: "buy n of them, and they’ll cost you y cents"

  |Item  | Unit Price |  Special Price |
  |:----:|:-----------|----------------|
  |  A   |  40        | 3 for 60       |
  |  B   |  10        | 2 for 15       | 
  |  C   |  30        |                |
  |  D   |  25        |                |

# Non-functional requirements:
### Simple and elegant code
### Unit test cases.

# Known Limitation.
### The GUI interface development.

# Architecture / Design 
### Add items in the store with there individual price using item repository service.
### Put items in the basket using basket service.
### Checkout service will calculate the total price of items placed in the basket.
 
# Assumption
### More quantity purchased of an item will get more discount. 

  |Item  | Quantity   |  Special Price |
  |:----:|:-----------|----------------|
  |  A   |  3         |       60       |
  |      |  5		  |  	  75       | 
  |  	 |  10		  |      100       |
  |  	 |  20		  |      150       |       

#Note
### Initial data for unit testing created by data.sql file. 
 
# Steps todo testing.
### Use CheckoutTest file to calculate total price of the items in basket.





