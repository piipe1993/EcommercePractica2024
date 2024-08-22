package eliteprofessional.tasks;


import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.FinalizacionCompraUI.*;
import static eliteprofessional.userinterfaces.InicioSesionUI.*;
import static eliteprofessional.userinterfaces.MiCuentaUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.BTN_SALIR;
import static eliteprofessional.userinterfaces.PedidosUI.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AprobarOrdenTask implements Task {


    String correoAprobador;
    String clave;

    public static List<WebElementFacade> listaPedidos = new ArrayList<>();
    public static List<WebElementFacade> listaBtnAprobar = new ArrayList<>();

    public AprobarOrdenTask(String correoAprobador, String clave) {
        this.correoAprobador = correoAprobador;
        this.clave = clave;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String numeroPedido = LBL_NUMERO_PEDIDO.resolveFor(actor).getText().substring(17, 25);
        System.out.println("Número pedido capturado al finalizar la compra= " + numeroPedido);
        actor.remember("Pedido", numeroPedido);

        UtilsWaits.wait(10);

        actor.attemptsTo(
                WaitUntil.the(OPCIÓN_VER_PEDIDO_GENERADO, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(OPCIÓN_VER_PEDIDO_GENERADO),
                WaitUntil.the(BTN_SALIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SALIR),
                WaitUntil.the(BTN_CONFIRMACION_CERRAR_SESION, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONFIRMACION_CERRAR_SESION),
                WaitUntil.the(BTN_INICIAR_SESION, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_INICIAR_SESION, isClickable()).forNoMoreThan(30).seconds(),
                Enter.theValue(correoAprobador).into(INPUT_EMAIL),
                Enter.theValue(clave).into(INPUT_CONTRASENHA),
                Click.on(BTN_INICIAR_SESION),
                WaitUntil.the(BTN_INICIAR_SESION, isNotVisible()).forNoMoreThan(60).seconds()
        );

        if (BTN_ACEPTAR_COOKIES.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(BTN_ACEPTAR_COOKIES),
                    WaitUntil.the(POPUP_COOKIES, isNotVisible()).forNoMoreThan(30).seconds()
            );
        }

        UtilsWaits.wait(15);

        actor.attemptsTo(
                WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_MI_CUENTA),
                WaitUntil.the(OPCION_APROBACIONES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_APROBACIONES)
        );

        //INICIO APROBACIONES

        actor.attemptsTo(
                WaitUntil.the(TBL_PEDIDOS_APROBACIONES, isVisible()).forNoMoreThan(30).seconds()
        );

        UtilsWaits.wait(5);

        if (!BTN_LINKS_PEDIDOS.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontraron Pedidos para hacer seguimiento ")
                    .andContents(" No se encontraron Pedidos para hacer seguimiento ");
            Assert.fail(" No se encontraron Pedidos para hacer seguimiento");
        }


        String PedidoRecall = actor.recall("Pedido");
        System.out.println("Pedido Recall by Actor= " + PedidoRecall);

        listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        listaBtnAprobar = LISTA_BOTONES_APROBAR.resolveAllFor(actor);

        boolean pedidoExiste = false;

        while ((!pedidoExiste)) {
            int sizePedidos = listaPedidos.size();
            for (int j = 0; j < (sizePedidos); j++) {
                actor.attemptsTo(Scroll.to(TITULO_TABLERO_APROBACIONES).andAlignToTop());
                String textPedido = listaPedidos.get(j).getText();
                if (textPedido.contains(PedidoRecall)) {
                    pedidoExiste = true;
                    actor.attemptsTo(
                            Scroll.to(listaPedidos.get(j)).andAlignToBottom(),
                            Click.on(listaBtnAprobar.get(j)),
                            WaitUntil.the(LBL_COMENTARIO_APROBACION, isVisible()).forNoMoreThan(60).seconds(),
                            Enter.theValue("Aprobado").into(LBL_COMENTARIO_APROBACION),
                            Click.on(BTN_CONFIRMAR_APROBACION_PEDIDO),
                            WaitUntil.the(POPUP_CONFIRMACION_APROBACION, isVisible()).forNoMoreThan(30).seconds()

                    );

                    j = sizePedidos;

                }
            }


            listaPedidos = BTN_LINKS_PEDIDOS.resolveAllFor(actor);
        }

        if ((!pedidoExiste)) {
            Serenity.recordReportData().withTitle(" No se encontró el Pedido: " + PedidoRecall)
                    .andContents(" No se encontró el Pedido: " + PedidoRecall);
            Assert.fail(" No se encontró el Pedido: " + PedidoRecall);
        }


        //FIN APROBACIONES

        String urlActual = getDriver().getCurrentUrl();
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().navigate().to(urlActual);

        actor.attemptsTo(
                WaitUntil.the(BTN_SALIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SALIR),
                WaitUntil.the(BTN_CONFIRMACION_CERRAR_SESION, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONFIRMACION_CERRAR_SESION),
                WaitUntil.the(BTN_INICIAR_SESION, isVisible()).forNoMoreThan(30).seconds()
        );

    }


    public static AprobarOrdenTask enTablero(String correoAprobador, String clave) {
        return instrumented(AprobarOrdenTask.class, correoAprobador, clave);
    }
}
