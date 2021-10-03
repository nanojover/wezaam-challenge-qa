Feature: As a Withdrwwal service consumer I want to request withdrawal-controller

  Scenario: GET withdrawal list
    When I perform the GET withdrawal request for "/v1/withdrawals"
    Then the withdrawal list is successfully retrieved

  Scenario: GET withdrawal list by id
    When I perform the GET withdrawal request for "/v1/withdrawals/2"
    Then the withdrawal list is successfully retrieved

  Scenario: POST withdrawal list by id
    When I perform the POST withdrawal request for /v1/withdrawals/users/"1"/payment-methods/1 with body
      | amount | executeAt |
      | 1,5    | immediate |
    Then the withdrawal list is successfully retrieved