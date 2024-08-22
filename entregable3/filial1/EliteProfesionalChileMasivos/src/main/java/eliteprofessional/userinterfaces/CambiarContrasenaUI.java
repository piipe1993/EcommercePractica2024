package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CambiarContrasenaUI {

    public static final Target LBL_CONTRASENA_ACTUAL = Target.the("Label para ingresar contraseña actual").located(By.name("oldPassword"));
    public static final Target LBL_CONTRASENA_NUEVA = Target.the("Label para ingresar contraseña Nueva").located(By.name("newPassword"));
    public static final Target LBL_CONFIRMAR_CONTRASENA_NUEVA = Target.the("Label para confirmar contraseña nueva").located(By.name("newPasswordConfirm"));
    public static final Target ALERT_CAMPO_VACIO = Target.the("Alerta que indica que el campo esta vacio y es requerido").locatedBy("//p[text()=' Este campo es requerido ']");
    public static final Target ALERT_CONTRASENA_INVALIDA = Target.the("Alerta que indica que la contraseña nueva NO es valida").locatedBy("//p[text()=' Esta contraseña no es válida ']");
    public static final Target BTN_GUARDAR = Target.the("Boton Guardar").locatedBy("//button[contains(@class,'btn btn-block')]");
    public static final Target OPCION_MOSTRAR_CONTRASENA = Target.the("Opcion para hacer visible la nueva contraseña ingresada").locatedBy("(//cx-password-visibility-toggle[@class='ng-star-inserted']//cx-icon)[3]");
    public static final Target MSJ_CAMBIO_EXITOSO = Target.the("Mensaje cambio de contraseña Exitoso").locatedBy("//div[contains(@class,'alert alert-success')]//button");


}
