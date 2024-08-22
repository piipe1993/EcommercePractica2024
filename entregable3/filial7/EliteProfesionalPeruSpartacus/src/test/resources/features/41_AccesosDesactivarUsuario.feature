#language: es
Característica: CASO0041 Mi cuenta - Accesos

  @CASO0041 @BloquearAcceso @EliteProfesional
  Esquema del escenario: Desactivar usuario y bloquear acceso desde Mi cuenta - Opcion accesos
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Accesos desde menu mi cuenta
    Y        haga uso de la opcion desactivar usuario para el "<EmailUsuario>"
    Entonces se visualizara el usuario desactivado





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | EmailUsuario |
##@externaldata@./Data/DataElite.xlsx@41_BloquearAcceso
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |andrestest2@softys.com|


