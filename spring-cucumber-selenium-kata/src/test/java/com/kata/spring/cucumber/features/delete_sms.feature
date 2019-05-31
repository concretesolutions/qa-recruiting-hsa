Feature: Delete text messages

  Scenario: Delete text messages from Whatsapp

    Given In a conversation
    When I click on the cloud of a message
    And A options panel is displayed
    And Several options are visualized
    Then I select the option "Eliminar para todos"
    And I click on the OK button
    And The message is removed from the conversation
    And It is displayed in the message cloud "Eliminaste este mensaje"

