Feature: Login Test Feature
  @login
  Scenario: Login Test 01
    Given I Navigate to TNB Login Page
    When  User Enters Username as "admin"
    And User Enters Password as "password"
    And User Clicks Login Button
    Then User Should Successfully Login