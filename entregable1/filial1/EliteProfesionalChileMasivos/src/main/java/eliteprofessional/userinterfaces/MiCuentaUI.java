package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MiCuentaUI extends PageObject {

    public static final Target BTN_MIS_DATOS= Target.the("Boton Mis Datos").locatedBy("//a[contains(text(),'Mis Datos')][ancestor::main]");
    public static final Target BTN_PEDIDOS= Target.the("Boton Pedidos").locatedBy("//a[contains(text(),'Pedidos')][ancestor::main]");
    public static final Target TBL_PEDIDOS= Target.the("Tabla Pedidos").locatedBy("//*[@class='containerTablePedidos ng-star-inserted']");
    public static final Target BTN_SALIR= Target.the("Boton Salir").locatedBy("//a[@class='logout-my-account'][ancestor::app-account-menu]");


    public static final Target BTN_LINKS_PEDIDOS= Target.the("Botones Pedidos").locatedBy("//td[@class='nroPedido']");
    public static final Target BTN_HOJA_SELECCIONADA= Target.the("Botones Hoja de Resultados Actual").locatedBy("//span[@class='pagSelected ng-star-inserted'] | //span[@class='ng-star-inserted pagSelected']");
    public static final Target BTN_PRIMERA_HOJA= Target.the("Boton Primera Hoja de Resultados ").locatedBy("(//*[@class='containerSvg'])[1]");
    public static final Target BTN_ULTIMA_HOJA= Target.the("Boton Ultima Hoja de Resultados").locatedBy("(//*[@class='containerSvg'])[2]");
    public static final Target BTN_SIGUIENTE_HOJA= Target.the("Boton  Hoja Siguiente").locatedBy("(//*[@fill='none'][parent::*[@class='paginate']])[2]");


    public static Target LBL_PEDIDO (String pedido){
        return Target.the("Label Seguimiento Pedido "+ pedido).locatedBy("//span[contains(text(),'Pedido N° "+ pedido +"')]");
    }

    public static final Target BTN_OPCIONES_PEDIDO= Target.the("Boton  Opciones Pedido").locatedBy("//span[@class='menuOpciones']");
    public static final Target BTN_SOLICITAR_CANCELACION= Target.the("Boton  Solicitar Cancelacion").locatedBy("//li[@class='ng-star-inserted'][ancestor::*[@class='containerDataSelect']]");
    public static final Target BTN_CONFIRMAR_CANCELACION= Target.the("Boton  Confirmar Cancelacion").locatedBy("//button[@class='alertConfirmar']");
    public static final Target ALERT_PROCESANDO_CANCELACION= Target.the("Alerta Procesando Cancelacion").locatedBy("//span[contains(text(),'Su pedido esta siendo procesado para su cancelación')]");

}
