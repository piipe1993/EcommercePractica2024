#language: es
Característica: CASO0035 Recuperar Contrasenha desde Olvide Mi Contrasenha

  @CASO0035 @RecuperarContrasenha @EliteProfesional
  Esquema del escenario: Recuperar Contrasenha Exitosamente desde Olvide Mi Contrasenha
    Dado     que el usuario se encuentra en la pagina "<url>"
    Cuando   el usuario Solicita correo de recuperacion en el Link Olvide Mi Contraseña "<correoRecuperacion>"
    Y        el usuario ingresa a Gmail para acceder al correo de recuperacion "<correoRecuperacion>" "<claveCorreoRecuperacion>" "<asuntoCorreoRecuperacion>"
    Y        el usuario cambia la contraseña "<nuevaClave>"
    Entonces el usuario inicia sesion con la nueva contraseña "<url>" "<nuevaClave>" "<correo>" "<idDestinatario>"





    Ejemplos:
      | url                                                                                    | correoRecuperacion| claveCorreoRecuperacion| asuntoCorreoRecuperacion| nuevaClave|  correo                      |idDestinatario|
##@externaldata@./Data/DataElite.xlsx@35_RecuperarContrasenha
   |https://pespa.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/login   |softysrobots@gmail.com    |Softys_2024+.   |Contraseña olvidada   |Compras01*   |julian.farias+26@avvale.com   |264004|


