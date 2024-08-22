#language: es
Característica: CASO0044 Mi cuenta - Cotizaciones

  @CASO0044 @NuevaCotizacion @EliteProfesional
  Esquema del escenario: Crear nueva cotizacion desde Mi cuenta
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion nueva cotizacion desde menu mi cuenta
    Y        el usuario complete el formulario de cotización
      |  nombre     |    apellido    |    email   |  telefono   |   descripcion    |    productoInteres   |
      | <nombre>    |   <apellido>   |   <email>  | <telefono>  |  <descripcion>   |   <productoInteres>  |
    Entonces el usuario visualizara el mensaje de cotizacion exitosa


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |AgentId|  nombre   |   apellido    |    email   |  telefono   |   descripcion    |    productoInteres   |
  ##@externaldata@./Data/DataElite.xlsx@44_NuevaCotizacion
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |264004   |robot_pe   |Juan   |Perez   |softysrobots@gmail.com   |+56123456789   |To Rendipel Pro Dh 120m X1   |To Rendipel Pro Dh 120m X1|

