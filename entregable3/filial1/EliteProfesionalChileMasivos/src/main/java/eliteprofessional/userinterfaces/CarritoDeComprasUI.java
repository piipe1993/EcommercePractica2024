package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class CarritoDeComprasUI extends PageObject {

    public static final Target BTN_CARRITO_COMPRAS = Target.the("Boton Carrito de Compras").locatedBy("//a[@type='button'][(preceding::p[contains(text(),'CARRITO')])and(ancestor::app-shopping-cart)]");
    public static final Target BTN_IR_PAGAR = Target.the("Boton Ir a Pagar").locatedBy("//button[@class='pagarBtn'][ancestor::mat-sidenav[@style='transform: none; visibility: visible;']]");
    public static final Target BTN_SEGUIR_COMPRANDO= Target.the("Boton Seguir Comprando").locatedBy("//button[@class='comprarBtn'][ancestor::mat-sidenav[@style='transform: none; visibility: visible;']]");
    public static final Target CHK_DECLARACION_TERMINOS_CONDICIONES= Target.the("CheckBox Terminos y Condiciones").locatedBy("//span[@class='mat-checkbox-inner-container'][ancestor::mat-checkbox[@id='mat-checkbox-1']]");
    public static final Target BTN_FINALIZAR_COMPRA = Target.the("Boton Finalizar Compra").locatedBy("//button[@class='pagarBtn'][ancestor::*[@class='purchaseSummaryContainer2']]");

    public static final Target POPUP_ERROR_FINALIZAR_COMPRA = Target.the("PopUp Error al Finalizar la compra").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");
    public static final Target TITULO_PRODUCTO = Target.the("Titulo del producto en el carrito").locatedBy("(//div[@class='titleProducto'])[3]");
    public static final Target CHECK_TERMINOS_COMPRA_RAPIDA = Target.the("CheckBox terminos y condiciones").locatedBy("(//SPAN[@class='mat-checkbox-inner-container'])[1]");

}
