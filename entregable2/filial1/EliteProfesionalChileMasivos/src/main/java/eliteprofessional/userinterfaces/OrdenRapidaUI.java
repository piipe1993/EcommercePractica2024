package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrdenRapidaUI {
    public static final Target OPCION_BUSCAR_SKU = Target.the("Opcion Buscar SKU al realizar orden rapida").locatedBy("//mat-panel-title[text()=' Pesquisar SKU ']");
    public static final Target OPCION_REPETIR_PEDIDO = Target.the("Opcion repetir pedido realizar orden rapida").locatedBy("//mat-panel-title[text()=' Comprar novamente ']");
    public static final Target OPCION_SUBIR_PLANTILLA = Target.the("Opcion subir plantilla realizar orden rapida").locatedBy("//mat-panel-title[text()=' Subir planilha ']");
    public static final Target TXT_INGRESAR_SKU = Target.the("TextBox para ingresar el SKU deseado").locatedBy("//input[@placeholder='Insira o SKU']");
    public static final Target BTN_CONFIRMAR = Target.the("Boton Confirmar").located(By.className("cx-progress-button-container"));
    public static final Target TXT_CANTIDAD = Target.the("TextBox para Ingresar las cantidades deseadas para el SKU").locatedBy("//INPUT[@type='number']/self::INPUT");
    public static final Target TITULO_ORDEN_RAPIDA = Target.the("Elemento titulo orden rapida").locatedBy("//span[text()=' Ordem rápida ']");
    public static final Target ALERTA_CONFIRMACION_SIN_PRODUCTO = Target.the("Mnesaje de alerta al intentar confirmación sin añadir SKU").located(By.className("cx-message-text"));
    public static final Target TXT_NUMERO_PEDIDO = Target.the("Opcion para ingresar el numero de pedido en menu Orden rapida").located(By.id("repetirInputSearch"));
    public static final Target MENSAJE_PEDIDO_SELECCIONADO = Target.the("Mensaje de confirmación pedido seleccionado").locatedBy("//span[text()=' Número do pedido selecionado: ']");
    public static final Target BTN_REPETIR = Target.the("Botón repetir pedido").located(By.className("repetirBtnRepetir"));
    public static final Target BTN_REPETIR_DISABLED = Target.the("Botón repetir pedido deshabilitado").located(By.className("repetirBtnRepetirDisabled"));
    public static final Target MENSAJE_ORDEN_REPETIDA = Target.the("Mnesaje de confirmación orden repetida con exito").locatedBy("//div[contains(@class,'boton-cerrar-dialog color-fuente-dialog')]//span[1]");
}