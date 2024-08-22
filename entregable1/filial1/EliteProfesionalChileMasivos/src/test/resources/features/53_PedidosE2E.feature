#language: es
Característica: CASO0053 Crear Pedido E2E adjuntando OC

  @CASO0053 @crearPedidoE2EOC @EliteProfesional @OC
  Esquema del escenario: Crear pedido E2E adjuntando OC
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
##@externaldata@./Data/DataElite.xlsx@DataPedidoE2EOC
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |40674;1681   |2;3   |40674;1681   |2;3   |2   |40674   |Marca   |Elite   |16810   |3   |Papeles   |Toallas papel   |2   |40674   |Marca   |Elite   |40674   |3   |123456   |pedido   |Envío Programado   |robot_clm|

