package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OrdenRapidaMiCuentaUI extends PageObject {



    public static final Target BTN_ORDEN_RAPIDO= Target.the("Boton Orden Rapida").locatedBy("//a[@href='/my-account/quick-order'][ancestor::main]");

    public static final Target BTN_SUBIR_PLANTILLA= Target.the("Boton Subir Plantilla").locatedBy("//*[@id='mat-expansion-panel-header-3'][ancestor::main]");

    public static final Target CHK_TERMINOS_CONDICIONES= Target.the("CheckBox Terminos y Condiciones").locatedBy("//span[@class='mat-checkbox-inner-container']");

    public static final Target INPUT_PLANILLA = Target.the("Input para subir Planilla").locatedBy("//input[@type='file'][1]");

    public static final Target LBL_PLANILLA_FILE = Target.the("Label Planilla").locatedBy("//*[contains(text(),'Pedido.xls')]");

    public static final Target INPUT_OC_FILE = Target.the("Input para subir OC").locatedBy("(//input[@type='file'])[2]");

    public static final Target LBL_OC_FILE = Target.the("Label OC").locatedBy("//*[contains(text(),'OC.zip')]");

    public static final Target POPUP_ERROR = Target.the("PopUp Error").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");

    public static final Target BTN_CONFIRMAR= Target.the("Boton Confirmar").locatedBy(" //button[@class='quick-order__container-button__buttonConfirm ng-star-inserted']");

    public static final Target LBL_PEDIDO_EXITOSO = Target.the("Label Archivo Subido éxitosamente").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-success ng-star-inserted']]");

    public static final Target LOADING_BTN= Target.the("Cargando Archivo").locatedBy(" //button[@class='ng-star-inserted quick-order__container-button__buttonConfirm_disable']");


    public static final Target LINK_HISTORIAL_PEDIDOS= Target.the("Historial Pedidos Importados").locatedBy("//a[@class='quick-order__subtitle__a']");

    public static final Target LINK_ULTIMO_PEDIDO_IMPORTADO= Target.the("Link  Ultimo Pedido Importado").locatedBy("//a[@class='imported-orders__container__containerBody__data__a']");

    public static final Target TBL_DETALLES_PEDIDO_IMPORTADO= Target.the("Detalles Pedido Importado").locatedBy("//*[@class='borderTable']");

}
