package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionUI extends PageObject {

    public static final Target INPUT_EMAIL= Target.the("Campo Email").locatedBy("//input[@formcontrolname='userId']");
    public static final Target INPUT_CONTRASENHA= Target.the("Campo Contraseña").locatedBy("//input[@formcontrolname='password']");
    public static final Target BTN_INICIAR_SESION= Target.the("Boton Iniciar Sesion").locatedBy("//button[@class='btn btn-block btn-primary']");

    //Elementos inicio de sesión con User Asm
    public static final Target TXT_AGENTID = Target.the("TextBox para ingreso del AgentId").locatedBy("//input[@placeholder='Agent ID']");
    public static final Target TXT_PASSWORD = Target.the("TextBox para ingreso del Password").locatedBy("//input[@placeholder='Password']");
    public static final Target BTN_SIGIN = Target.the("Boton SignIn").locatedBy("//BUTTON[@type='submit'][text()=' Sign In ']/self::BUTTON");
    public static final Target TXT_CUSTOMER_EMAIL = Target.the("TextBox para ingreso del Email o nombre del cliente").locatedBy("//input[@placeholder='Customer Name/Email Address']");
    public static final Target BTN_START_SESION = Target.the("Boton para iniciar la sesion del cliente").locatedBy("//BUTTON[@type='submit'][text()=' Start Session ']/self::BUTTON");
    public static final Target RESULTADO_BUSQUEDA_CUSTOMER = Target.the("Lista de resultados luego de buscar el email del cliente").located(By.className("result-id"));

    public static final Target LINK_OLVIDE_CONTRASENHA= Target.the("Link Olvide Mi contraseña").locatedBy("//div[@class='forgotten-password ng-star-inserted']");
    public static final Target POPUP_OLVIDE_CONTRASENHA= Target.the("PopUp Olvide Mi contraseña").locatedBy("//mat-dialog-container[@id='mat-dialog-2']");
    public static final Target INPUT_EMAIL_OLVIDE_CONTRASENHA= Target.the("Campo Email PopUp Olvide Mi contraseña").locatedBy("//input[@formcontrolname='email']");
    public static final Target BTN_ENVIAR_CORREO_RECUPERACION= Target.the("Boton Enviar Correo de Recuperacion").locatedBy("//button[@class='fw-container-dialog__button']");
    public static final Target ALERTA_CORREO_ENVIADO= Target.the("MSN Correo Enviado").locatedBy("//span[text()='Mensaje enviado. Por favor, revisa tu bandeja de entrada para restablecer tu contraseña.']");

}
