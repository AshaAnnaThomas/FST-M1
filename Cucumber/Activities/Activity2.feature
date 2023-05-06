@activity2

  Feature: Login Test

    Scenario: Testing Login
      Given User is on the Login page
      When User enters Username and Password
      Then Read the page title and the confirmation message
      And Close browser