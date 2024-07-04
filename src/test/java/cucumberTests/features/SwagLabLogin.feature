Feature: Swag lab login page

  Scenario Outline: Login to swag lab app using multiple user creds
    Given launch browser
    When enter swag lab login page url "https://www.saucedemo.com/v1/"
    When login page is displayed enter username "<user_name>" and password "<pass_word>" and click on login button
    Then verify home page url is "https://www.saucedemo.com/v1/inventory.html"
    Examples:
      | user_name               | pass_word    |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
