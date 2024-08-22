#language: es
Característica: CASO0013 Crear Pedido producto bonificado  desde Mis Productos adjuntando OC

  @CASO0008 @crearPedidoBonificadoMisProductosOC @EliteProfesional @OC
  Esquema del escenario: Crear pedido producto bonificado a traves de Mis Productos adjuntando OC
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a  Mis Productos
    Y        el usuario agrega prodcutos bonificado a la compra "<cantidadPrimerProducto>" "<SKUPrimerProducto>"
    Y        el usuario aplica filtros "<filtro>" "<valorFiltro>"
    Y        el usuario ingresa al producto bonificado a comprar "<SKUSegundoProducto>" "<cantidadSegundoProducto>"
    Y        el usuario se dirige al carrito de compras
    Y        el usuario finaliza el proceso de compra adjuntando OC"<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |  cantidadPrimerProducto   |   SKUPrimerProducto    |    filtro   |  valorFiltro   | SKUSegundoProducto | cantidadSegundoProducto    |  numeroOC   |   comentarios   |    tipoEnvio  |AgentId|
##@externaldata@./Data/DataElite.xlsx@13_PedidoBonificadoMisProductos
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |264004   |150   |361179   |   |   |360970   |50   |123456   |pedido   |Envío Programado   |robot_pe|


