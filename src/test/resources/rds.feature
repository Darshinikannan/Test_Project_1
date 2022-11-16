Feature: Execute UI & API tests

  @api
  Scenario: API testing
    When I fetch the data
    And I query parameters
    Then I post data
    And I put request
    Then I delete a resource
