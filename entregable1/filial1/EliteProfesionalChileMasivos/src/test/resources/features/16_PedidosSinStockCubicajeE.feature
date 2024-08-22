#language: es
Característica: CASO0016 Crear Pedido Sin Stock Cubicaje

  @CASO0016 @crearPedidoSinStockCubicaje @EliteProfesional @OC
  Esquema del escenario: Crear pedido productos sin Stock
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario Busca Productos desde el Buscador "<SKUBuscador>" "<cantidadProductoBuscador>"
    Y        el usuario Agrega Productos a Mis Favoritos "<SKUFavoritos>"
    Y        el usuario agrega prodcutos a la compra "<SKUFavoritos>" "<cantidadProductoFavoritos>" en Mis Favoritos
    Y        el usuario ingresa a  Mis Productos
    Y        el usuario agrega prodcutos a la compra "<cantidadPrimerProductoMisProductos>" "<SKUPrimerProductoMisProductos>"
    Y        el usuario aplica filtros "<filtroMisProductos>" "<valorFiltroMisProductos>"
    Y        el usuario ingresa al producto a comprar "<SKUSegundoProductoMisProductos>" "<cantidadSegundoProductoMisProductos>"
    Y        el usuario selecciona "<categoria>" y "<subCategoria>"
    Y        el usuario agrega prodcutos a la compra "<cantidadPrimerProductoCategoria>" "<SKUPrimerProductoCategoria>"
    Y        el usuario aplica filtros "<filtroCategoria>" "<valorFiltroCategoria>"
    Y        el usuario ingresa al producto a comprar "<SKUSegundoProductoCategoria>" "<cantidadSegundoProductoCategoria>"
    Y        el usuario se dirige al carrito de compras
    Y        el usuario finaliza el proceso de compra adjuntando OC"<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |    SKUBuscador |    cantidadProductoBuscador    |    SKUFavoritos |cantidadProductoFavoritos|  cantidadPrimerProductoMisProductos   |   SKUPrimerProductoMisProductos    |    filtroMisProductos   |  valorFiltroMisProductos   | SKUSegundoProductoMisProductos | cantidadSegundoProductoMisProductos    | categoria |subCategoria| cantidadPrimerProductoCategoria   |   SKUPrimerProductoCategoria    |    filtroCategoria   |  valorFiltroCategoria   | SKUSegundoProductoCategoria | cantidadSegundoProductoCategoria    |   numeroOC   |   comentarios   |    tipoEnvio  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataPedidoSinStockCubicaje
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |16522;16522   |2;3   |16522;16522   |2;3   |2   |16522   |metraje   |21,6 x 14 cm   |16522   |3   |Papeles   |Pañuelos Desechables   |2   |16522   |metraje   |21,6 x 14 cm   |16522   |3   |123456   |pedido   |Envío Programado   |robot_clm|

