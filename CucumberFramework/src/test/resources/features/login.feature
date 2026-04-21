Feature: Login Test


Scenario: Valid login
Given user is on login page
When user enters username and password
Then user should see dashboard

Scenario: Valid login1
Given user is on login page
When user enters username and password
Then user should see dashboard