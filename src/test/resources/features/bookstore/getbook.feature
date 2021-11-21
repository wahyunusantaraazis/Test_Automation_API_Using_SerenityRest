@getbook
Feature: GET certain Book in demoqa
  as a user
  I want to get certain book in bookstore
  So I can see certain book

  Scenario: I Want to see certain book
    Given I have ISBN for see details book
    When  I want to see certain book by ISBN
    Then status code 200 and correct Response Body