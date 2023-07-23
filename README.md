# Sprite-Cloud
**Description:**

Sprite-Cloud is an automation testing project that enables UI and API automation using a hybrid technique. The project utilizes Maven as its build tool and follows the Page Object Model (POM) design pattern for UI automation. It automates the UI testing of the "uitestingplayground" application. Additionally, the project includes API testing using Java with Rest Assured, focusing on automating the Swagger Pet Store APIs.

**Table of Contents:**
1. Description
2. Requirements
3. Installation
4. Execution
5. Automated Scenarios
6. Usage
7. Project Structure
8. UI Automation
9. API Automation

**Requirements:**

Java Development Kit (JDK) 8 or higher
Maven
Web browser (for UI automation)


**Installation:**

Clone the repository from GitHub:

Copy code
git clone https://github.com/mayanktee/sprite-cloud.git
Navigate to the project directory:

Copy code

cd sprite-cloud

Install the required dependencies using Maven:
Copy code

mvn clean install

**Execution:**
1. To run the UI automation for the "uitestingplayground" application, use the following command:
   
   mvn test -Dtest=cucumber.Options.TestRunnerAPI
   
2. For executing the API automation for Swagger Pet Store APIs, use the command:
   
   mvn test -Dtest=cucumber.Options.TestRunnerUI

3. You can directly trigger the execution by Runner Class from local-machine - TestRunnerAPI & TestRunnerUI

4. This project is also integrated with Jenkins for build- CI 

**Automated Scenarios:**
1. API : I automated Swagger Pet Details & Pet Store Order API.
      1. Pet details : In this feature, as a user we are trying to automate and test add, update and upload the image of the pet API functionality.
      2. Pet Store Order API : In this feature, as a user we are trying to automate and test create, get and delete the orders API from pet store

   
2. UI : I automated uitestingplayground - Dynamic Table & Text Input Validation
      1. Text Input : In this feature, as a user we are trying to automate and test the landing on page, validation for input text box and button text change functionality. 
      2. Dynamic Table : In this feature, as a user we are trying to automate and test the landing on page, validation for chrome field load % and chrome load value in table matches with yellow label chrome load below the table functionality.


**Project Structure:**
The project follows a well-organized structure:

Copy code
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── requestPojo            # Contains Request API Pojo class
│   │   │   │── testBase              # Contains Page Object classes for UI automation
│   │   │   │── utils                # Utility classes and helper methods
│   │   │                 
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── cucumber.Options
│       │   │   ├── TestRunnerAPI            # Contains UI test classes using POM
│       │   │   └── TestRunnerUI           # Contains API test classes using Rest Assured
│       │   └── step.definitions            # Step definitions of UI & API test
│       │   └── testUtils                  # Test utilities
│       └── resources
│           └── feature                   # Feature files (if applicable)
├── pom.xml                              # Project's Maven configuration
└── README.md                           # Project documentation (you are here)


**UI Automation:**

The UI automation is based on the Page Object Model (POM) design pattern. The "pages" package contains classes representing web pages or components of the "uitestingplayground" application. Each page or component has its associated methods to interact with elements and perform actions.

**API Automation:**

The API automation utilizes Java with Rest Assured to test the Swagger Pet Store APIs. The "api" package includes test classes, each focusing on different API endpoints and scenarios. Test data, if required, can be found in the "feature" and "global.properties" directory under the "resources" folder.


