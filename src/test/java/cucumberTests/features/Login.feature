Feature: Login page test

  Scenario: As a user I want to login to application
    Given As a user I want launch browser
    Given Enter the url
    When login page is displayed enter username and password
    When click on login button
    Then verify Home page is displayed