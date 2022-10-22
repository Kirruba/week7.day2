Feature: Create Individuals of SalesForce 

@smoke @sanity 
Scenario: Create New Individuals 

	Given Click on App Launcher button from the left corner 
	And Click view All 
	Given Click Individuals from App Launcher 
	And Click on Dropdown icon in the Individuals tab 
	And Click on New Individual 
	When Enter Last Name as <lastName> 
	And Click on save 
	Then Verify Individuals Name as <lastName> 
	
	Examples: 
	
	|lastName|
	|'Kumar'|