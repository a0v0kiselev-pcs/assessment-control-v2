@sample_tc1
Feature: Sample TC1

  Scenario: Responsive UI wide
    Given Use responsive UI 768X800, pixelRatio=1.0
    Given I open url "https://skryabin.com/webdriver/html/sample.html"
    Then element with xpath "//*[@id='location']" should be displayed
    And element with xpath "//*[@id='currentDate']" should be displayed
    And element with xpath "//*[@id='currentTime']" should be displayed

  Scenario: Responsive UI phone
    Given Use responsive UI 766X800, pixelRatio=1.0
    Given I open url "https://skryabin.com/webdriver/html/sample.html"
    Then element with xpath "//*[@id='location']" should not be displayed
    And element with xpath "//*[@id='currentDate']" should not be displayed
    And element with xpath "//*[@id='currentTime']" should not be displayed
