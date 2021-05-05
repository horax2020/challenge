@MSLanding

Feature: MS Landing Page

Scenario: User reaches Microsoft front page
    Given User lands MS front page
    Then verifies persistent tab menu exists MS365, Office, Windows, Surface, XBox, Deals and Support


Scenario: User inspects Windows 10 menu
    Given User reaches Windows page
    When shows Windows context Menu

Scenario: User perform a search
    Given User lands MS front page
    When obtain search results for Visual Studio
    Then Validates the first item details
    And Validate the three prices in the cart
    And Validate with Twenty in quantity

