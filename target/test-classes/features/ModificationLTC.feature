Feature: Modify Long Term Contract(LTC) Functionality

  Scenario: Valid LTC Modification
    Given user launches application
    And user enters valid credentials
    And user should login successfully
    When user navigates to LTC page by quick navigation
    | LTC    |
    | 225126 |
    And user modifies the contract
    | 130000 |
    | 41     |
    And user validates and approves the quote
