Feature: Create New Dashboard of SalesForce 

@smoke @sanity
Scenario: Create New Dashboard 

	Given Click on App Launcher button from the left corner 
	And Click view All 
	Given Click Dashboards from App Launcher 
	And Click on New Dashboard 
	When Enter Name as <name> 
	And Click on Create 
	And Click on Save 
	Then Verify Dashboard name as <name> 
	
	Examples: 
	
	|name|
	|'Salesforce Automation by Kirruba'|