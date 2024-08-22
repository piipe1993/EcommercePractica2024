#language: es
Característica: CASO0043 Mi cuenta - Cotizaciones

  @CASO0043 @listadoCotizaciones @EliteProfesional
  Esquema del escenario: Listar Cotizaciones desde Mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Cotizaciones desde menu mi cuenta
    Entonces el usuario visualizara el listado de cotizaciones





    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId|
##@externaldata@./Data/DataElite.xlsx@43_ListadoCotizaciones
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe|


