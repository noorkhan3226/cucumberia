Feature: Login error verification
  @loginReview1
  Scenario: valid username and invalid password
    When user enters valid "admin" and invalid "Hum@nhrm12345"
    And user clicks on Login button
    Then user see invalid credentials message on Login page

  @loginReview
  Scenario Outline: valid username and valid password
    When user enters valid "<username>" and invalid "<password>"
    And user clicks on Login button
    Then user verify dashboard page
    Examples:
      |username|password|
      |admin   |Hum@nhrm123|
      |johnny1234560000|Syntax1253!!!!|

