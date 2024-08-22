#language: es
Característica: CASO0039 Mi cuenta - Accesos

  @CASO0039 @CrearUsuario @EliteProfesional
  Esquema del escenario: Crear nuevo usuario desde Mi cuenta - Opcion accesos
    Dado     que el usuario se encuentra logueado en la pagina "<url>" "<correo>" "<clave>" "<idDestinatario>" "<AgentId>"
    Cuando   el usuario ingresa a la opcion Accesos desde menu mi cuenta
    Y        Agrega un nuevo usuario llenando el formulario con los datos "<nombre>" "<apellido>" "<EmailUsuario>" "<Rol>"
    Entonces el usuario visualizara el "<EmailUsuario>" disponible en el listado





    Ejemplos:
      | url                                                                                    | correo                      | clave     | idDestinatario | AgentId   | nombre | apellido | EmailUsuario | Rol |
##@externaldata@./Data/DataElite.xlsx@39_CrearUsuario
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |julian.farias+26@avvale.com   |Compras01   |154631   |robot_pe   |Andres   |Nuevo User   |andrestest2@softys.com   |Administrador|

