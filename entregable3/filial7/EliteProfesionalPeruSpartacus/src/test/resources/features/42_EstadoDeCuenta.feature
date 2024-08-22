#language: es
Característica: CASO0042 Mi cuenta - Estado de Cuenta

  @CASO0042 @EstadoCuenta @EliteProfesional
  Esquema del escenario: Estado de Cuenta desde Mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Estado de Cuenta desde menu mi cuenta
    Entonces el usuario visualiza el estado de cuenta "<nDocumento>"





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | nDocumento |
##@externaldata@./Data/DataElite.xlsx@42_EstadoDeCuenta
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |01-FF01-01384685|


