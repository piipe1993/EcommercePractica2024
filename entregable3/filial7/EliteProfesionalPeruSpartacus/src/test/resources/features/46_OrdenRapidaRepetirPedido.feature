#language: es
Característica: Orden rapida

  @CASO0046 @OrdenRapidaRepetirPedido @EliteProfesional
  Esquema del escenario:  Orden rapida Crear un pedido por opcion repetir pedido
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingrese a la opcion orden rapida repitiendo la orden "<pedido>"
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente

    Ejemplos:
      | url                                                                                            | correo                      | clave     | idDestinatario | AgentId   | pedido    |numeroOC|comentarios|tipoEnvio|
##@externaldata@./Data/DataElite.xlsx@46_OrdenRapidaRepetirPedido
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |7066087   |123456   |pedido   |Envío Programado|
