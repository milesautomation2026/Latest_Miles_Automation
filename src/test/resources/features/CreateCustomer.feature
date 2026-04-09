Feature: Create Customer Functionality

@createCustomer
  Scenario: Valid Customer creation
    Given user launches application
    And user enters valid credentials
    And user should login successfully
	When user navigates to customer page
	And user creates new customer profile