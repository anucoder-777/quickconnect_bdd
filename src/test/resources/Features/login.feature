Feature: feature to test login

  Scenario: Check login is successful with valid credentials
    Given user is on the login page
    When user enters username and password
    And clicks on the login button
    Then the user should be navigated to the Home page