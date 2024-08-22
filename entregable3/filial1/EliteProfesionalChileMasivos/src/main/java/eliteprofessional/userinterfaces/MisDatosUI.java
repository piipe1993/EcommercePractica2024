package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MisDatosUI {

    public static final Target CONTENIDO_LISTA_DATOS = Target.the("Valor campos lista de datos").located(By.className("codeBelow"));
    public static final Target LISTA_TITULOS_DATOS = Target.the("Lista Titulos campos ").locatedBy("//span[@class='code']");

}
