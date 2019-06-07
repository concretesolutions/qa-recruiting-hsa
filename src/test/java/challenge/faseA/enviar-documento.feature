Feature: Enviar documentos
  Como usuario de la aplicación whatsapp de telefono Android
  quiero adjuntar documentos a una conversacion
  para compartir archivos que tengo en el telefono

  #Given - Dado que
  #When - Cuando
  #Then - Entonces

  Background:
    Given me encuentro en la conversacion "chat xyz"

  Scenario Outline: Adjuntar un documento a la conversacion
    When se selecciona la opcion de adjuntar documento
    And  envio un <documento>
    Then se muestra recuadro que indica nombre documento y progreso de envio
    And  al finalizar el envio permite descargar el documento

    Examples: #documento: formato de documento a adjuntar
      | documento |
      |    pdf    |
      |    doc    |
      |    rar    |


  Scenario Outline: Cancelar envio de documento a la conversacion
    When se selecciona la opcion de adjuntar documento
    And  envio un <documento>
    And  presiona el progreso del envio para cancelarlo
    Then el envio se cancela y permite en el mensaje volver a enviarlo

    Examples: #documento: formato de documento a adjuntar
      | documento |
      |    rar    |


  Scenario: Adjuntar mas de un documento a la conversacion
    When se selecciona la opcion de adjuntar documento
    And  envio mas de un documento
    Then se muestra recuadro que indica nombre y progreso del envio en cada uno
    And  al finalizar el envio permite descargar cada documento


  Scenario: Adjuntar documento superior a 99MB
    When se selecciona la opcion de adjuntar documento
    And  se envia un documento superior a 99MB
    Then se cancela el envio con mensaje de error "mensaje"