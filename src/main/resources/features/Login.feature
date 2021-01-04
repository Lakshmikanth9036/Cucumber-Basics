Feature: Application Login 

@userlogin 
Scenario: User want to login to the application with valid credentials 

	Given User navigate to the application 
	When user enter credentials "kanth123" and "kanth123" 
	And user clicks on signin button 
	Then user logs in successfully 
	And user logout 
	
@invalid 
Scenario: User want to login to the application with invalid credentials 

	Given User navigate to the application 
	When user enter credentials "kanth1234" and "kanth1234" 
	And user clicks on signin button 
	Then user receives bad credential error 
	
@multiCredCheck 
Scenario Outline:
User want to login to the application with multiple valid credentials 
	Given User navigate to the application 
	When user enters credentials <Username> and <Password> 
	And user clicks on signin button 
	Then user logs in successfully 
	And user logout 
	
	Examples: 
		| Username  | Password  |
		| kanth123  | kanth123  |
		| kanth1997 | kanth1997 |