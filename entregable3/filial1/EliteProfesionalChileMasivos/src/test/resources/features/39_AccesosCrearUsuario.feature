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
   |https://clmspa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/loginn   |julian.farias+22@avvale.com   |Compras01*   |154631   |robot_clm   |Andres   |Prueba2   |andrestest3@softys.com   |Administrador|


