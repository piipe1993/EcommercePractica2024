#language: es
Característica: CASO0007 Crear Pedido desde Favoritos

  @CASO0007 @crearPedidoMisFavoritos @EliteProfesional
  Esquema del escenario: Crear pedido a traves de Favoritos
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario Agrega Productos a Mis Favoritos "<SKU>"
    Y        el usuario agrega prodcutos a la compra "<SKU>" "<cantidadProducto>" en Mis Favoritos
    Y        el usuario se dirige al carrito de compras
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |  cantidadProducto    |    SKU  |  numeroOC   |   comentarios   |    tipoEnvio  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataPedidoMisFavoritos
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |2;3   |40674;1681   |123456   |pedido   |Envío Programado   |robot_clm|
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login?asm=true   |julian.farias+22@avvale.com   |Compras01   |154631   |2;3   |40674;1681   |123456   |pedido   |Envío Programado   |robot_clm|


