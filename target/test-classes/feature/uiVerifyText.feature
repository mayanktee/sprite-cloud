Feature: Verify Text Input functionality on UITestingPlayground

  @tc1 @executeAfterStep
  Scenario: Record setting text into the input field and pressing the button
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the test input page
    Then User should see the text box input field and button
    And User should be able to set the text "PRESS ME"


  @tc2 @executeAfterStep
  Scenario: Record setting text into the input field and validate button name changed
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the test input page
    Then User should see the text box input field and button
    And User should be able to set the text "PRESS ME"
    And User should be able to press the button and validate the text "PRESS ME"
