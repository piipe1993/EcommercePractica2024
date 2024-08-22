#language: es
Característica: CASO0048 Mi cuenta - Pedidos

  @CASO0048 @RepetirPedido @EliteProfesional
  Esquema del escenario: Repetir Pedido desde Mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Pedidos desde menu mi cuenta
    Y        el usuario busca el pedido "<numeroPedido>" y solicita repetirlo
    Y        el usuario finaliza el proceso de compra "<numeroOC>" "<comentarios>" "<tipoEnvio>"
    Entonces el usuario visualizara que su compra fue recibida exitosamente


    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | numeroPedido | numeroOC | comentarios | tipoEnvio |
##@externaldata@./Data/DataElite.xlsx@48_RepetirPedido
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |264004   |robot_pe   |07065070   |123456   |pedido   |Envío Programado|


