package eliteprofessional.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.SeguimientoPedidosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class BuscarPedidoSeguimientoPedidoTask implements Task {

    String pedido;

    public BuscarPedidoSeguimientoPedidoTask(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


            actor.attemptsTo(
                    WaitUntil.the(INPUT_PEDIDO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(pedido).into(INPUT_PEDIDO),
                    Click.on(BTN_REALIZAR_SEGUIMIENTO),
                    WaitUntil.the(LBL_PEDIDO(pedido), isVisible()).forNoMoreThan(60).seconds()

            );

    }
    public static BuscarPedidoSeguimientoPedidoTask ir(String pedido) {

        return Instrumented.instanceOf(BuscarPedidoSeguimientoPedidoTask.class).withProperties(pedido);
    }
}