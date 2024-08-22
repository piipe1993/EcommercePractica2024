#language: es
Característica: Orden rapida

  @CASO0018 @OrdenRapidaRepetirPedido
  Esquema del escenario:  Orden rapida Crear un pedido por opcion repetir pedido
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando el usuario ingrese a la opcion orden rapida realizando la busqueda de producto por "<pedido>"
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente

    Ejemplos:
      | url                                                                                            | correo                      | clave     | idDestinatario | AgentId   | pedido    |numeroOC|comentarios|tipoEnvio|

##@externaldata@./Data/DataElite.xlsx@18_DataOrdenRapidaRepetirPedido
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm   |7067069   |123456   |pedido   |Envío Programado|

