#language: es
Característica: CASO0024 Funcionamiento Correcto Carrusel Categorias

  @CASO0024 @funcionamientoCarruselCategorias @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Carrusel Categorias
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario Explora el Carrusel de Categorias "<categorias>"




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      | categorias   |
##@externaldata@./Data/DataElite.xlsx@24_DataCarruselCategorias
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm   |Papeles;Cuidado Bebé;Higiene;Protección Adultos;Protección Femenina|



