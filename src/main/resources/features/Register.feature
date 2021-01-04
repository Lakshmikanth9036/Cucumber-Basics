Feature: User Registration

Background:
Given User navigate to the phptravels site 

@userReg
Scenario: User create a new account by filling registration details
Given user in home page 
When he click on My Account dropdown and select sigin up option
And user fills the following registraion details
	| Lakshmikanth | N | 9887654310 | kk.kk@gmail.com | 123456 | 123456 |
And user click on sign up button
Then redirect to welcome page