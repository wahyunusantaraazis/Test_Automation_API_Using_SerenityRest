@register
Feature: Register functional in demoqa
  As a User
  I want to register demoqa account
  So i can created account demoqa

  Scenario: register with valid email and password
    Given I am on the register page
    When I input my valid username and password
    And i click register button
    Then I am redirected to the profile

  Scenario: register with account user exist
    Given I am on the register page
    When I entered a registered account
    And i click register button when account exist
    Then failed register and show user exist