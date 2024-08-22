#language: es
Característica: CASO0033 Funcionamiento Correcto Centro de Ayuda

  @CASO0033 @centroDeAyuda @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Centro de Ayuda
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige al Centro de Ayuda
    Entonces   el usuario valida el landing page del Centro de Ayuda




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@33_DataCentroDeAyuda
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



