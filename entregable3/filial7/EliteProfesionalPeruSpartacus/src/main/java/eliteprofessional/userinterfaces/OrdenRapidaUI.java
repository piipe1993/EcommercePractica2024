package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrdenRapidaUI {

    public static final Target OPCION_BUSCAR_SKU = Target.the("Opcion Buscar SKU al realizar orden rapida").locatedBy("//mat-panel-title[text()=' Buscar SKU ']");
    public static final Target OPCION_REPETIR_PEDIDO = Target.the("Opcion repetir pedido realizar orden rapida").locatedBy("//mat-panel-title[text()=' Repetir pedido ']");
    public static final Target OPCION_SUBIR_PLANTILLA = Target.the("Opcion subir plantilla realizar orden rapida").locatedBy("//mat-panel-title[text()=' Subir Plantilla ']");
    public static final Target TXT_INGRESAR_SKU = Target.the("TextBox para ingresar el SKU deseado").locatedBy("//input[@placeholder='Ingrese el SKU']");
    public static final Target BTN_CONFIRMAR = Target.the("Boton Confirmar").located(By.className("cx-progress-button-container"));
    public static final Target TXT_CANTIDAD = Target.the("TextBox para Ingresar las cantidades deseadas para el SKU").locatedBy("//INPUT[@type='number']/self::INPUT");
    public static final Target TITULO_ORDEN_RAPIDA = Target.the("Elemento titulo orden rapida").locatedBy("//span[text()=' Orden Rápida ']");
    public static final Target ALERTA_CONFIRMACION_SIN_PRODUCTO = Target.the("Mnesaje de alerta al intentar confirmación sin añadir SKU").located(By.className("cx-message-text"));
    public static final Target TXT_NUMERO_PEDIDO = Target.the("Opcion para ingresar el numero de pedido en menu Orden rapida").located(By.id("repetirInputSearch"));
    public static final Target MENSAJE_PEDIDO_SELECCIONADO = Target.the("Mnesaje de confirmación pedido seleccionado").locatedBy("//span[text()=' Numero de pedido seleccionado: ']");
    public static final Target BTN_REPETIR = Target.the("Botón repetir pedido").located(By.className("repetirBtnRepetir"));
    public static final Target BTN_REPETIR_DISABLED = Target.the("Botón repetir pedido deshabilitado").located(By.className("repetirBtnRepetirDisabled"));
    public static final Target MENSAJE_ORDEN_REPETIDA = Target.the("Mnesaje de confirmación orden repetida con exito").locatedBy("//div[contains(@class,'boton-cerrar-dialog color-fuente-dialog')]//span[1]");

    public static final Target CHK_TERMINOS_CONDICIONES= Target.the("CheckBox Terminos y Condiciones").locatedBy("//span[@class='mat-checkbox-inner-container']");

    public static final Target INPUT_PLANILLA = Target.the("Input para subir Planilla").locatedBy("//input[@type='file'][1]");

    public static final Target LBL_PLANILLA_FILE = Target.the("Label Planilla").locatedBy("//*[contains(text(),'Pedido.xls')]");

    public static final Target INPUT_OC_FILE = Target.the("Input para subir OC").locatedBy("(//input[@type='file'])[2]");

    public static final Target LBL_OC_FILE = Target.the("Label OC").locatedBy("//*[contains(text(),'OC.zip')]");

    public static final Target POPUP_ERROR = Target.the("PopUp Error").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");

    public static final Target BTN_CONFIRMAR_PLANILLA= Target.the("Boton Confirmar").locatedBy(" //button[@class='quick-order__container-button__buttonConfirm ng-star-inserted']");

    public static final Target LBL_PEDIDO_EXITOSO = Target.the("Label Archivo Subido éxitosamente").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-success ng-star-inserted']]");

    public static final Target LOADING_BTN= Target.the("Cargando Archivo").locatedBy(" //button[@class='ng-star-inserted quick-order__container-button__buttonConfirm_disable']");


    public static final Target LINK_HISTORIAL_PEDIDOS= Target.the("Historial Pedidos Importados").locatedBy("//a[@class='quick-order__subtitle__a']");

    public static final Target LINK_ULTIMO_PEDIDO_IMPORTADO= Target.the("Link  Ultimo Pedido Importado").locatedBy("//a[@class='imported-orders__container__containerBody__data__a']");

    public static final Target TBL_DETALLES_PEDIDO_IMPORTADO= Target.the("Detalles Pedido Importado").locatedBy("//*[@class='borderTable']");

}
