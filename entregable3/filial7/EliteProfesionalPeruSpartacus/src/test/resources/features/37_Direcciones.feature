#language: es
Característica: CASO0037 Mi cuenta - Direcciones

  @CASO0037 @Direcciones @EliteProfesional
  Esquema del escenario: Validacion Direcciones dentro menu mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Direcciones desde menu mi cuenta
    Entonces el usuario podra visualizar el listado de direcciones y modificarlas





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   |
##@externaldata@./Data/DataElite.xlsx@37_Direcciones
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe|


