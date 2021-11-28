@postputdeletebook
Feature: POST certain Book in demoqa
  as a user
  I want to add favorite book to my collection
  So I succes add book

  #POST
  Scenario: I to add favorite book by valid ISBN
    Given I have account in bookstore
    When  I want to add certain book by ISBN
    Then status code 201 and correct Response Body Post

  #PUT
  Scenario: I want to update favorite book by ISBN
    Given I have account in bookstore
    When I want to change certain book by ISBN
    Then status code 200 and succes change certain book in favorite

  #DELETE
  Scenario: I want to delete a favorite book in my collection
    Given I have account in bookstore
    When I want to delete book with request body isbn and userid
    Then status code 204 and response body correctly

  @TEST1
  Scenario: End to End Post, Put, Delete Book
    Given I have account in bookstore
    When I want to add certain book by ISBN
    And I want to change certain book by ISBN
    And I want to delete book with request body isbn and userid
    Then status code 204 and response body correctly