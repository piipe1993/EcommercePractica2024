#language: es
Característica: CASO0052 Cerrar Sesion

  @CASO0052 @salir
  Esquema del escenario: Cerrar Sesion
    Dado      que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando    el usuario se dirige a pedidos en Mi cuenta
    Entonces  el usuario cierra la sesion




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataSalir
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe|


