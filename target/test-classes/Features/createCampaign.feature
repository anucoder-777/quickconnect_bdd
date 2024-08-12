Feature: feature to test create Campaign

  Scenario Outline: Validate campaign can be created successfully
    Given the anonymous user is on the Landing page
    And that anuonymous goes to login page and fill the login form with <email> and <password>
    When the anonymous user logs in the system
    And the user goes to Create Campaign
    And the user fills the form
    And the user clicks Create button
    Then the campaign is created successfully
    
    Examples:
    | email | password |
    | xefaja4536@eixdeal.com | 12345678 |
