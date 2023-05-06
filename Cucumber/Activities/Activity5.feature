@activity5

  Feature: Login Test

    Scenario Outline: Testing Login with Example
      Given User is on the Login page
      When User enters "<username>" and "<password>"
      Then Read the page title and the confirmation message
      And Close browser
      Examples:
      | username | password |
      | admin    | password |
      | adminUser | password |
