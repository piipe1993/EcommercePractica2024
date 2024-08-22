package eliteprofessional.tasks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.CarritoDeComprasUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class CarritoDeComprasTask implements Task {

    public final String accion;

    public CarritoDeComprasTask(String accion) {
        this.accion = accion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CARRITO_COMPRAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CARRITO_COMPRAS)
        );

        switch( accion) {
            case "Ir a pagar":
                actor.attemptsTo(
                        WaitUntil.the(BTN_IR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_IR_PAGAR)
                );

                actor.attemptsTo(
                        WaitUntil.the(CHK_DECLARACION_TERMINOS_CONDICIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(CHK_DECLARACION_TERMINOS_CONDICIONES),
                        Click.on(BTN_FINALIZAR_COMPRA)
                );
                if (POPUP_ERROR_FINALIZAR_COMPRA.isVisibleFor(actor)) {
                    String error= POPUP_ERROR_FINALIZAR_COMPRA.resolveFor(actor).getText();

                    Serenity.recordReportData().withTitle(" Error al finalizar la Compra: "+ error)
                            .andContents("Error al finalizar la Compra: "+ error );
                    Assert.fail ("Error al finalizar la Compra: "+ error);
                }

                break;

            case "Seguir Comprando":
                actor.attemptsTo(
                        WaitUntil.the(BTN_SEGUIR_COMPRANDO, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_SEGUIR_COMPRANDO)
                );
                break;


        }

    }
    public static Performable ir (String accion) {
        return Instrumented.instanceOf(CarritoDeComprasTask.class).withProperties(accion);
    }
}