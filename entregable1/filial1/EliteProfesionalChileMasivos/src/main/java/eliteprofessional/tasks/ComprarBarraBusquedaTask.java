package eliteprofessional.tasks;


import eliteprofessional.utils.UtilsWaits;
import eliteprofessional.utils.ValidarError;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;

import static eliteprofessional.userinterfaces.ProductosUI.*;
import static eliteprofessional.userinterfaces.ProductosUI.BTN_COMPRAR_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class ComprarBarraBusquedaTask implements Task {

    public final String cantidad, SKU;
    UtilsWaits utilsWaits= new UtilsWaits();

    public ComprarBarraBusquedaTask(String cantidad, String SKU) {
        this.cantidad = cantidad;
        this.SKU = SKU;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(INPUT_BUSCADOR, isEnabled()).forNoMoreThan(30).seconds()
        );


        actor.attemptsTo(
                Enter.theValue(SKU).into(INPUT_BUSCADOR)
        );
        utilsWaits.wait(5);
        actor.attemptsTo(
                WaitUntil.the(BTN_PRODUCTO_BUSCADO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_PRODUCTO_BUSCADO)
        );

        actor.attemptsTo(
                WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(30).seconds()
        );
        utilsWaits.wait(5);
        int cantidadN= Integer.parseInt(cantidad);
        if (cantidadN >= 2) {
            if (cantidadN >2) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_AGREGAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                        MoveMouse.to(BTN_AGREGAR_PRODUCTO),
                        Click.on(BTN_AGREGAR_PRODUCTO)
                );
            }
            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );

            actor.attemptsTo(
                    Enter.theValue(String.valueOf(cantidadN-1)).into(INPUT_CANTIDAD_PRODUCTOS)
            );

            actor.attemptsTo(
                    WaitUntil.the(BTN_QUITAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    MoveMouse.to(BTN_QUITAR_PRODUCTO ),
                    Click.on(BTN_QUITAR_PRODUCTO )
            );

            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );


        } else {

            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );
        }
        ValidarError.validar();

    }
    public static Performable ir (String SKU, String cantidad) {
        return Instrumented.instanceOf(ComprarBarraBusquedaTask.class).withProperties(SKU, cantidad);
    }
}