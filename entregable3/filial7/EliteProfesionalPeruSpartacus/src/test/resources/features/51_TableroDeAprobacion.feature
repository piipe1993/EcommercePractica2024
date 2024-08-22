#language: es
Característica: CASO0051 Mi cuenta - Aprobar pedido desde Mi cuenta - Opcion Aprobaciones

  @CASO0051 @TableroAprobacion
  Esquema del escenario: Aprobar pedido desde Mi cuenta - Opcion Aprobaciones
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Y        El usuario agrega un producto a la compra "<SKU>" "<cantidad>"
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Cuando   el usuario apruebe la orden desde el tablero de aprobaciones "<correoAprobador>" "<clave>"
    Y        que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces el usuario visualizara el estado aprobado del pedido





    Ejemplos:
      | url                                                                                    | correo                      | clave      | idDestinatario | AgentId    | SKU | cantidad | numeroOC | comentarios | tipoEnvio | correoAprobador|
##@externaldata@./Data/DataElite.xlsx@51_TableroAprobacion
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |360442   |2   |123456   |pedido   |Envío Programado   |aprobador+26@avvale.com|


