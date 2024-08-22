package eliteprofessional.tasks;


import eliteprofessional.utils.ValidarError;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.nio.file.Path;

import static eliteprofessional.userinterfaces.FinalizacionCompraUI.*;
import static eliteprofessional.userinterfaces.OrdenRapidaUI.POPUP_ERROR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ComprarFinalizarCompraTask implements Task {

    private final String numeroOC, comentarios, tipoEnvio;
    private final boolean adjuntarOC;

    public ComprarFinalizarCompraTask(String numeroOC, String comentarios, String tipoEnvio, boolean adjuntarOC) {
        this.numeroOC = numeroOC;
        this.comentarios = comentarios;
        this.tipoEnvio = tipoEnvio;
        this.adjuntarOC=adjuntarOC;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(BTN_PROCESAR_PEDIDO, isClickable()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_PROCESAR_PEDIDO).andAlignToBottom()
        );
        switch (tipoEnvio) {
            case "Envío Normal":
                actor.attemptsTo(
                        WaitUntil.the(BTN_ENVIO_NORMAL, isClickable()).forNoMoreThan(60).seconds()
                );
                actor.attemptsTo(Click.on(BTN_ENVIO_NORMAL));

                actor.attemptsTo(
                        WaitUntil.the(SLT_HORARIO_ENTREGA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(SLT_HORARIO_ENTREGA),
                        SelectFromOptions.byVisibleText("Sin preferencia horaria").from(SLT_HORARIO_ENTREGA)
                );
                break;

            case "Envío Programado":
                actor.attemptsTo(
                        WaitUntil.the(BTN_ENVIO_PROGRAMADO, isClickable()).forNoMoreThan(60).seconds()
                );
                actor.attemptsTo(Click.on(BTN_ENVIO_PROGRAMADO));
                actor.attemptsTo(
                        WaitUntil.the(BTN_CALENDARIO, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_CALENDARIO)
                );

                actor.attemptsTo(
                        WaitUntil.the(BTN_PROXIMO_MES, isClickable()).forNoMoreThan(60).seconds()
                );
                boolean clickFecha=false;
                while (!clickFecha) {
                    if (BTN_DIA_HABILITADO_CALENDARIO.isVisibleFor(actor)) {
                        actor.attemptsTo(
                                WaitUntil.the(BTN_DIA_HABILITADO_CALENDARIO, isClickable()).forNoMoreThan(60).seconds(),
                                Click.on(BTN_DIA_HABILITADO_CALENDARIO)
                        );
                        clickFecha=true;
                    } else {
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PROXIMO_MES, isClickable()).forNoMoreThan(60).seconds(),
                                Click.on(BTN_PROXIMO_MES));
                    }
                }
                break;
        }

        actor.attemptsTo(
                Enter.theValue(numeroOC).into(INPUT_OC),
                Enter.theValue(comentarios).into(INPUT_COMENTARIOS)
        );

        if (adjuntarOC) {
            Path fileToUpload = Path.of("Data\\OC.pdf");
            actor.attemptsTo(Upload.theFile(fileToUpload).to(INPUT_OC_FILE));
            ValidarError.validar();
            actor.attemptsTo(
                    WaitUntil.the(LBL_OC_FILE, isVisible()).forNoMoreThan(60).seconds()
            );

        }
        actor.attemptsTo(
                Click.on(BTN_PROCESAR_PEDIDO)
        );

        if (POPUP_ERROR_PROCESAR_PEDIDO.isVisibleFor(actor)) {
            String error= POPUP_ERROR_PROCESAR_PEDIDO.resolveFor(actor).getText();

            Serenity.recordReportData().withTitle(" Error al Procesar Pedido: "+ error)
                    .andContents("Error al Procesar Pedido: "+ error );
            Assert.fail ("Error al Procesar Pedido: "+ error);
        }

        actor.attemptsTo(
                WaitUntil.the(LBL_COMPRA_RECIBIDA, isVisible()).forNoMoreThan(60).seconds()
        );
    }
    public static Performable ir (String numeroOC, String comentarios, String tipoEnvio, boolean adjuntarOC){
        return Instrumented.instanceOf(ComprarFinalizarCompraTask.class).withProperties(numeroOC, comentarios, tipoEnvio, adjuntarOC );
    }
}