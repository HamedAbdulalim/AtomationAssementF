@smoke
Feature: F01_Login | users could use login functionality to use their accounts

  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with "Admin" "admin123"

