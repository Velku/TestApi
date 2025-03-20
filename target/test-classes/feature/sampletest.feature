Feature: Sample API Test feature
  
  @testnew1
  Scenario: Validate Create ID Post API
    Given I prepare payload for POST Api call
    | firstname | <firstname> |
    | lastname  | <lastname> |
    | totalprice | <totalprice> |
    | depositpaid | <depositpaid> |
    |checkin| <checkin>|
    | checkout | <checkout>|
    | additionalneeds | <additionalneeds>| 
    And I add the headers 
    When I create the post request 
    Then I validate the API response
    
Examples:
| firstname | lastname | totalprice | depositpaid | checkin | checkout |additionalneeds |
| Raja | Kumar | 111 | true | 2018-01-01 | 2018-01-01 | Breakfast | 
 
