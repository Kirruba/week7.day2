Feature: Create New Opportunity of SalesForce 

@regression 
Scenario: Create New Opportunity 

	Given Click on App Launcher button from the left corner 
	And Click view All 
	Given Click Sales from App Launcher 
	And Click on Opportunity tab 
	And Click on New button 
	When Enter Opportunity name as <opportunityName> 
	And Choose close date as Today 
	And Select Stage as <stage> 
	And Click Save 
	Then Verify Oppurtunity Name as given <opportunityName> 
	
	Examples: 
	
	|opportunityName|stage|
	|'Salesforce Automation by Kirruba'|'Needs Analysis'|
	
	