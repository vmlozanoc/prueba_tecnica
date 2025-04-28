Feature: File test

  Background: Login to OrangeHRM
    Given The login page is displayed
    When I enter the credentials

  Scenario: Upload a file
    Given I am on the main page
    When I select the My Info option
    And I select the Contact Details option option from my info
    And I upload a file
    Then I verify the uploaded file

  Scenario: Delete a file
    Given I am on the main page
    When I select the My Info option
    And I select the Contact Details option option from my info
    And I delete the file
    Then I verify the file has been deleted