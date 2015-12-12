@Location
Feature: Location of the rooms
  In this feature will be able to create feature and associate rooms to a specific location

  Background:
    Given I log in successfully as "test" with password "Client123"

  Scenario: User should be able to create the Location
    Given I go to the "Location" page
    When I create a Location with Name "B2-05" and Display Name "B2"
      And I refresh the page and come back "Location"
    Then the Location  should be displayed in the Location page
      And the Location "B2-05" should be obtained by API request

  Scenario: Assign rooms to a Location from the Location Association tab
    Given I open the Location details for Location "D4-03"
    When I associate the Room "Floor1-Room1" with the Location
    Then the Room "Floor1-Room1" should be associated to the Location in the Conference Rooms page
      And the Location "D4-03" should be obtained by API request for the Room "Floor1-Room1"

  Scenario: User should be able to dis-associate room from a Location
    Given I have a Location "Custom Name" with display name "display name" associate to Room with name "Floor1-Room1"
      And I open the Location and I select the Locations Associations tab
    When I dis-associate the Room "Floor1-Room2" of the Location
    Then The Room "Floor1-Room2" should be displayed in the column of "Available"
      And the Location "Custom Name" obtained by API request should not contains the Room "Room Name"