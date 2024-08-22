#language: es
Característica: CASO0023 Funcionamiento Correcto Carrusel Marcas

  @CASO0023 @funcionamientoCarruselMarcas @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Carrusel Marcas
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario Explora el Carrusel de Marcas




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |
##@externaldata@./Data/DataElite.xlsx@23_DataCarruselMarcas
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm|



