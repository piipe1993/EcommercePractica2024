#language: es
Característica: CASO0028 Funcionamiento Correcto Novedades

  @CASO0028 @funcionamientoNovedades @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Novedades
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige a Novedades
    Entonces   el usuario valida el landing page de Novedades




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@28_DataNovedades
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



