@whatsapp
Feature: F01 Funcionalidades Whatsapp 
    Yo como usuario quiero validar que los mensajes enviados por whatsapp funcionen correctamente

    Scenario Outline: Validar envío correcto de mensaje
        Given Abro la aplicacion de whatsapp en el dispositivo movil para <CDP>
        When selecciono un contacto random que tenga conectividad a internet
        And escribo el mensaje <Mensaje>
        And presiono enviar 
        Then valido que se envie correctamente el mensaje <Mensaje>
        Examples:
            | CDP                 | Mensaje |
            | "F01_TC001_WSP"  | "Hola como estás?" |

