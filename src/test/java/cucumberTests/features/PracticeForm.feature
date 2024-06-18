Feature: As user I want to fill practice form for multiple users

  Scenario Outline: As a user I want to fill multiple user data
    Given I want to launch "chrome" browser
    And enter the url "https://demoqa.com/automation-practice-form"
    When enter firstname "<first_name>", lastname "<last_name>" and email "<email>"
    And click on submit
    Then validate form saved or not
    Examples:
      | first_name | last_name | email             |
      | Nithesh    | Gowda     | nithesh@gmail.com |
      | Kusu       | Gowda     | kusu@gmail.com    |

