#language: es
Característica: CASO0001 Crear Cotizacion

  @CASO0001 @crearCotizacion @EliteProfesional
  Esquema del escenario: Crear cotizacion a traves de cotizador
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a  la opcion Cotizar
    Y        el usuario complete el formualrio de cotización
             |  nombre     |    apellido    |    email   |  telefono   |   descripcion    |    productoInteres   |
             | <nombre>    |   <apellido>   |   <email>  | <telefono>  |  <descripcion>   |   <productoInteres>  |
    Entonces el usuario visualizara el mensaje de cotizacion exitosa


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |  nombre   |   apellido    |    email   |  telefono   |   descripcion    |    productoInteres   |AgentId|
  ##@externaldata@./Data/DataElite.xlsx@DataCotizacionCotizador
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login?asm=true   |julian.farias+22@avvale.com   |Compras01   |154631   |Juan   |Perez   |softysrobots@gmail.com   |+56123456789   |Po Elite Bolsa 50/72   |Po Elite Bolsa 50/72   |robot_clm|


