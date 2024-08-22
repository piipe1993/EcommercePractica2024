#language: es
Característica: CASO0031 Funcionamiento Correcto Politica Proteccion de Datos

  @CASO0031 @politicaProteccionDeDatos @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Politica Proteccion de Datos
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige a la Politica Proteccion de Datos Personales y Privacidad
    Entonces   el usuario valida el landing page de Politica Proteccion de Datos Personales y Privacidad




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@31_DataProteccionDeDatos
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



