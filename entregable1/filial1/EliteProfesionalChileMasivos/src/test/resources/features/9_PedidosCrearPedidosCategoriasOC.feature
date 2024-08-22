#language: es
Característica: CASO0009 Crear Pedido desde Categorias adjuntando OC

  @CASO0009 @crearPedidoCategoriaOC @EliteProfesional @OC
  Esquema del escenario: Crear pedido a traves de Categoria adjuntando OC
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario selecciona "<categoria>" y "<subCategoria>"
    Y        el usuario agrega prodcutos a la compra "<cantidadPrimerProducto>" "<SKUPrimerProducto>"
    Y        el usuario aplica filtros "<filtro>" "<valorFiltro>"
    Y        el usuario ingresa al producto a comprar "<SKUSegundoProducto>" "<cantidadSegundoProducto>"
    Y        el usuario se dirige al carrito de compras
    Y        el usuario finaliza el proceso de compra adjuntando OC"<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario | categoria |subCategoria|cantidadPrimerProducto   |   SKUPrimerProducto    |    filtro   |  valorFiltro   | SKUSegundoProducto | cantidadSegundoProducto    |  numeroOC   |   comentarios   |    tipoEnvio  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataPedidoCategoriaOC
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |Papeles   |Toallas papel   |2   |40674   |Marca   |Elite   |40674   |3   |123456   |pedido   |Envío Programado   |robot_clm|


