package eliteprofessional.tasks;


import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.MiCuentaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class BuscarPedidoMiCuentaTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();
    public final String pedido;
    public static List<WebElementFacade> listaPedidos=new ArrayList<>();


    public BuscarPedidoMiCuentaTask(String pedido) {

        this.pedido = pedido;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_PEDIDOS, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_PEDIDOS)
        );

        actor.attemptsTo(
                WaitUntil.the(TBL_PEDIDOS, isVisible()).forNoMoreThan(30).seconds()
        );

        utilsWaits.wait(5);

        if (!BTN_LINKS_PEDIDOS.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontraron Pedidos para hacer segumiento ")
                    .andContents(" No se encontraron Pedidos para hacer segumiento ");
            Assert.fail(" No se encontraron Pedidos para hacer segumiento");
        }
        int numeroHojaTotal = 0;
        int numeroHojaActual = 1;
        if (BTN_PRIMERA_HOJA.isVisibleFor(actor)) {
            actor.attemptsTo(Click.on(BTN_ULTIMA_HOJA));
            actor.attemptsTo(WaitUntil.the(BTN_PEDIDOS, isClickable()).forNoMoreThan(30).seconds());
            utilsWaits.wait(5);
            numeroHojaTotal = Integer.parseInt(BTN_HOJA_SELECCIONADA.resolveFor(actor).getText());
            actor.attemptsTo(
                    Click.on(BTN_PRIMERA_HOJA),
                    WaitUntil.the(BTN_PEDIDOS, isClickable()).forNoMoreThan(30).seconds()
            );
            numeroHojaActual = Integer.parseInt(BTN_HOJA_SELECCIONADA.resolveFor(actor).getText());

        }

        listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        boolean pedidoExiste = false;

        while ((!pedidoExiste) && (numeroHojaActual<=numeroHojaTotal)) {
            int sizePedidos = listaPedidos.size();
            for (int j = 0; j < (sizePedidos); j++) {
                actor.attemptsTo(  Scroll.to(TBL_PEDIDOS).andAlignToTop());
                String textPedido = listaPedidos.get(j).getText();
                if (textPedido.contains(pedido)) {
                    pedidoExiste = true;
                    actor.attemptsTo(
                            Scroll.to(listaPedidos.get(j)).andAlignToBottom(),
                            Click.on(listaPedidos.get(j)),
                            WaitUntil.the(BTN_PEDIDOS, isClickable()).forNoMoreThan(30).seconds()
                    );

                    actor.attemptsTo(
                            WaitUntil.the(LBL_PEDIDO(pedido), isVisible()).forNoMoreThan(60).seconds(),
                            Scroll.to(LBL_PEDIDO(pedido)).andAlignToTop()

                    );
                    j = sizePedidos;

                }
            }
            if (BTN_HOJA_SELECCIONADA.isVisibleFor(actor)) {
                actor.attemptsTo(Click.on(BTN_SIGUIENTE_HOJA));
                utilsWaits.wait(2);
                actor.attemptsTo(WaitUntil.the(BTN_PEDIDOS, isClickable()).forNoMoreThan(30).seconds());

                numeroHojaActual = Integer.parseInt(BTN_HOJA_SELECCIONADA.resolveFor(actor).getText());
            }else{
                numeroHojaActual=+1;
            }
            listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        }

        if ((!pedidoExiste) ) {
            Serenity.recordReportData().withTitle(" No se encontró el Pedido: "+pedido)
                    .andContents(" No se encontró el Pedido: "+pedido);
            Assert.fail(" No se encontró el Pedido: "+pedido);
        }


    }
    public static Performable ir (String pedido) {
        return Instrumented.instanceOf(BuscarPedidoMiCuentaTask.class).withProperties(pedido);
    }
}