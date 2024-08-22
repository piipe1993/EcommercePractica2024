#language: es
Característica: CASO0025 Funcionamiento Correcto Quienes Somos

  @CASO0025 @funcionamientoQuienesSomos @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Quienes Somos
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando     el usuario se dirige a Quienes Somos
    Entonces   el usuario valida el landing page de la informacion de la empresa




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@25_DataQuienesSomos
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



