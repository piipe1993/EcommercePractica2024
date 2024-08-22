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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarOrdenRapidaRepetirPedido implements Task {

    String pedido;

    public IngresarOrdenRapidaRepetirPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_NUMERO_PEDIDO, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(pedido).into(TXT_NUMERO_PEDIDO),
                Click.on(BTN_REPETIR_DISABLED),
                Enter.theValue(pedido).into(TXT_NUMERO_PEDIDO).thenHit(Keys.TAB).thenHit(Keys.ENTER),
                EsperaExplicita.enSegundos(10),
                Enter.theValue(pedido).into(TXT_NUMERO_PEDIDO).thenHit(Keys.TAB).thenHit(Keys.ENTER),
                EsperaExplicita.enSegundos(2)
        );

        if (MENSAJE_PEDIDO_SELECCIONADO.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(BTN_REPETIR),
                    WaitUntil.the(MENSAJE_ORDEN_REPETIDA, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(MENSAJE_ORDEN_REPETIDA)
            );
        } else {
            Serenity.recordReportData().withTitle(" No se encontro el numero de pedido por lo cual no es posible repetir la orden, Por favor validar y/o modificar Nro pedido ")
                    .andContents(" No se encontro el numero de pedido por lo cual no es posible repetir la orden, Por favor validar y/o modificar Nro pedido ");
            Assert.fail(" No se encontro el numero de pedido por lo cual no es posible repetir la orden, Por favor validar y/o modificar Nro pedido ");
        }

        actor.attemptsTo(
                WaitUntil.the(TITULO_PRODUCTO, isVisible()).forNoMoreThan(15).seconds(),
                Scroll.to(TITULO_PRODUCTO).andAlignToTop(),
                Scroll.to(TITULO_PRODUCTO),
                WaitUntil.the(CHECK_TERMINOS_COMPRA_RAPIDA, isClickable()).forNoMoreThan(2).seconds(),
                Click.on(CHECK_TERMINOS_COMPRA_RAPIDA),
                Click.on(BTN_FINALIZAR_COMPRA)
        );

    }

    public static IngresarOrdenRapidaRepetirPedido conPedido(String pedido) {
        return instrumented(IngresarOrdenRapidaRepetirPedido.class, pedido);
    }
}