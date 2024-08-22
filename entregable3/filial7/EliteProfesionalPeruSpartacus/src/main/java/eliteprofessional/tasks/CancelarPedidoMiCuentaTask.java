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

import static eliteprofessional.userinterfaces.PedidosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CancelarPedidoMiCuentaTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(BTN_OPCIONES_PEDIDO).andAlignToBottom());
        actor.attemptsTo(Click.on(BTN_OPCIONES_PEDIDO));

        utilsWaits.wait(5);

        if (!BTN_SOLICITAR_CANCELACION.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" Para este pedido no se visualiza la opcion de 'Cancelar' verifique si fue cancelado antes")
                    .andContents(" Para este pedido no se visualiza la opcion de 'Cancelar' verifique si fue cancelado antes");
            Assert.fail(" Para este pedido no se visualiza la opcion de 'Cancelar' verifique si fue cancelado antes");
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_SOLICITAR_CANCELACION, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SOLICITAR_CANCELACION)
        );

        actor.attemptsTo(
                WaitUntil.the(BTN_CONFIRMAR_CANCELACION, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONFIRMAR_CANCELACION)
        );

        actor.attemptsTo(
                WaitUntil.the(ALERT_PROCESANDO_CANCELACION, isVisible()).forNoMoreThan(30).seconds()
        );

    }
    public static Performable ir () {
        return Instrumented.instanceOf(CancelarPedidoMiCuentaTask.class).withProperties();
    }
}