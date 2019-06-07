Feature: Silenciar conversacion
    Como usuario de la aplicación whatsapp de telefono Android
    quiero silenciar una conversacion
    para dejar de recibir notificaciones de audio y/o por pantalla cada vez que recibo un mensaje

  #Given - Dado que
  #When - Cuando
  #Then - Entonces

  Background:
    Given la aplicacion whatsapp esta en la pantalla inicial

  Scenario Outline: Silenciar conversacion desde pantalla inicial
    When  selecciona la conversacion "chat xyz" y presiona el icono "Silenciar"
    And   configura rango de tiempo <tiempo> y <mostrar> notificaciones en pantalla
    Then  nuevos mensajes son silenciados y <mostrar> se muestran en pantalla
    And   la conversacion queda silenciada mostrando el icono sin sonido

    Examples: #tiempo: rango de tiempo | 8H <8 horas> - 1W <1 semana> - 1Y <1 año>
              #mostrar: muestra por pantalla notificaciones | SI - NO
      | tiempo | mostrar |
      |   8H   |    SI   |
      |   1W   |    NO   |
      |   1Y   |    SI   |


  Scenario Outline: Silenciar mas de una conversacion en pantalla principal
    When  selecciona mas de una conversacion "chat xyz" "chat abc" y presiona el icono "Silenciar"
    And   configura rango de tiempo <tiempo> y <mostrar> notificaciones en pantalla
    Then  nuevos mensajes son silenciados y <mostrar> se muestran en pantalla
    And   las conversaciones quedan silenciadas mostrando el icono sin sonido

    Examples: #tiempo: rango de tiempo | 8H <8 horas> - 1W <1 semana> - 1Y <1 año>
              #mostrar: muestra por pantalla notificaciones | SI - NO
      | tiempo | mostrar |
      |   8H   |    SI   |
      |   1W   |    SI   |
      |   1Y   |    NO   |


  Scenario Outline: Silenciar conversacion mediante menu buscar
    Given se ha buscado la conversacion "chat xyz" a silenciar
    When  desplega menu de opciones y presiona "Silenciar notificaciones"
    And   configura rango de tiempo <tiempo> y <mostrar> notificaciones en pantalla
    Then  nuevos mensajes son silenciados y <mostrar> se muestran en pantalla
    And   en menu de opciones aparece "Desactivar silencio de notificaciones"

    Examples: #tiempo: rango de tiempo | 8H <8 horas> - 1W <1 semana> - 1Y <1 año>
              #mostrar: muestra por pantalla notificaciones | SI - NO
      | tiempo | mostrar |
      |   8H   |    SI   |
      |   1W   |    NO   |
      |   1Y   |    NO   |


  Scenario Outline: Silenciar conversacion al interior de conversacion
    Given me encuentro al interior de la conversacion "chat xyz" a silenciar
    When  desplega menu de opciones de conversacion y selecciona "Silenciar notificaciones"
    And   configura rango de tiempo <tiempo> y <mostrar> notificaciones en pantalla
    Then  nuevos mensajes son silenciados y <mostrar> se muestran en pantalla
    And   en opciones de conversacion aparece "Desactivar silencio de notificaciones"

    Examples: #tiempo: rango de tiempo | 8H <8 horas> - 1W <1 semana> - 1Y <1 año>
              #mostrar: muestra por pantalla notificaciones | SI - NO
      | tiempo | mostrar |
      |   8H   |    NO   |
      |   1W   |    SI   |
      |   1Y   |    SI   |