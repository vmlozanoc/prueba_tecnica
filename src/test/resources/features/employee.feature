Feature: Employed

  Background:  Login to OrageHRM
    Given The login page is displayed
    When I enter the credentials

  Scenario: Add a new employee
    Given I am on the main page
    When I select the PIM option
    And I add employee
      | firstName | middleName  |lastName|
      | Fulanito  | De          | Tal    |

    Then I verify that the employee was created successfully


  Scenario: Search employee by name
    Given I am on the main page
    When I select the PIM option
    And I search for the employee by name Fulanito
    Then I verify that the correct result is shown

  Scenario: Delete employee
    Given I am on the main page
    When I select the PIM option
    And I search for the employee by name Fulanito
    And I delete the employee
    Then I verify that the employee was deleted successfully


  Scenario Outline: Add employee leaving fields empty
    Given I am on the main page
    When I select the PIM option
    And I add employee
      | firstName  | lastName  |
      | <firstName> | <lastName> |

    Then I verify that the employee cannot be created

    Examples:
      | firstName | lastName |
      |           | sadad    |
      | sad       |          |

