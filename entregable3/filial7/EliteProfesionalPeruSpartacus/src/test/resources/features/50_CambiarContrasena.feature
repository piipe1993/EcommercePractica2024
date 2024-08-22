#language: es
Característica: CASO0050 Mi cuenta - Cambiar contraseña

  @CASO0050 @CambiarContrasena
  Esquema del escenario: Cambiar contraseña de usuario desde Mi cuenta - Opcion Cambio de contraseña
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Cambiar Contrasena desde menu mi cuenta
    Y        diligencia el formulario con la clave anterior y la nueva "<clave>" "<nuevacontrasena>"
    Entonces el usuario visualizara el mensaje confirmando el cambio de contraseña





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | nuevacontrasena |
##@externaldata@./Data/DataElite.xlsx@50_CambiarContrasena
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |Compras01*|


