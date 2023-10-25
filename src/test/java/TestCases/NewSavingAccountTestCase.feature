Feature: Opening New Saving Account Feature
  @saving
  Scenario: Opening New Saving Account
    Given User On TNB Home Page
    When User Hover Over Open New Account
    And User Clicks The New Saving Account
    Then User Should be Redirected to Business Account Page in New Window
    When User Enters Firstname and Lastname
    And User Enters Email and Business Name
    And User Enters Business Type and Business Address
    And User Enter Tax ID and Selected Business State
    When User Clicks the Submitted Button
    Then User Should See Success Message on alert and Accepts
    Then User Should be Redirected To Home Page


