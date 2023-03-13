@Login
Feature: To validate Login Functionality of Facebook Application

  Background: 
    Given User have to enter facebook login through chrome browser

  @sanity @smoke
  Scenario: To validate login by using valid Email and invalid password
    When User have to enter valid Email and invalid Password
      #| Greens@gmail.com | 12357454 | javasel21 | asdf123 |    --------> 1 D List
      # key - value  ---->map
      | Username | Anitha                 |
      | Password |                 123456 |
      | email    | SeleniumJava@gmail.com |
    And User have to click login button
    Then User have to reach invalid credentials page

  @Regression @smoke
  Scenario: To validate login by using Invalid Email and Invalid Password
    When User have to enter invalid Email and invalid Password
      #| selenium | Greens@gmail.com | 12345678 |
      #| Java7890 | Greens           | testing1 |      ------------>2 D List
      #| java12@  | pythonsel        | 98776543 |

      #Maps
      | Username         | Email     | Password |             # Key 
      | python           |  12345667 | Manual   |             # value 1
      | Greens@gmail.com | javasel21 | asdf123  |             # value 2
      | Java7890         | Greens    | testing1 |             # value 3
    And User have to click login button
    Then User have to reach invalid credentials page
