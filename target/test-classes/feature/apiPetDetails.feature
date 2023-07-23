@petDetailsAPI
Feature: Everything about your pet form Swagger Pet API

  # The Swagger Pet API is an application that allows users to manage pet-related information such as pet details,
  # pet categories, and orders. In this scenario, we will focus on the order management functionality of the API.
  # In this feature, as a user we are trying to automate and test add, update and upload the image of the pet functionality

  @addPet
  Scenario Outline: Add a new pet to store
    Given The Swagger Pet API is running
    When I add a new pet with the following given pet details "<categoryId>" "<categoryName>" "<petName>"
    Then The API should respond for "ADDPET" API with a new added pet ID
    And The API should respond with a status code of 200
      Examples:
      |categoryId  |categoryName|petName|
      |12345       |01          |Raju   |

  @addPetInvalidInput
  Scenario Outline: Add a new pet to store with invalid details
    Given The Swagger Pet API is running
    When I add a new pet with the following given pet details "<categoryId>" "<categoryName>" "<petName>"
    Then The API should respond for "ADDINVALIDPET" API with a new added pet ID
    And The API should respond with a status code of 404
    Examples:
      |categoryId  |categoryName|petName|
      |12345       |01          |Raju   |


  @updatePet
  Scenario Outline: Update an existing pet
    Given The Swagger Pet API is running
    When I add a new pet with the following given pet details "<categoryId>" "<categoryName>" "<petName>"
    Then The API should respond for "ADDPET" API with a new added pet ID
    And The API should respond with a status code of 200
    And Now I update the pet details with new details "<newPetName>"
    Then  The API should respond for "UPDATEPET" API with updated details "<newPetName>"
    And The API should respond with a status code of 200
    Examples:
      |categoryId  |categoryName|petName|newPetName|
      |12345       |01          |Raju   |pup     |


  @uploadImage
  Scenario Outline: Validate Upload a pet image API
    Given The Swagger Pet API is running
    When I upload the pet image with "<petId>" and "<filePath>"
    Then The API should respond for "UPLOADIMAGE" API with a new added pet ID
    And The API should respond with a status code of 200
    Examples:
      |petId  |filePath     |
      |12345  |dog_img.png  |
