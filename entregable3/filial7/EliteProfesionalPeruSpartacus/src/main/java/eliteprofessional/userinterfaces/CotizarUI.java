package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class CotizarUI extends PageObject {

    public static final Target LBL_NUEVA_COTIZACION = Target.the("Boton Nueva Cotizacion").locatedBy("//button[@class='btn']");
    public static final Target LBL_LISTADO_COTIZACIONES = Target.the("Boton Listado Cotizaciones").locatedBy("//span[text()='Listado de Cotizaciones']");
    public static final Target BTN_ENVIAR = Target.the("Boton Enviar Cotizacion").locatedBy("//button[@class='boton-submit-dialog'][ancestor::div[@class='general d-none d-md-block']]");

    public static final Target INPUT_NOMBRE= Target.the("Campo Nombre").locatedBy("//input[@id='firstNameInput'][ancestor::div[@class='general d-none d-md-block']]");
    public static final Target INPUT_APELLIDO= Target.the("Campo Apellido").locatedBy("//input[@id='lastNameInput'][ancestor::div[@class='general d-none d-md-block']]");
    public static final Target INPUT_EMAIL= Target.the("Campo Email").locatedBy("//input[@id='emialInput'][ancestor::div[@class='general d-none d-md-block']]");
    public static final Target INPUT_TELEFONO= Target.the("Campo Telefono").locatedBy("//input[@id='telInput'][ancestor::div[@class='general d-none d-md-block']]");
    public static final Target INPUT_DESCRIPCION= Target.the("Campo Descripcion").locatedBy("//input[@formcontrolname='description'][ancestor::div[@class='general d-none d-md-block']]");
    public static final Target INPUT_PRODUCTO_INTERES= Target.the("Campo Productos de Interes").locatedBy("//input[@placeholder='Buscar Productos'][ancestor::div[@class='general d-none d-md-block']]");




    public static Target BTN_PRODUCTO_INTERES (String producto){
        return Target.the("Boton Producto de Interes "+ producto).locatedBy("//ul[@class='ul-list product ng-star-inserted'][(child::li[contains(text(),'"+ producto +"')]) and ancestor::div[@class='input_container ul-p-card']]");
    }

   public static final Target LBL_PRODUCTO_SELECCIONADO= Target.the("Etiqueta Producto Seleccionado").locatedBy("//div[@class='product'][ancestor::div[@class='productos ng-star-inserted']]");



    public static final Target POPPUP_COTIZACION_EXITOSA= Target.the("PopPup Cotizacion Exitosa").locatedBy("//p[contains(text(),'¡Enviada exitosamente!')][ancestor::div[@class='text-align-center']]");
    public static final Target BTN_CERRAR_COTIZACION_EXITOSA= Target.the("Boton Cerrar PopPup Cotizacion Exitosa").locatedBy("//span[contains(text(),'X')][ancestor::div[@class='boton-cerrar-dialog color-fuente-dialog']]");

    public static final Target BTN_LISTADO_COTIZACIONES_NUEVA = Target.the("Boton Nueva").locatedBy("//button[@class='btn'][ancestor::div[@class='center-content-wtable']]");

}
