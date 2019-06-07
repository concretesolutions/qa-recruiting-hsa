### WhatsAPP ###

Feature: Mute notification for
  In order to test mute notification
  As an user
  I want to validate if we can mute the notifications.

  Scenario: Register Whatsapp Number
    Given App Whatsapp installed on the Mobile Phone
     When the user click on the app icon
      And the mobile number is valid
     Then enter the mobile number on the app
      And receive the authentication code

  Scenario: Mute Notifications
    Given A valid number with a channel group added before.
     When the user click on chats tab
      And click on the group chat
      And the user click on the three dots right button
      And click on Mute Notifications
     Then enter the period of time to be muted
      And click on OK button

Feature: Starred Messages
  In order to test starred messages
  As an user
  I want to validate if we can see the starred messages.

  Scenario: Starred Messages
    Given App Whatsapp installed on the Mobile Phone and Registered
     When the user click on chats tab
     And click on the group chat
     Then click on any message and hold the message
      And click on the star icon

  Scenario: See Starred Messages
    Given A user with starred messages
     When the user click on the three dots right button
      And the user click on Starred Messages
     Then see the messages starred before.

Feature: Search
  In order to test search
  As an user
  I want to validate if we can get a list of words searched.

  Scenario: Search
    Given App Whatsapp installed on the Mobile Phone and Registered
     When the user click on search button on the right corner
     Then enter any word to search
      And while typing the word it should appear on the list.


