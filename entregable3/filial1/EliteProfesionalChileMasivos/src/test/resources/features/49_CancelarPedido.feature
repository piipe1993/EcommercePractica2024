#language: es
Característica: CASO0049 Mi cuenta - Pedidos

  @CASO0049 @CancelarPedido @EliteProfesional
  Esquema del escenario: Cancelar Pedido desde Mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Pedidos desde menu mi cuenta
    Y        el usuario busca el pedido "<numeroPedido>"
    Y        el usuario solicita la cancelacion del pedido
    Entonces   el usuario visualizara el mensaje confirmando la cancelacion


    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | numeroPedido |
##@externaldata@./Data/DataElite.xlsx@49_CancelacionPedido
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01*   |154631   |robot_clm   |07155021|


