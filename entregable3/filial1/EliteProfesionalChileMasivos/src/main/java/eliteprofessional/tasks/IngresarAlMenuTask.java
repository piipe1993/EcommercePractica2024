package eliteprofessional.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.CotizarUI.*;
import static eliteprofessional.userinterfaces.MiCuentaUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class IngresarAlMenuTask implements Task {

    String opcionMenu;

    public IngresarAlMenuTask(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch(opcionMenu) {
            case "Mis datos":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_MIS_DATOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MIS_DATOS)
                );
                break;

            case "Direcciones":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_DIRECCIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_DIRECCIONES)
                );
                break;

            case "Accesos":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_ACCESOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_ACCESOS)
                );
                break;

            case "Estado de cuenta":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_ESTADO_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_ESTADO_CUENTA)
                );
                break;

            case "Cotizaciones listado":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_COTIZACIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_COTIZACIONES)
                );

                actor.attemptsTo(
                        WaitUntil.the(LBL_LISTADO_COTIZACIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_LISTADO_COTIZACIONES),
                        WaitUntil.the(BTN_LISTADO_COTIZACIONES_NUEVA, isClickable()).forNoMoreThan(30).seconds()
                );
                break;

            case "Cotizaciones Nueva cotizacion":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_COTIZACIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_COTIZACIONES)
                );

                actor.attemptsTo(
                        WaitUntil.the(LBL_NUEVA_COTIZACION, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LBL_NUEVA_COTIZACION),
                        WaitUntil.the(BTN_ENVIAR, isClickable()).forNoMoreThan(30).seconds()
                );
                break;

            case "orden rápida":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_ORDEN_RAPIDA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_ORDEN_RAPIDA)
                );
                break;

            case "Pedidos":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_PEDIDOS, isClickable()).forNoMoreThan(30).seconds(),
                        //Scroll.to(OPCION_PEDIDOS).andAlignToTop(),
                        Click.on(OPCION_PEDIDOS)
                );
                break;

            case "Cambiar contraseña":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        WaitUntil.the(OPCION_CAMBIAR_CONTRASENA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_CAMBIAR_CONTRASENA)
                );
                break;

            case "Mi Cuenta":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(OPCION_MI_CUENTA)
                );
                break;

        }
    }
    public static Performable ir (String opcionMenu) {
        return Instrumented.instanceOf(IngresarAlMenuTask.class).withProperties(opcionMenu);
    }
}
