#language: es
Característica: CASO0019 Orden Rapida Pedido Planilla de Carga

  @CASO0019 @crearPedidoPlanillaDeCarga @EliteProfesional
  Esquema del escenario: Crear un pedido por planilla de Carga
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario se dirige a Mi cuenta
    Y        el usuario crea un pedido a traves de una planilla en Orden Rapida
    Entonces el usuario verifica los detalles del pedido importado


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId|
  ##@externaldata@./Data/DataElite.xlsx@19_CrearPedidoPlanillaDeCarga
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|


