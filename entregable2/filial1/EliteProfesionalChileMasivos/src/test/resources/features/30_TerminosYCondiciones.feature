#language: es
Característica: CASO0030 Funcionamiento Correcto Terminos y Condiciones

  @CASO0030 @terminosYCondiciones @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Terminos y Condiciones
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige a Terminos y Condiciones
    Entonces   el usuario valida el landing page de Terminos y Condiciones




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@30_DataTerminosYCondiciones
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



