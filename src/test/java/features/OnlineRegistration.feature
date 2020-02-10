Feature: OnlineRegistrationFeature
  This feature does an incomplete online job application with a failure verification at the end

  Scenario: Apply online with incomplete details
    Given I navigate to the iLab careers page
    And I select the country as South Africa
    And I select the first link under CURRENT OPENINGS
    And I click the Apply Online button
    And I enter the following personal details
      | firstName | email                                |
      | Phumlani  | automationAssessment@iLABQuality.com |
    And I insert an auto-generated phone number
    And I click the Send button
    Then I validate the error text