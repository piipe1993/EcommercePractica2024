package eliteprofessional.tasks;

import eliteprofessional.interactions.EsperaExplicita;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static eliteprofessional.userinterfaces.CarritoDeComprasUI.*;
import static eliteprofessional.userinterfaces.OrdenRapidaUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IngresarOrdenRapidaPorSku implements Task {

    String sku;
    String cantidad;

    public IngresarOrdenRapidaPorSku(String sku, String cantidad) {
        this.sku = sku;
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(sku).into(TXT_INGRESAR_SKU),
                EsperaExplicita.enSegundos(12),
                Enter.theValue(sku).into(TXT_INGRESAR_SKU).thenHit(Keys.ARROW_DOWN).thenHit(Keys.ENTER),
                EsperaExplicita.enSegundos(2)
        );

        if (!TXT_CANTIDAD.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontro el producto por lo cual no fue posible agregarlo, Por favor validar y/o modificar SKU ")
                    .andContents(" No se encontro el producto por lo cual no fue posible agregarlo, Por favor validar y/o modificar SKU ");
            Assert.fail(" No se encontro el producto por lo cual no fue posible agregarlo, Por favor validar y/o modificar SKU ");
        }

        actor.attemptsTo(
                Enter.theValue(cantidad).into(TXT_CANTIDAD),
                Click.on(BTN_CONFIRMAR),
                EsperaExplicita.enSegundos(5),
                Scroll.to(TITULO_PRODUCTO).andAlignToTop(),
                Scroll.to(TITULO_PRODUCTO),
                WaitUntil.the(CHECK_TERMINOS_COMPRA_RAPIDA, isClickable()).forNoMoreThan(2).seconds(),
                Click.on(CHECK_TERMINOS_COMPRA_RAPIDA),
                Click.on(BTN_FINALIZAR_COMPRA)
        );

    }

    public static IngresarOrdenRapidaPorSku conDatos(String sku, String cantidad){
        return instrumented(IngresarOrdenRapidaPorSku.class, sku, cantidad);
    }
}