@tag
  Feature: check functionality of Amazon's Home page.

    Background:
      Given Land on Amazon website


      Scenario Outline: functional testing of Amazon home page
        Given click on SignIn button and navigate back to home page
        When try to click on footer links and get the titles
        And Hover on other functional tabs and send keys <keys> to text box
        Then get the count of top rated product links
        Examples:
          | keys |
          |coffee machine|

