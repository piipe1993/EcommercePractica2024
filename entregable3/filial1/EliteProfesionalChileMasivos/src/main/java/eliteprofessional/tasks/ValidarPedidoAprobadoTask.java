package eliteprofessional.tasks;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.PaginaInicioUI.OPCION_MI_CUENTA;
import static eliteprofessional.userinterfaces.PedidosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarPedidoAprobadoTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();
    public static List<WebElementFacade> listaPedidos=new ArrayList<>();
    public static List<WebElementFacade> listaEstadoPedidos=new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        utilsWaits.wait(30);

        actor.attemptsTo(
                WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_MI_CUENTA),
                WaitUntil.the(OPCION_PEDIDOS, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_PEDIDOS)
        );

        actor.attemptsTo(
                WaitUntil.the(TBL_PEDIDOS, isVisible()).forNoMoreThan(30).seconds()
        );

        utilsWaits.wait(5);

        if (!BTN_LINKS_PEDIDOS.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontraron Pedidos para hacer seguimiento ")
                    .andContents(" No se encontraron Pedidos para hacer seguimiento ");
            Assert.fail(" No se encontraron Pedidos para hacer seguimiento");
        }


        String PedidoRecall = actor.recall("Pedido");
        System.out.println("Pedido Recall by Actor - Login Usuario principal= " + PedidoRecall);

        listaEstadoPedidos = LISTADO_ESTADOS_PEDIDOS.resolveAllFor(actor);
        listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        boolean pedidoExiste = false;

        while ((!pedidoExiste)) {
            int sizePedidos = listaPedidos.size();
            for (int j = 0; j < (sizePedidos); j++) {
                actor.attemptsTo(  Scroll.to(TBL_PEDIDOS).andAlignToTop());
                String textPedido = listaPedidos.get(j).getText();
                if (textPedido.contains(PedidoRecall)) {
                    pedidoExiste = true;
                    actor.attemptsTo(
                            Scroll.to(listaPedidos.get(j)).andAlignToBottom()
                    );
                    String estadoPedidoEncontrado = listaEstadoPedidos.get(j).getText();
                    System.out.println("Estado del pedido " + PedidoRecall + " Es igual a " + estadoPedidoEncontrado);

                    if(estadoPedidoEncontrado.contains("SOLICITUD DE COMPRA") || estadoPedidoEncontrado.contains("APROBADO")  ){
                        Serenity.takeScreenshot();
                        Serenity.recordReportData().withTitle("El estado actual para el pedido = " + PedidoRecall + " es= " + estadoPedidoEncontrado )
                                .andContents("El estado actual para el pedido = " + PedidoRecall + " es= " + estadoPedidoEncontrado );
                    } else{
                        Serenity.takeScreenshot();
                        Serenity.recordReportData().withTitle("Flujo fallido ya que el estado actual del pedido " + PedidoRecall + " Es = " + estadoPedidoEncontrado )
                                .andContents("Flujo fallido ya que el estado actual del pedido " + PedidoRecall + " Es = " + estadoPedidoEncontrado );
                        Assert.fail("Flujo fallido ya que el estado actual del pedido " + PedidoRecall + " Es = " + estadoPedidoEncontrado);
                    }

                    j = sizePedidos;

                }
            }

            listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        }

        if ((!pedidoExiste) ) {
            Serenity.recordReportData().withTitle(" No se encontró el Pedido: "+ PedidoRecall)
                    .andContents(" No se encontró el Pedido: "+ PedidoRecall);
            Assert.fail(" No se encontró el Pedido: "+ PedidoRecall);
        }

    }

    public static ValidarPedidoAprobadoTask enTablaPedidos() {
        return instrumented(ValidarPedidoAprobadoTask.class);
    }
}
