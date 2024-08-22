#language: es
Característica: CASO0002 Crear Cotizacion desde Categorias

  @CASO0002 @crearCotizacionCategoria @EliteProfesional
  Esquema del escenario: Crear cotizacion a traves de un producto en su Categoria
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario selecciona "<categoria>" y "<subCategoria>" del producto de interes "<SKU>"
    Y        el usuario complete el formualrio de cotización sin agregar el producto
              |  nombre     |    apellido    |    email   |  telefono   |   descripcion    |
              | <nombre>    |   <apellido>   |   <email>  | <telefono>  |  <descripcion>   |
    Entonces el usuario visualizara el mensaje de cotizacion exitosa


    Ejemplos:
      | url                                                      | correo                            | clave   | idDestinatario |  nombre   |   apellido    |    email   |  telefono   |   descripcion    |categoria|subCategoria|SKU|AgentId|
##@externaldata@./Data/DataElite.xlsx@DataCotizacionCatalogo
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01   |154631   |Juan   |Perez   |softysrobots@gmail.com   |+56123456789   |Tp Elite Deco 20m X 2   |Papeles   |Pañuelos Desechables   |16562   |robot_clm|


