@slavery_footprint
Feature: Slavery Footprint
  In order to find out how many slaves work for them
  Users should be able to take the survey

  Scenario Outline: Take the survey
    Given a User is at the Slavery Footprint home page
    And the User starts taking the survey
    When the User enters their location as "<location>"
    And the User enters their details:
    | Gender | Age | Children | Housing Situation | House Items | Toiletries | Electronics Level | Sports |
    | <gender> | <age> | <children> | <housing situation> | <house items> | <toiletries> | <electronics level> | <sports> |
    Then my slave count should be <slaves>

  Examples: Survey results
    | location | gender | age | children | housing situation | house items | toiletries | electronics level | sports | slaves |
    | Melbourne | Male | 33 | boy:8,girl:10 | Renter | 2 x Bedroom, Bathroom, Car | shaving cream, moisturiser, dental floss, toothbrush, hand wash, soap, body wash, deodorant | technophobe | camping | 72 |
