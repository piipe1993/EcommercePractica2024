#language: es
Característica: Orden rapida

  @CASO0045 @OrdenRapidaPorSKU @EliteProfesional
  Esquema del escenario:  Orden rapida generar pedido busqueda por SKU
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando el usuario ingrese a la opcion orden rapida realizando la busqueda de producto por "<SKU>" con "<Cantidad>"
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente

    Ejemplos:
      | url                                                                                            | correo                      | clave     | idDestinatario | AgentId   | SKU   | Cantidad |numeroOC|comentarios|tipoEnvio|
##@externaldata@./Data/DataElite.xlsx@45_OrdenRapidaPorSKU
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01*   |154631   |robot_clm   |16572   |2   |123456   |pedido   |Envío Programado|
