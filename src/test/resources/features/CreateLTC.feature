Feature: Create new LTC Functionality

  Scenario: Valid new LTC creation
    Given user launches application
    And user enters valid credentials
    And user should login successfully
	When user navigates to Customers page by quick navigation
    | Custom          	  |
    | %CU KP Breakfast%   |
    And user searches existing customer
    Then user selects customer from the list
    | CU KP   |
    And user navigates to quote page
    And select the quotation template and others field
    | Finance lease |
    | Patil, DriverKP |
    And select the vehicle name, type and model
    | FORD  	 |
    | MUSTANG 	 |
    | 5.0 MACH 1 |
    And select broker,dealer and duration and distance
    | KP Chad Wheeler    	|
    | SU KP Deals on wheels |
    | 36    |
    | 12000 |
    And Add equipment and lease services
    | 		55S   	|
    | 		764F  	|
    |	JATO764F	|
    And Calculate,Validate ,Approve and Contract
    