package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaInicioUI extends PageObject {

    public static final Target LBL_COTIZAR = Target.the("Menu Cotizar").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'cotizar')]]");
    public static final Target LBL_ORDEN_RAPIDA = Target.the("Menu Orden Rapida").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'orden rápida')]]");
    public static final Target LBL_SEGUIMINETO_PEDIDOS= Target.the("Menu Seguimiento Pedidos").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'Seguimiento pedidos')]]");

    public static final Target POPUP_COOKIES = Target.the("PopUp Cookies").locatedBy("//div[@class='container'][ancestor::app-cutom-cookies]");
    public static final Target BTN_ACEPTAR_COOKIES = Target.the("Boton Aceptar Cookies").locatedBy("//span[contains(text(),'ACEPTAR COOKIES')][ancestor::app-cutom-cookies]");

    public static final Target POPUP_DESTINATARIO = Target.the("PopUp Destinatario").locatedBy("//app-dialog-nav-btn[@class='ng-star-inserted'][ancestor::div[@class='cdk-overlay-container']]");
    public static final Target INPUT_DESTINATARIO= Target.the("Input Destinatario").locatedBy("//input[@class='inputDialogDir ng-pristine ng-invalid ng-touched'][ancestor::div[@class='cdk-overlay-container']]");
    public static final Target LBL_DESTINATARIO= Target.the("Valor ID Destinatario").locatedBy("(//span[@class='txtRender'][ancestor::div[@class='cdk-overlay-container']])[1]");
    public static final Target BTN_SELECCIONAR_DESTINATARIO= Target.the("Boton Seleccionar Destinatario").locatedBy("//span[@class='btnDest'][ancestor::div[@class='cdk-overlay-container']]");

    public static final Target BTN_CERRAR_SESION= Target.the("Boton Cerrar Sesion").locatedBy("//a[contains(text(),' Cerrar Sesion ')]");
    public static final Target BTN_CONFIRMACION_CERRAR_SESION= Target.the("Boton Confirmacion Cerrar Sesion").locatedBy("//a[@class='yes-btn-dialog'][ancestor::app-dialog-logout]");

    public static final Target INPUT_BUSCADOR= Target.the("Input Buscador").locatedBy("//input[@aria-describedby='initialDescription'][not(ancestor::*[@class='header-container'])]");
    public static final Target BTN_PRODUCTO_BUSCADO= Target.the("Boton Producto Buscado").locatedBy("(//a[@role='option'][ancestor::ul[@aria-label='resultados de productos']][not(ancestor::*[@class='header-container'])])[1]");

    public static final Target BTN_LINEA_CREDITO= Target.the("Boton Linea Credito").locatedBy("//a[@type='button'][(descendant::p[contains(text(),'LÍNEA DE CRÉDITO')]) and not(ancestor::*[@class='header-container'])]");
    public static final Target BTN_MI_CUENTA= Target.the("Boton Mi Cuenta").locatedBy("(//a[@class='no-decoration ng-star-inserted'][descendant::p[contains(text(),'MI CUENTA')]])[2]");
    public static final Target BTN_FAVORITOS= Target.the("Boton Favoritos").locatedBy("//a[descendant::p[contains(text(),'FAVORITOS')]]");
    public static final Target LBL_LISTA_DE_DESEOS= Target.the("Label Lista de Deseos").locatedBy("//span[contains(text(),'LISTA DE DESEOS')][ancestor::main]");

}
