
# Amazon Website Testing (End-to-End)
This project aims to perform end-to-end testing of the Amazon website using Maven, Java, Selenium, TestNG, and Page Objects. The project includes tests for error validation, homepage, product details, shopping functionality, and signIn functionality. Extent Reports are used to generate testing reports, and a YAML file is used to derive values to be used in test cases.

# Overview

The Amazon website testing project is designed to automate the testing of the popular e-commerce website Amazon.com. The project uses Maven, Java, Selenium, TestNG, and Page Objects to perform end-to-end testing of various features on the website. The tests are designed to validate the functionality and user experience of the website.

# Installation

To run the tests, you'll need to have Java, Maven, and Selenium installed on your system. You can install Java and Maven by following the instructions on their official websites. To install Selenium, you can use the following command:

**npm install selenium-webdriver**


# Usage
To run the tests, follow these steps:

1. Clone the project repository to your local machine.

2. Navigate to the project directory in your terminal.

3. Run the following command to execute the test suite:

**mvn test**

This will run the tests and generate a test report in the target/surefire-reports directory.

# Test Cases
The project includes the following test cases:

1. Error Validation Test - Validates that appropriate error messages are displayed when incorrect credentials are entered.

2. Homepage Test - Validates the content and functionality of the homepage.
3. Product Details Test - Validates the product details page for a specific product.
4. Shopping Functionality Test - Validates the ability to add products to the cart and complete the checkout process.
5. SignIn Functionality Test - Validates the ability to sign in to an existing account.

# Page Objects
The project uses the Page Object model to represent the pages of the Amazon website as objects. This approach makes it easier to maintain the tests as changes are made to the website. The Page Objects are located in the src/main/java/pageObjects directory.

# TestNG
The project uses TestNG to manage and execute the test cases. The TestNG configuration file is located in the pom.xml and testng.xml.


# Extent Reports
The project uses Extent Reports to generate test reports. After each test run, the report is automatically generated and saved within the project.

# YAML File
The project uses a YAML file to derive values to be used in the test cases. The file is located in the src/main/java/resources directory.

# Conclusion
The Amazon website testing project provides a robust and efficient way to perform end-to-end testing of the popular e-commerce website. The use of Maven, Java, Selenium, TestNG, and Page Objects ensures that the tests are reliable, maintainable, and easy to run. The use of Extent Reports and YAML files adds to the efficiency and accuracy of the testing process.