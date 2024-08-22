#language: es
Característica: CASO0022 Funcionamiento Correcto Segundo Carrusel

  @CASO0022 @funcionamientoSegundoCarrusel @EliteProfesional
  Esquema del escenario: Funcionamiento Correcto Segundo Carrusel
    Dado       que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Entonces   el usuario Explora el Segundo Carrusel "<SKU>"




    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId      |SKU|
##@externaldata@./Data/DataElite.xlsx@22_DataSegundoCarrusel
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |robot_clm   |50980;77594;40674;22568;98243;17215;77154;77590;96105;77597;77153;98242|



