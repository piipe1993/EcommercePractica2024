package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GmailUI extends PageObject {

    public static final Target BTN_ACCEDER= Target.the("Boton Acceder").locatedBy("//a[@href='https://accounts.google.com/AccountChooser/signinchooser?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser&ec=asw-gmail-globalnav-signin']");
    public static final Target INPUT_EMAIL= Target.the("Campo Email ").locatedBy("//input[@type='email']");
    public static final Target BTN_SIGUIENTE= Target.the("Boton Siguiente").locatedBy("(//span[@class='VfPpkd-vQzf8d'])[2]");
    public static final Target INPUT_CLAVE= Target.the("Campo Clave ").locatedBy("//input[@type='password']");
    public static final Target BTN_SIGUIENTE_CLAVE= Target.the("Boton Siguiente Clave").locatedBy("(//span[@class='VfPpkd-vQzf8d'])[2]");
    public static final Target INPUT_BUSCAR= Target.the("Campo Buscar Correo ").locatedBy("//input[@placeholder='Search mail']");

    public static Target BTN_RESULTADO_BUSQUEDA(String asunto){
        return Target.the("1er Resultado Busqueda:  "+ asunto).locatedBy("(//span[@class='bog'][descendant::span[contains(text(),'"+ asunto+"')]])[2]");
    }
    public static final Target BTN_EXPANDIR_CONTENIDO = Target.the("Boton Expandir Contenido").locatedBy("//div[@aria-label='Show trimmed content'][child::img]");
    public static final Target LINK_RECUPERACION = Target.the("Link Recuperacion").locatedBy("//a[contains(@href,'/login/')]");



}
