#language: es
Característica: CASO0036 Mi cuenta - Mis datos

  @CASO0036 @MisDatos @EliteProfesional
  Esquema del escenario: Validacion Mis datos dentro menu mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Mis Datos desde menu mi cuenta
    Entonces el usuario visualizara todos sus datos





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   |
##@externaldata@./Data/DataElite.xlsx@36_MisDatos
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01*   |154631   |robot_clm|


