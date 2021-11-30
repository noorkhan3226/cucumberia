Feature: Search employee
@Resgression
  Scenario: search employee bt id
 #   Given user is navigated to HRMS
    And user is loggen in with valid admin credentials
    And user navigates to employee list page
    When  user enters valid employee id
    And  click on search button
    Then user see employee information is displayed

@Sprint @hab
  Scenario: search employee bt name
 #    Given user is navigated to HRMS
    And user is loggen in with valid admin credentials
    And user navigates to employee list page
    When  user enters valid employee name
    And  click on search button
    Then user see employee information is displayed