Feature: seleniumframework.com features
  Scenario: Open seleniumframework website
    Given I open seleniumframework website
    And I navigate to ABOUT link
    Then I print the html
  Scenario: Browser commands
    Given I open seleniumframework website
    And I perform selenium browser commands
    Then I take a screenshot
