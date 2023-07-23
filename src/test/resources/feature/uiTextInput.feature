@TextInput
Feature: Verifying Text Input functionality on UITestingPlayground


  @InputText-01 @executeAfterStep
  Scenario: Verify that user should be able to land on Text Input Page
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the test input page
    Then User should be land on "Text Input" page

  @InputText-02 @executeAfterStep
  Scenario: Verify that user should be able to setting text into the input field and press the button
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the test input page
    Then User should see the text box input field and button
    And User should be able to set the text "PRESS ME"

  @InputText-03 @executeAfterStep
  Scenario: Verify that the set text in input box is matched with text inside the button
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the test input page
    Then User should see the text box input field and button
    And User should be able to set the text "PRESS ME"
    And User should be able to press the button and validate the text "PRESS ME"
