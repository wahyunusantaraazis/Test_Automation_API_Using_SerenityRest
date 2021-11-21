@authorized

  Feature: Authorized account
    as a user
    i want authorized my account
    so i can get user ID with authorized account

  Scenario: Autorized my account
    Given I am have an account
    When I enter username and password my account
        And I click hit endpoint authorized
    Then Response body 'True'
