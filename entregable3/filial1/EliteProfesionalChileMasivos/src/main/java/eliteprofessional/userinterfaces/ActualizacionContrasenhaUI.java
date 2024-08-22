package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ActualizacionContrasenhaUI extends PageObject {

    public static final Target INPUT_NUEVA_CONTRASENHA= Target.the("Campo Nueva Contraseña").locatedBy("//input[@formcontrolname='password']");
    public static final Target INPUT_CONFIRMAR_CONTRASENHA= Target.the("Campo Confirmar Contraseña").locatedBy("//input[@formcontrolname='passwordConfirm']");
    public static final Target BTN_ACTUALIZAR= Target.the("Boton Iniciar Sesion").locatedBy("//button[@class='btn btn-block btn-primary']");

}
