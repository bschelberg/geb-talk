@wikipedia
Feature: Wikipedia Search
  In order to find information
  Users should be able to search for a topic

  Scenario: User searches for "geb"
    Given a User is at the Wikipedia home page
    When the User searches for "geb"
    Then the User should see an article about "Geb"