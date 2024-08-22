package eliteprofessional.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.CotizarUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarAlMenuTask implements Task {

    String opcionMenu;

    public IngresarAlMenuTask(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch(opcionMenu) {
            case "cotizar Nueva Cotizacion":
                actor.attemptsTo(
                        WaitUntil.the(LBL_COTIZAR, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_COTIZAR)
                );

                actor.attemptsTo(
                        WaitUntil.the(LBL_NUEVA_COTIZACION, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_NUEVA_COTIZACION),
                        WaitUntil.the(BTN_ENVIAR, isClickable()).forNoMoreThan(30).seconds()
                );
                break;

            case "cotizar Listado Cotizaciones":
                actor.attemptsTo(
                        WaitUntil.the(LBL_COTIZAR, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_COTIZAR)
                );

                actor.attemptsTo(
                        WaitUntil.the(LBL_LISTADO_COTIZACIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_LISTADO_COTIZACIONES),
                        WaitUntil.the(BTN_LISTADO_COTIZACIONES_NUEVA, isClickable()).forNoMoreThan(30).seconds()
                );
                break;

            case "orden rápida":
                actor.attemptsTo(
                        WaitUntil.the(LBL_ORDEN_RAPIDA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_ORDEN_RAPIDA)
                );
                break;
            case "Seguimiento pedidos":
                actor.attemptsTo(
                        WaitUntil.the(LBL_SEGUIMINETO_PEDIDOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_SEGUIMINETO_PEDIDOS)
                );
                break;

            case "Mis Favoritos":
                actor.attemptsTo(
                        WaitUntil.the(BTN_FAVORITOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_FAVORITOS),
                        WaitUntil.the(LBL_LISTA_DE_DESEOS, isVisible()).forNoMoreThan(30).seconds()
                );
                break;
            case "Mi Cuenta":
                actor.attemptsTo(
                        WaitUntil.the(BTN_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_MI_CUENTA)
                );
                break;
        }
    }
    public static Performable ir (String opcionMenu) {
        return Instrumented.instanceOf(IngresarAlMenuTask.class).withProperties(opcionMenu);
    }
}
