@whatsapp
Feature: F01 Funcionalidades Whatsapp 
    Yo como usuario quiero validar que  la busqueda de contactos whatsapp funcionen correctamente

    Scenario Outline: Validar envío correcto de mensaje
        Given Abro la aplicacion de whatsapp en el dispositivo movil para <CDP>
        When presiono boton de busqueda de contacto 
        And busco el nombre del contacto  <Contacto>
        And presiono sobre el contacto encontrado
        Then valido que el contacto encontrado sea el correcto <Contacto>
        Examples:
            | CDP                 | Contacto |
            | "F02_TC001_WSP"  | "User Test" |

