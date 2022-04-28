#Author: edisson.castronunez@tcs.com
#Languaje: EN

Feature: As a user I want to consume the service for validations

  @Sc1
  Scenario Outline: general fields validation
    When the user consults the service
    Then the user will see the fields <field>
    Examples:
      | field          |
      | alpha_two_code |
      | web_pages      |
      | name           |
      | country        |
      | domains        |
      | site           |
      | home           |

  @Sc2
  Scenario: validate domain bu name
    When the user consults the service with param
      | name | Marywood University |
    Then the user will see the response domain
      | domains | marywood.gov |

  @Sc3
  Scenario: validate alpha two code by name
    When the user consults the service with param
      | name | Marywood University |
    Then the user will see the response alpha
      | alpha_two_code | USA |