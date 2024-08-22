#language: es
Característica: CASO0040 Mi cuenta - Accesos

  @CASO0040 @ResetearContrasena @EliteProfesional
  Esquema del escenario: Reestablecer contraseña de usuario desde Mi cuenta - Opcion accesos
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Accesos desde menu mi cuenta
    Y        haga uso de la opcion restablecer contrasena para el "<EmailUsuario>"
    Entonces el usuario visualizara el mensaje confirmando el envio del correo





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | EmailUsuario |
##@externaldata@./Data/DataElite.xlsx@40_ResetearContrasena
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |andrestest2@softys.com|


