package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EstadoDeCuentaUI {

    public static final Target LBL_ESTADO_DE_CUENTA = Target.the("Label Estado de Cuenta").locatedBy("//h1[text()='Estado de Cuenta']");

    public static final Target LBL_CREDITO_DISPONIBLE = Target.the("Label Credito Disponible").locatedBy("//span[text()=' Crédito Disponible ']");
    public static final Target LBL_VALOR_CREDITO_DISPONIBLE = Target.the("Label Valor Credito Disponible").locatedBy("//b[contains(text(),'S/')][parent::div[@class='textCredit textStyle']]");

    public static final Target LBL_TOTAL_A_PAGAR = Target.the("Label Total Credito").locatedBy("//span[text()='Total a pagar:']");
    public static final Target LBL_VALOR_TOTAL_A_PAGAR = Target.the("Label Valor Total Credito").locatedBy("(//b[contains(text(),'S/')][parent::div[@class='textStyle']])[2]");

    public static final Target LBL_SIGUIENTE_VENCIMIENTO = Target.the("Label Siguiente Vencimiento").locatedBy("//span[text()='Siguiente Vencimiento:']");

    public static final Target BTN_DESCARGAR_EXCEL = Target.the("Boton Descargar Excel").locatedBy("//button[@class='btn btnExcel']");

    public static final Target TBL_RESULTADOS = Target.the("Tabla Documentos").locatedBy("//table[@class='mat-table cdk-table']");


    public static final Target SLT_FILTRAR_POR = Target.the("Select Filtrar por").locatedBy("//select[@formcontrolname='filterByKey']");

    public static final Target INPUT_DOCUMENTO = Target.the("Input Numero Documento").locatedBy("//input[@formcontrolname='filterByValue']");

    public static final Target BTN_BUSCAR = Target.the("Boton Buscar").locatedBy("(//button[@class='btnBuscar btnBuscarText'])[2]");

    public static final Target LBL_SIN_FACTURAS = Target.the("Label No hay Facturas Disponibles").locatedBy("//td[text()='No hay facturas disponibles']");

    public static Target LBL_DOCUMENTO_RESULTADO(String documento){
        return Target.the("Label Documento:  "+ documento).locatedBy("//td[contains(text(),'"+ documento +"')]");
    }
}
