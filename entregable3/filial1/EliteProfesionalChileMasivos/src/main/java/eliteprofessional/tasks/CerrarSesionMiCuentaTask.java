package eliteprofessional.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.InicioSesionUI.*;

import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesionMiCuentaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {


            actor.attemptsTo(
                    WaitUntil.the(BTN_SALIR, isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_SALIR),
                    WaitUntil.the(BTN_CONFIRMACION_CERRAR_SESION, isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_CONFIRMACION_CERRAR_SESION),
                    WaitUntil.the(BTN_INICIAR_SESION, isVisible()).forNoMoreThan(120).seconds()
            );

    }
    public static CerrarSesionMiCuentaTask ir() {
        return Instrumented.instanceOf(CerrarSesionMiCuentaTask.class).withProperties();
    }
}