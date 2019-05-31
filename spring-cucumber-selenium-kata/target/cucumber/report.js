$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("delete_sms.feature");
formatter.feature({
  "line": 1,
  "name": "Delete text messages",
  "description": "",
  "id": "delete-text-messages",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Delete text messages from Whatsapp",
  "description": "",
  "id": "delete-text-messages;delete-text-messages-from-whatsapp",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "In a conversation",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the cloud of a message",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "A options panel is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Several options are visualized",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I select the option \"Eliminar para todos\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click on the OK button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "The message is removed from the conversation",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "It is displayed in the message cloud \"Eliminaste este mensaje\"",
  "keyword": "And "
});
formatter.match({
  "location": "SendAndDeleteMessages.inAConversation()"
});
formatter.result({
  "duration": 419690400,
  "error_message": "java.lang.NullPointerException\r\n\tat com.kata.spring.cucumber.steps.SendAndDeleteMessages.inAConversation(SendAndDeleteMessages.java:48)\r\n\tat ✽.Given In a conversation(delete_sms.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SendAndDeleteMessages.iClickOnTheCloudOfAMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.aOptionsPanelIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.severalOptionsAreVisualized()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Eliminar para todos",
      "offset": 21
    }
  ],
  "location": "SendAndDeleteMessages.iSelectTheOption(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.iClickOnTheOKButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.theMessageIsRemovedFromTheConversation()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Eliminaste este mensaje",
      "offset": 38
    }
  ],
  "location": "SendAndDeleteMessages.itIsDisplayedInTheMessageCloud(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("send_sms.feature");
formatter.feature({
  "line": 2,
  "name": "Sending text messages",
  "description": "",
  "id": "sending-text-messages",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Send text message from WhatsApp",
  "description": "",
  "id": "sending-text-messages;send-text-message-from-whatsapp",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "In a conversation",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I write a text message \"Hola, como estás\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I press the send button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The message is displayed in a cloud",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Two gray arrows are displayed",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "The text box is cleaned",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "The cursor is placed at the beginning to send another message",
  "keyword": "And "
});
formatter.match({
  "location": "SendAndDeleteMessages.inAConversation()"
});
formatter.result({
  "duration": 972300,
  "error_message": "java.lang.NullPointerException\r\n\tat com.kata.spring.cucumber.steps.SendAndDeleteMessages.inAConversation(SendAndDeleteMessages.java:48)\r\n\tat ✽.Given In a conversation(send_sms.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hola, como estás",
      "offset": 24
    }
  ],
  "location": "SendAndDeleteMessages.iWriteATextMessage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.iPressTheSendButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.theMessageIsDisplayedInACloud()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.twoGrayArrowsAreDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.theTextBoxIsCleaned()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SendAndDeleteMessages.theCursorIsPlacedAtTheBeginningToSendAnotherMessage()"
});
formatter.result({
  "status": "skipped"
});
});