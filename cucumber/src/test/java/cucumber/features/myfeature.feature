Feature: Proof of concept that my framework works

  Scenario: My first test
    Given I navigated to the Caplin website
    When I get the page title
    Then I check that is equals with Caplin Systems
    Then I close the web browser
