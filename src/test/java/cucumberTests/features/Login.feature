Feature: Login page test
#Suppose if we have common steps like login or token generation in every scenarios we can keep those steps in background
  Background:
    Given As a user I want launch "chrome" browser
    Given Enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  #hardcoded values in step definitions
  Scenario: As a user I want to login to application
    When login page is displayed enter username and password
    When click on login button
    Then verify Home page is displayed

    #If scenarios have common gherkin statements it won't generate new methods for step defitions instead it uses the already implemented methods
  Scenario: As a user I want to login to application by passing all data from scenario
#    Given As a user I want launch "chrome" browser
#    Given Enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When login page is displayed enter username "Admin" and password "admin123"
    When click on login button
    Then verify Home page is displayed
    Then send number 123

    Scenario: As a user I will enter invalid user name and password error msg should display
#      Given As a user I want launch "chrome" browser
#      Given Enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
      When login page is displayed enter username "Nitii" and password "kusu"
      When click on login button
      Then verify error message is displayed