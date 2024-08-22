#language: es
Característica: CASO0020 Explora las Categorias

  @CASO0020 @exploraLasCategorias @EliteProfesional
  Esquema del escenario: Explorar las Categorias
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario Explora las Categorias y Subcategorias "<categorias>"




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      | categorias   |
  ##@externaldata@./Data/DataElite.xlsx@20_DataExploraLasCategorias
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm   |Categoria:Papeles;Pañuelos Desechables;Papel Higiénico;Servilletas;Toallas papel;Trapero Humedo;Wipes;Categoria:Cuidado Bebé;Pañales;Toallas húmedas;Categoria:Higiene;Alcohol Gel;Jabón Barra;Jabon Líquido;Categoria:Protección Adultos;Apósitos;Pants;Pañales;Sabanillas y Toallas Húmedas;Toallas para Incontinencia Urinaria;Categoria:Protección Femenina;Protectores Diarios;Tampones;Toallas Higiénicas|



