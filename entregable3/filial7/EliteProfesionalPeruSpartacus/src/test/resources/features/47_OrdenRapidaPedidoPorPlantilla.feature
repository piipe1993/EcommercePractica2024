#language: es
Característica: Orden rapida

  @CASO0047 @OrdenRapidaPlantilla @EliteProfesional
  Esquema del escenario:  Mi cuenta - Orden rapida generar pedido por planilla de carga
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario crea un pedido a traves de una plantilla en Orden Rapida
    Entonces el usuario verifica los detalles del pedido importado

    Ejemplos:
      | url                                                                                  | correo                      | clave     | idDestinatario | AgentId   |
##@externaldata@./Data/DataElite.xlsx@47_OrdenRapidaPorPlantilla
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe|
