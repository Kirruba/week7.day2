Feature: Create Opportunity without Mandatory Fields of SalesForce 

@functional 
Scenario: Create Opportunity without Mandatory Fields 

	Given Click on App Launcher button from the left corner 
	And Click view All 
	Given Click Sales from App Launcher 
	And Click on Opportunity tab 
	And Click on New button 
	And Choose Close date as Tomorrow Date 
	And Click Save 
	Then Verify the Alert message displayed for Name and Stage as <alertMessage> 
	
	Examples: 
	
	|alertMessage|
	|'Complete this field.'|
