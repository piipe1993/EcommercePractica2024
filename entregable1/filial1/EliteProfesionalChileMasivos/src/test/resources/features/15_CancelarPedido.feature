#language: es
Característica: CASO0015 Seguimiento Pedido

  @CASO0015 @CancelarPedido @EliteProfesional
  Esquema del escenario: Cancelar Pedido
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
   Cuando    el usuario se dirige a pedidos en Mi cuenta
    Y        el usuario busca el pedido "<numeroPedido>"
    Entonces el usuario solicita la cancelacion del pedido


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario | numeroPedido  |AgentId|
##@externaldata@./Data/DataElite.xlsx@DataCancelacionPedido
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |07075013   |robot_clm|


