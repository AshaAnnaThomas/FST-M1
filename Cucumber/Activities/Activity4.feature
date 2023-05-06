@activity4

  Feature: Login Test
    Scenario: Testing Login without Examples
      Given User is on the Login page
      When User enters "admin" and "password"
      Then Read the page title and the confirmation message
      And Close browser

