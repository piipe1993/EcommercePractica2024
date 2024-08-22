package eliteprofessional.tasks;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.CarritoDeComprasUI.*;
import static eliteprofessional.userinterfaces.OrdenRapidaUI.MENSAJE_ORDEN_REPETIDA;
import static eliteprofessional.userinterfaces.PedidosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RepetirPedidoMiCuentaTask implements Task {
    UtilsWaits utilsWaits= new UtilsWaits();


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(BTN_OPCIONES_PEDIDO).andAlignToBottom());
        actor.attemptsTo(Click.on(BTN_OPCIONES_PEDIDO));

        utilsWaits.wait(5);

        if (!BTN_REPETIR_PEDIDO.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" Para este pedido no se visualiza la opcion de 'Repetir pedido' verifique el estado actual de la orden")
                    .andContents(" Para este pedido no se visualiza la opcion de 'Repetir pedido' verifique el estado actual de la orden");
            Assert.fail(" Para este pedido no se visualiza la opcion de 'Repetir pedido' verifique el estado actual de la orden");
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_REPETIR_PEDIDO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_REPETIR_PEDIDO)
        );

        actor.attemptsTo(
                WaitUntil.the(MENSAJE_ORDEN_REPETIDA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENSAJE_ORDEN_REPETIDA)
        );

        actor.attemptsTo(
                WaitUntil.the(TITULO_PRODUCTO, isVisible()).forNoMoreThan(15).seconds(),
                Scroll.to(TITULO_PRODUCTO).andAlignToTop(),
                Scroll.to(TITULO_PRODUCTO),
                WaitUntil.the(CHECK_TERMINOS_COMPRA_RAPIDA, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(CHECK_TERMINOS_COMPRA_RAPIDA),
                Click.on(BTN_FINALIZAR_COMPRA)
        );

    }

    public static Performable ir () {
        return Instrumented.instanceOf(RepetirPedidoMiCuentaTask.class).withProperties();
    }
}
