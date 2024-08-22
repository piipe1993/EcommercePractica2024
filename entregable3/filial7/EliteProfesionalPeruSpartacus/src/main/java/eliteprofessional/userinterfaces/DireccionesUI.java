package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DireccionesUI {

    public static final Target LISTA_DIRECCIONES = Target.the("Lista con todas las direcciones del usuario").located(By.className("div-datos-address"));
    public static final Target LISTA_BOTONES_SELECCIONAR = Target.the("Lista de botones para seleccionar dirección").located(By.className("btn-azul-elite"));
    public static final Target DIRECCION_ACTUAL = Target.the("Campo dirección seleccionada por el usuario").locatedBy("(//div[@class='btnC']//span)[2]");

}
