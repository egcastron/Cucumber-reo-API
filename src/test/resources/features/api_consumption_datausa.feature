#Author: edisson.castronunez@tcs.com
#Languaje: EN

Feature: As a user I want to consume the service for validations

  @Sce1
  Scenario Outline: general fields validate
    When the user consults the api
    Then the user will see the fields <field>
    Examples:
      | field       |
      | ID Nation   |
      | Nation      |
      | ID Year     |
      | Year        |
      | Population  |
      | Slug Nation |

  @Sce2
  Scenario: validate Population by Year
    When the user consult the service with params
      | Year | 2016 |
    Then the user will see the response population
      | Population | 328239525 |
