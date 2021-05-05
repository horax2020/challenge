#Second Test Case:
#
#1.            Go to Amazon main page
#
#2.            Locate at the upper right corner the button: Hello, Sign In Account & lists and click on it
#
#3.            Click on “New customer? Start right here”
#
#4.            Fill Name field with the response of this API => [Options in the AC]
#
#5.            Fill Email field with the data from the API response Firstname.Lastname@fake.com
#
#6.            Click on Condition of Use link
#
#7.            Locate the search bar and Search for Echo
#
#8.            Locate “Echo support” options and click on it
#
#9.            Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting

@AmazonLanding

Feature: Amazon navigation

  Scenario: User fills New customer form
    Given User lands Amazon front page
    When navigates to New Customer
    Then fills the data from the API source
    And navigates to Condition of Use


  Scenario: User inspects Amazon Echo Support
    Given User lands Condition of use
    When search for Echo
    And click over Echo Support
    Then Validate existing elements

