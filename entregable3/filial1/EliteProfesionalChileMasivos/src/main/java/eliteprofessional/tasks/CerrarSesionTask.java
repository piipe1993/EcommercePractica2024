package eliteprofessional.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.FinalizacionCompraUI.BTN_IR_AL_INICIO;
import static eliteprofessional.userinterfaces.InicioSesionUI.BTN_INICIAR_SESION;
import static eliteprofessional.userinterfaces.PaginaInicioUI.BTN_CERRAR_SESION;
import static eliteprofessional.userinterfaces.PaginaInicioUI.BTN_CONFIRMACION_CERRAR_SESION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesionTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {



        if (BTN_IR_AL_INICIO.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Scroll.to(BTN_IR_AL_INICIO).andAlignToBottom(),
                    Click.on(BTN_IR_AL_INICIO)
            );
        }

            actor.attemptsTo(
                    WaitUntil.the(BTN_CERRAR_SESION, isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_CERRAR_SESION),
                    WaitUntil.the(BTN_CONFIRMACION_CERRAR_SESION, isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_CONFIRMACION_CERRAR_SESION),
                    WaitUntil.the(BTN_INICIAR_SESION, isVisible()).forNoMoreThan(120).seconds()
            );

    }
    public static CerrarSesionTask ir() {
        return Instrumented.instanceOf(CerrarSesionTask.class).withProperties();
    }
}