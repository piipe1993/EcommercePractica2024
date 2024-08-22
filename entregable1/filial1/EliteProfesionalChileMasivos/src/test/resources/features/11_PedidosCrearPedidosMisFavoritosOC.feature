#language: es
Característica: CASO0011 Crear Pedido desde Favoritos adjuntando OC

  @CASO0011 @crearPedidoMisFavoritosOC @EliteProfesional @OC
  Esquema del escenario: Crear pedido a traves de Favoritos adjuntando OC
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario Agrega Productos a Mis Favoritos "<SKU>"
    Y        el usuario agrega prodcutos a la compra "<SKU>" "<cantidadProducto>" en Mis Favoritos
    Y        el usuario se dirige al carrito de compras
    Y        el usuario finaliza el proceso de compra adjuntando OC"<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |  cantidadProducto    |    SKU  |  numeroOC   |   comentarios   |    tipoEnvio  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataPedidoMisFavoritosOC
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |2;3   |40674;1681   |123456   |pedido   |Envío Programado   |robot_clm|


