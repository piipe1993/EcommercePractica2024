#language: es
Característica: CASO0014 Seguimiento Pedido

  @CASO0014 @seguimientoPedido @EliteProfesional
  Esquema del escenario: Hacer Seguimiento Pedido
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
   Cuando    el usuario ingresa a  la opcion Seguimiento Pedidos
    Y        el usuario busca el pedido "<numeroPedido>" para visualizar su estado
    Y        el usuario se dirige a pedidos en Mi cuenta
    Y        el usuario busca el pedido "<numeroPedido>"
    Entonces el usuario visualizara el estado de su Pedido "<numeroPedido>"

    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario | numeroPedido  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataSeguimientoPedido
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |07065054   |robot_clm|


