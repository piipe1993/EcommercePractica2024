package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FinalizacionCompraUI extends PageObject {

    public static final Target BTN_PROCESAR_PEDIDO = Target.the("Boton Procesar Pedido").locatedBy("//div[@class='processOrder']");
    public static final Target BTN_ENVIO_NORMAL = Target.the("Boton Envio Normal").locatedBy("//button[@id='normalButton']");
    public static final Target BTN_ENVIO_PROGRAMADO = Target.the("Boton Envio Programado").locatedBy("//button[@id='programmedButton']");
    public static final Target SLT_HORARIO_ENTREGA = Target.the("Boton Envio Programado").locatedBy("//select[@id='my-select']");


    public static final Target BTN_CALENDARIO = Target.the("Boton Abrir Calendario").locatedBy("//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted']");
    public static final Target BTN_DIA_HABILITADO_CALENDARIO = Target.the("Proximo Dia Hanilitado Calendario ").locatedBy("(//button[@class='mat-calendar-body-cell'])[1]");



    public static final Target INPUT_OC = Target.the("Campo OC").locatedBy("//textarea[@placeholder='Número OC']");
    public static final Target INPUT_COMENTARIOS = Target.the("Campo Comentarios").locatedBy("//textarea[@placeholder='Observações de entrega, nome de contato, telefone, etc.']");

    public static final Target LBL_COMPRA_RECIBIDA= Target.the("Etiqueta Compra Recibida").locatedBy("//div[@class='purchaseLine' and contains(text(),'Compra Recebida')]");

    public static final Target BTN_IR_AL_INICIO = Target.the("Boton Ir al Inicio").locatedBy("//div[@class='return']");

    public static final Target POPUP_ERROR_PROCESAR_PEDIDO = Target.the("PopUp Error al Procesar compra").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");
    public static final Target BTN_PROXIMO_MES = Target.the("Boton Proximo Mes").locatedBy("//button[@aria-label='Next month']");

}

