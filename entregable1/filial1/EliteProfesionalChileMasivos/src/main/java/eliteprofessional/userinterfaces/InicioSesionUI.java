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

}
