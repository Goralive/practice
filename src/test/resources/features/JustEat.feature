Feature: Use the website to find restaurants
  So that I can order food
  As a hungry customer
  I want to be able to find restaurants in my area

  Background:
    Given User is open search "https://www.just-eat.co.uk/"

  Scenario: Search for restaurants in an area
    Given I want food in AR51 1AA
    When I search for restaurants
    Then I should see some restaurants in AR51 1AA

  Scenario: No errors if text was deleted before clicking search button
    Given I want food in AR51 1AA
    When I delete text from search field and click search button
    Then I should see some restaurants in AR51 1AA

  Scenario: Error message is shown
    Given I want food in invalid data
    When I search for restaurants
    Then I should see error message