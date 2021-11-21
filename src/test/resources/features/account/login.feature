@login
Feature: Login functional in demoqa
  As a User
  I want to login to my demoqa account
  So i can see my dashboard in demoqa

  #Login Succes
  Scenario: login with valid email and password
    Given I am on the login page
    When I enter my valid username and password
         And i click Login button
    Then I am redirected to the dashboard
         And get userID