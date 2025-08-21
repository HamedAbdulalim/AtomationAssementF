@smoke
Feature: F02_AdminTab | user Click on Admin tab on the left side menu


  Scenario: user able to Click on Admin tab on the left side menu
    Given user Login to System
    When user click on AdminTab
    Then Count Records number
    And Fill the required data
    Then Click on save button
    And Number of Records increased by one
    When search for user
    Then Delete User
    And Number of Records decreased by one