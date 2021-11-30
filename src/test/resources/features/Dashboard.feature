Feature: Dashboard tabs verification

  Background:
    And user is loggen in with valid admin credentials


  @dashboard
  Scenario: Dashboard tab
    Then user verify the dashboard options available on the page
      |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

    @office
    Scenario: US12345(2) Verify all office locations have name and country displayed HRSM application (Must be verified against DB)
      When user clicks on Directory option
      And selects Location dropdown
      And queries HRMS DATAbase
     Then validate HRMS Application Data against DataBase

  @Job
  Scenario: US 12345: Verify that all job titles are displayed in Ascending order in HRMS Application
    When user clicks on Admin option
    And selects Job dropdown
    And clicks on Job Titles
    And queries HRMS DATAbase for Job titles
    Then user verifies that all job titles are in ascending oder