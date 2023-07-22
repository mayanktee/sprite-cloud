# sprite-cloud
**Description**
Sprite-Cloud is an automation testing project that enables UI and API automation using a hybrid technique. The project utilizes Maven as its build tool and follows the Page Object Model (POM) design pattern for UI automation. It automates the UI testing of the "uitestingplayground" application. Additionally, the project includes API testing using Java with Rest Assured, focusing on automating the Swagger Pet Store APIs.

**Table of Contents**
Description
Requirements
Installation
Usage
Project Structure
UI Automation
API Automation
Contributing

**Requirements**
Java Development Kit (JDK) 8 or higher
Maven
Web browser (for UI automation)


**Installation**
Clone the repository from GitHub:

Copy code
git clone https://github.com/your-username/sprite-cloud.git
Navigate to the project directory:

Copy code
cd sprite-cloud
Install the required dependencies using Maven:
Copy code
mvn clean install

**Usage**
To run the UI automation for the "uitestingplayground" application, use the following command:

mvn test -Dtest=UITestSuite
For executing the API automation for Swagger Pet Store APIs, use the command:

mvn test -Dtest=APITestSuite

**Project Structure**
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
│        └── resources
│           └── feature                   # Feature files (if applicable)
├── pom.xml                              # Project's Maven configuration
└── README.md                           # Project documentation (you are here)


**UI Automation**
The UI automation is based on the Page Object Model (POM) design pattern. The "pages" package contains classes representing web pages or components of the "uitestingplayground" application. Each page or component has its associated methods to interact with elements and perform actions.

**API Automation**
The API automation utilizes Java with Rest Assured to test the Swagger Pet Store APIs. The "api" package includes test classes, each focusing on different API endpoints and scenarios. Test data, if required, can be found in the "testdata" directory under the "resources" folder.

**Contributing**
Contributions to Sprite-Cloud are welcome! If you find any issues or have suggestions for improvements, feel free to open a pull request. Please ensure to follow the standard coding conventions and provide clear commit messages.

