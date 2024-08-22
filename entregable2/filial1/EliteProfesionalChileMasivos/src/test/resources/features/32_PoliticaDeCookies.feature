#language: es
Característica: CASO0032 Funcionamiento Correcto Politica de Cookies

  @CASO0032 @politicaDeCookies @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Politica de Cookies
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige a la Politica de Cookies
    Entonces   el usuario valida el landing page de la Cookies




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@32_DataPoliticaDeCookies
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



