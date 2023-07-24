@orderAPI
Feature: Order Management for Swagger Pet API

  # The Swagger Pet API is an application that allows users to manage pet-related information such as pet details,
  # pet categories, and orders. In this scenario, we will focus on the order management functionality of the API.
  # In this feature, as a user we are trying to create, get and delete the orders from pet store

  @createOrder
  Scenario Outline: Create a new order for Pet store
    Given The Swagger Pet API is running
    When I create a new order with the following given pet "<id>" "<petId>"
    Then The API should respond for "CREATESTOREID" API with a new order ID
    And The API should respond with a status code of 200
      Examples:
      |id     |petId|
      |1233445  |01   |


  @retrieveOrder
  Scenario Outline: Retrieve the created order details after creating the new order id
    Given The Swagger Pet API is running
    When I create a new order with the following given pet "<id>" "<petId>"
    Then The API should respond for "CREATESTOREID" API with a new order ID
    And An order with ID "<id>" exists
    When I retrieve the details from with given order id
    Then The "GETSTOREID" API should respond with the order details
     And The API should respond with a status code of 200
     Examples:
       |id     |petId|
       |1232245|01   |

  @OrderNotFound
  Scenario Outline: Unable to retrieve order details for given order id
    Given The Swagger Pet API is running
    When I retrieve the details from with given order "<id>"
    Then The "GETSTOREID" API should respond with the order not found details
    And The API should respond with a status code of 404
    Examples:
      |id |
      |5  |

  @deleteOrderId
  Scenario Outline: Delete an order
    Given The Swagger Pet API is running
    When I delete the order with ID "<id>"
    Then The order should be deleted from the system using "DELETEORDERID" API
    And The API should respond with a status code of 200
    Examples:
      |id    |
      |11111 |

  @deleteSameOrderId
  Scenario Outline: Validate the order not found
    Given The Swagger Pet API is running
    When I delete the order with ID "<id>"
    Then The order should be deleted from the system using "DELETEORDERID" API
    And The API should respond with a status code of 404
    Examples:
      |id     |
      |11111|

