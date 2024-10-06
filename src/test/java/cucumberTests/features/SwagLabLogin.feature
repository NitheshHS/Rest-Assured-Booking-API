Feature: Swag lab login page

  Background:
    #Given launch browser
    When enter swag lab login page url "https://www.saucedemo.com/v1/"
    #Tags -> group the scenarios based on Regression, End2End, Sanity, env
    # Scenario outline used to run the scenario for multiple set of data/Examples
  @Regression @End2End
  Scenario Outline: Login to swag lab app using multiple user creds
    When login page is displayed enter username "<user_name>" and password "<pass_word>" and click on login button
    Then verify home page url is "https://www.saucedemo.com/v1/inventory.html"
    Examples:
      | user_name               | pass_word    |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @SmokeTest
  Scenario: Login to swag lab
    When login page is displayed enter username and password and click on login
     | standard_user   | secret_sauce | niku |
      #|0|1|
      # row=0, col=0, col=1, (0,0)->standard_user, (0,1)->secret_sauce (3)rows and columns starts from index 0
    #(1,1)->secret_sauce (1,0)->locked_out_user
    Then verify home page url is "https://www.saucedemo.com/v1/inventory.html"



