#Author: Arzu Kaya


Feature: Read each tiles name ,its Industry and App Type from excel sheet and verify on the 
https://www.sikkasoft.com/Marketplace whether that specific tile is available under the given Industry and App Type.

Background:
  Given user navigate the application login Page
  
 @smoke
  Scenario: Get the Tiles for Dental type industry and Business Performance Management type App and write in excel
    Then user select "Dental" from Industry options and  "Business Performance Management" from App type options
    And User gets the tiles writes the tiles, "Dental" and "Business Performance Management"  into the "Dental_BPM" sheet
    
    
    
    Scenario: Get the Tiles for Dental type industry and Patient Marketing type App and write in excel
    Then user select "Dental" from Industry options and  "Patient Marketing" from App type options
    And User gets the tiles writes the tiles, "Dental" and "Patient Marketing" into the "Dental_PatMartk" sheet
    
    
    
    Scenario: Get the Tiles for Dental type industry and Patient Marketing type App and write in excel
    Then user select "Dental" from Industry options and  "Payments" from App type options
    And User get the tiles writes the tiles, "Dental" and "Payments"  into the "Dental_Paymnt" sheet
    
    
    
    Scenario Outline: Get the Tiles for Dental type industry and Patient Marketing type App and write in excel
    Then user select "industry>" from Industry options and "<app>" from App type options
    And User gets the tiles writes the tiles, "<industry>" and "<appType>" into the "<sheetName>" sheet
    
    
    
    
        Examples: 
      | industry      |  appType                           |sheetName  |
      | Dental        | Business Performance Management    |Dental_BPM |
      | Dental        | Patient Marketing                  |Dental_PatMartk|
      | Dental        | Payments                           |Dental_Paymnt|
      |Dental         | Manufacturers/Labs                 |Dental_Manufactr |
      |Dental         |Revenue_Cycle                       |Dental_Revenue|
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
