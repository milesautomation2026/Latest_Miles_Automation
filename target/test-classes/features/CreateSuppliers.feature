Feature: Create Supplier Functionality

  Scenario: Valid Suppliers creation
    Given user launches application
    And user enters valid credentials
    And user should login successfully
	When user navigates to suppliers page
	And user creates new Supplier profile
	| NV |
	| RKPP Logistics |
	| BE42878513883154 |
