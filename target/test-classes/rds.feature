Feature: Execute UI & API tests

  @ui
  Scenario Outline: UI testing
    Given user launch the application
    And login with "<username>" and "<password>"
    Then click login button
    And add the product to cart
    Then user Navigateds to the cart

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  @api
  Scenario: API testing
    When I fetch the data
    And I query parameters
    Then I post data
    And I put request
    Then I delete a resource
