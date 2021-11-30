Feature: login validation

  @Smoke
  Scenario: Valid admin login
 # Given user is navigated to HRMS
    When user enters valid username and password
    And user clicks on Login button
    Then admin user is successfully Logged in
  @Resgression
  Scenario: Valid ess login
  #   Given user is navigated to HRMS
    When user enters valid ess username and password
    And user clicks on Login button
    Then ess  user is successfully Logged in
  @Smoke @Sprint
    Scenario: valid username and invalid passsword
   #    Given user is navigated to HRMS
      When user enters valid username and invalid password
      And user clicks on Login button
      Then user see invalid credentials message on Login page