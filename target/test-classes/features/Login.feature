Feature: Login Functionality

  Scenario: Valid login
    Given user launches application
    When user enters valid credentials
    Then user should login successfully
