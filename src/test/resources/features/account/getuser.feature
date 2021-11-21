@getdeleteuser

  Feature: Delete Data User from User ID
    As a user
    I want delete data user from User ID
    So i can remove data account user

  Scenario: Delete User By User ID
    Given I have a valid User ID
    When I enter endpoint with parameter User ID
        And I click endpoint
    Then I get data by User ID