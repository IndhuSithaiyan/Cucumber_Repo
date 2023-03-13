@ForgotPass
Feature: To validate forgotten password functionlity of facebook app

  @sanity @Regression
  Scenario: To validate forgotten password
    Given User have to enter facebook login through chrome browser
    And User have to click forgotten Password
    When User have to enter email or phoneNO
    Then User have to click search btn
  