Feature: As a Withdrwwal service consumer I want to request user-controller

  Scenario: Get user list
    When I perform the GET user request for "/v1/users"
    Then the user list is successfully retrieved