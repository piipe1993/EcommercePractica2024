#language: es
Característica: CASO0021 Funcionamiento Correcto Primer Carrusel

  @CASO0021 @funcionamientoPrimerCarrusel @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Primer Carrusel
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario Explora el Primer Carrusel "<SKU>"




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |SKU|
  ##@externaldata@./Data/DataElite.xlsx@21_DataPrimerCarrusel
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm   |50833;50980;40670;40638;50712;50682;50877;50875;50853;40674;79950;50501|



