Feature: Parking Cost

  Scenario: Calculation of the Parking cost
    Given User launch "Chrome" browser 
    When User opens URL "http://www.shino.de/parkcalc\"
    When User selects "parkingType" Parking
    And User selects "11/16/2020" Starting date
    And User selects "11/17/2020" Leaving date
    And User enters "09:00" of stimings
    And User enters "23:00" of ltimings
    And User clicks on radio buttons "am" of stimings
    And User clicks on radio buttons "am" of ltiming
    When User clicks "calculate" on the Calculate button
    Then relevant results should displayed
    And close browser

