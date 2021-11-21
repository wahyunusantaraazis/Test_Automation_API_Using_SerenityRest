@generatetoken

Feature: Generate Token functional in demoqa
  As a User
  I want to get my token for login
  So i can see my token

  #Token Succes
  Scenario: receive token with valid request payload
    Given I have account in demoqa
    When I am enter valid request payload
    And I click hit endpoint
    Then I am get token

  Scenario: failed receive token with invalid request payload
    Given I have account in demoqa
    When I am enter invalid request payload
    And I click hit endpoint with invalid request payload
    Then I am not get token
