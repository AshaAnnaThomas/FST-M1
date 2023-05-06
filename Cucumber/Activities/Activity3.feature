@activity3

  Feature: Testing with tags

    @SimpleAlert @SmokeTest
    Scenario: Testing with Simple Alert
      Given User is on the page
      When User clicks the Simple Alert Button
      Then Alert opens
      And Read the text from it and print it
      And Close the Alert
      #And Read the result text
      And close browser

    @ConfirmAlert
    Scenario: Testing with Confirm Alert
      Given User is on the page
      When User clicks the Confirm Alert Button
      Then Alert opens
      And Read the text from it and print it
      And Close the Alert with Cancel
      #And Read the result text
      And close browser


    @PromptAlert
    Scenario Outline: Testing with Prompt Alert
      Given User is on the page
      When User clicks on the Prompt Alert Button
      Then Alert opens
      And Read the text from it and print it
      And Write a "<customMessage>" in it
      And Close the Alert
      #And Read the result text
      And close browser

      Examples:
      |customMessage|
      |This is a text message|
