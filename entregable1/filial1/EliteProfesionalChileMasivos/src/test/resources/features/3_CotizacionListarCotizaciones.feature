#language: es
Característica: CASO0003 Listar Cotizaciones

  @CASO0003 @listarCotizaciones @EliteProfesional
  Esquema del escenario: Listar Cotizaciones
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a  la opcion Cotizar y listara la cotizaciones
    Entonces el usuario visualizara las cotizaciones





    Ejemplos:
   | url                                                      | correo                            | clave   | idDestinatario |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataListarCotizaciones
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|


