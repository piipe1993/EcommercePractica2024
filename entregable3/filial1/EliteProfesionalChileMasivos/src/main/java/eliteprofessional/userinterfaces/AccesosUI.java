package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccesosUI {

    public static final Target BTN_AGREGAR_USUARIO = Target.the("Boton Agregar usuario - Opción Accesos").locatedBy("//button[@class='miEmpresaButton ng-star-inserted']");
    public static final Target LBL_NOMBRE_USUARIO = Target.the("Label para diligenciar nombre del nuevo usuario").locatedBy("//input[@formcontrolname='name']");
    public static final Target LBL_APELLIDO_USUARIO = Target.the("Label para diligenciar apellido del nuevo usuario").locatedBy("//input[@formcontrolname='lastName']");
    public static final Target LBL_EMAIL_USUARIO = Target.the("Label para diligenciar rol del nuevo usuario").locatedBy("//input[@formcontrolname='email']");
    public static final Target SELECT_ROL_USUARIO = Target.the("Selector Rol del nuevo usuario").locatedBy("//select[@formcontrolname='select']");
    public static final Target LISTA_USUARIOS = Target.the("Listado de usuarios creados dentro de la filial").located(By.className("miEmpresaEmail"));
    public static final Target LISTA_ROLES = Target.the("Listado de roles de cada usuario").located(By.className("miEmpresaSelect"));
    public static final Target ALERTA_USUARIO_EXISTENTE = Target.the("Mensaje de alerta indicando que el usuario ya existe").locatedBy("//span[text()='El usuario ya existe']/following-sibling::button");
    public static final Target ALERTA_EMAIL_INVALIDO = Target.the("Mensaje de alerta indicando que el email no es valido").locatedBy("//div[@class='invalid-feedback ng-star-inserted']//div[1]");
    public static final Target BTN_AGREGAR_USUARIO_FORMULARIO = Target.the("Boton Agregar usuario en el formulario").locatedBy("//button[text()='Agregar Usuario']");
    public static final Target LBL_BUSCAR_USUARIO = Target.the("Label para buscar usuario").locatedBy("//label[text()='BUSCAR: ']/following::input");
    public static final Target MENSAJE_CONFIRMACION_RESET_PWD = Target.the("Mensaje de confirmación reseteo de contraseña").locatedBy("//div[@class='text-align-center ng-star-inserted']//p[1]");
    public static final Target BTN_CERRAR_MENSAJE_RESET_PWD = Target.the("Botón para cerrar mensaje de confirmación reseteo de contraseña").locatedBy("//div[contains(@class,'boton-cerrar-dialog color-fuente-dialog')]//span[1]");
    public static final Target TOGGLE_ON_ACTIVACION_USUARIO = Target.the("Toggle habilitado para desactivar usuario").locatedBy("//i[@class='fa-solid fa-toggle-on']");
    public static final Target TOGGLE_OFF_ACTIVACION_USUARIO = Target.the("Toggle inhabilitado para activar usuario").locatedBy("//i[@class='fa-solid fa-toggle-off']");

    public static final Target OPCION_REESTABLECER_CONTRASENA = Target.the("opcion reestablecer contraseña").locatedBy("//i[@class='fa-solid fa-key']");

}
