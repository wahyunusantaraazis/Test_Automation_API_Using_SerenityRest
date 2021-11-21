@getallbooks
Feature: GET All Book in demoqa
  as a user
  I want to get all book in bookstore
  So I can see list all book

  Scenario: I Want to see list all books
    Given I am ready see all books in bookstore
    When  I want to see list in bookstore by ISBN
    Then status code 200 and correct JSONScema