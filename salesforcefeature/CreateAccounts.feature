Feature: Create New Opportunity of SalesForce 

@smoke @sanity 
Scenario: Create New Opportunity 

	Given Click on App Launcher button from the left corner 
	And Click view All 
	Given Click Sales from App Launcher 
	And Click on Accounts tab 
	And Click New Account 
	When Enter your name as <accountName> 
	And Select Ownership as <ownership> 
	And Click save 
	Then Verify Account name as <accountName> 
	
	Examples: 
	
	|accountName|ownership|
	|'Kirruba'|'Public'|
	
