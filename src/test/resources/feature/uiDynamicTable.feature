@DynamicTable
Feature: Verify DynamicTable functionality on UITestingPlayground

  @dtable-01 @executeAfterStep
  Scenario: Verify that user should be able to land on Text Input Page
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the Dynamic Table page
    Then User should be land on "Dynamic Table" page

  @dtable-02 @executeAfterStep
  Scenario: Verify the user is able to get the values from the dymaic table
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the Dynamic Table page
    Then User should able to get the value from the table for Chrome Process


  @dtable-03 @executeAfterStep
  Scenario: Verify the Chrome Process value in table matches with Yellow label Chrome CPU Value
    Given Launch the application UITestingPlayground
    And User is on the "UI Test Automation" application home page
    When User navigate to the Dynamic Table page
    Then User should able to get the value from the table for Chrome Process
    And User should be able to compare the value with Yellow label CPU load



