#Author: arunkm52@gmail.com

Feature: Hotel Booking 

  @tag1
  Scenario: Book Hotel
    Given I choose the configurations
    When I open the php demo page
    Then php demo page should be displayed
    When I click on homepgae front end button
    Then homepage should be displayed
    When I click on "Hotel" section
    Then "Hotel" search options should be displayed
    When I enter the search fields
    And I click on Search button
    Then search results should be displayed
    When I click on a hotel from the results
    Then booking page for the hotel should be displayed

