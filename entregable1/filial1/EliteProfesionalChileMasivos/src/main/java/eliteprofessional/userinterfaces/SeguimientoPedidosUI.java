package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SeguimientoPedidosUI extends PageObject {

    public static final Target INPUT_PEDIDO= Target.the("Campo Pedido").locatedBy("//input[@placeholder='EJEMPLO: 9999999999-01']");
    public static final Target BTN_REALIZAR_SEGUIMIENTO= Target.the("Boton Realizar Seguimiento").locatedBy("//button[@class='buttonTrack']");


    public static Target LBL_PEDIDO (String pedido){
        return Target.the("Label Seguimiento Pedido "+ pedido).locatedBy("//span[contains(text(),'Pedido N° "+ pedido +"')]");
    }

}
