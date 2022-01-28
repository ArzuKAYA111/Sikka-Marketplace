#Author: Arzu Kaya
Feature: Read tiles Industry-wise and App type-wise

    Scenario Outline: Read all the tiles on the UI and store them in the excel file Industry-wise and App type-wise.
      Given user navigate the application login Page
      Then user select "<industry>" from Industry options and "<appType>" from App type options and reads tiles then writes them into the excel "<sheetName>" sheet


        Examples: 
      | industry    |           appType                  |   sheetName         |
      |Dental       | Business Performance Management    |Dental_BPM           |
      |Dental       | Patient Marketing                  |Dental_PatMartk      |
      |Dental       | Payments                           |Dental_Paymnt        |
      |Dental       | Manufacturers/Labs                 |Dental_Manufactr     |
      |Dental       | Revenue Cycle                      |Dental_Revenue       |
      |Veterinary   | Business Performance Management    |Veterinary_BPM       |
      |Veterinary   | Patient Marketing                  |Veterinary_PatMartk  |
      |Veterinary   | Payments                           |Veterinary_Paymnt    |
      |Veterinary   | Manufacturers/Labs                 |Veterinary_Manufactr |
      |Veterinary   | Revenue Cycle                      |Veterinary_Revenue   |
      |Physician    | Business Performance Management    |Physician_BPM        |
      |Physician    | Patient Marketing                  |Physician_PatMartk   |
      |Physician    | Payments                           |Physician_Paymnt     |
      |Physician    | Manufacturers/Labs                 |Physician_Manufactr  |
      |Physician    | Revenue Cycle                      |Physician_Revenue    |
      |Optometry    | Business Performance Management    |Optometry_BPM        |
      |Optometry    | Patient Marketing                  |Optometry_PatMartk   |
      |Optometry    | Payments                           |Optometry_Paymnt     |
      |Optometry    | Manufacturers/Labs                 |Optometry_Manufactr  |
      |Optometry    |Revenue Cycle                       |Optometry_Revenue    |
      |Chiropractic | Business Performance Management    |Chiropractic_BPM     |
      |Chiropractic | Patient Marketing                  |Chiropractic_PatMartk|
      |Chiropractic | Payments                           |Chiropractic_Paymnt  |
      |Chiropractic | Manufacturers/Labs                 |Chiropractic_Manufactr|
      |Chiropractic |Revenue Cycle                       |Chiropractic_Revenue  |