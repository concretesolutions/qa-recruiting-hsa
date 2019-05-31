
Feature: Sending text messages

  Scenario:  Send text message from WhatsApp

    Given In a conversation
    When I write a text message "Hola, como estás"
    And I press the send button
    Then The message is displayed in a cloud
    And Two gray arrows are displayed
    Then The text box is cleaned
    And The cursor is placed at the beginning to send another message



