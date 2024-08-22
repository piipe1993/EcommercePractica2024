#language: es
Característica: CASO0034 Funcionamiento Correcto de las Redes Sociales

  @CASO0034 @redesSociales @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto de las Redes SOciales
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario valida cada una de la redes Sociales




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@34_DataRedesSociales
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



