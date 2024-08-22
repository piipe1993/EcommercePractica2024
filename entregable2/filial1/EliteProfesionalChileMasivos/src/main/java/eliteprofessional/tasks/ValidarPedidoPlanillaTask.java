package eliteprofessional.tasks;


import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.OrdenRapidaMiCuentaUI.LINK_ULTIMO_PEDIDO_IMPORTADO;
import static eliteprofessional.userinterfaces.OrdenRapidaMiCuentaUI.TBL_DETALLES_PEDIDO_IMPORTADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ValidarPedidoPlanillaTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {

        UtilsWaits.wait(5);

        actor.attemptsTo(
                WaitUntil.the(LINK_ULTIMO_PEDIDO_IMPORTADO, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.to(LINK_ULTIMO_PEDIDO_IMPORTADO).andAlignToBottom(),
                Click.on(LINK_ULTIMO_PEDIDO_IMPORTADO)
        );

        UtilsWaits.wait(5);

        actor.attemptsTo(
                WaitUntil.the(TBL_DETALLES_PEDIDO_IMPORTADO, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.to(TBL_DETALLES_PEDIDO_IMPORTADO).andAlignToBottom()
        );


    }

    public static Performable ir ( ){
        return Instrumented.instanceOf(ValidarPedidoPlanillaTask.class).withProperties();
    }
}