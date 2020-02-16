Feature: My feature tests are described here

@RunSBSVideoTest @RunSBS
  Scenario: Play Video
    Given I choose configurations from config file
    When I open SBS video page
    Then I play the content
    And I pause the ad content
    When I click play after pause
    And I play the video for "02:00" minutes
    Then I wait for finish
    
@RunSBSApiAndWebTest @RunSBS
  Scenario: Test Api response and verify front end
    Given I choose configurations from config file
    When I call the Api
    Then I verify the Api response code
    And I get mp3 files list from reponse data
    When I open the webpage
    Then I verify the webpage items with mp3 files from Api response
    