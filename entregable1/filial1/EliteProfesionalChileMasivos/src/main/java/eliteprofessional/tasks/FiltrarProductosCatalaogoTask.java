package eliteprofessional.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class FiltrarProductosCatalaogoTask implements Task {

    public final String filtro, valorFiltro;

    public FiltrarProductosCatalaogoTask(String filtro, String valorFiltro) {
        this.filtro = filtro;
        this.valorFiltro = valorFiltro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if ((filtro==null)&&(valorFiltro==null)) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_PRODUCTOS, isClickable()).forNoMoreThan(30).seconds()
            );
            if (BTN_FILTRO_EXPANDIR(filtro).resolveFor(actor).isClickable()) {
                actor.attemptsTo(
                        Scroll.to(BTN_FILTRO_EXPANDIR(filtro)).andAlignToBottom()
                );
                actor.attemptsTo(
                        MoveMouse.to(BTN_FILTRO_EXPANDIR(filtro)),
                        Click.on(BTN_FILTRO_EXPANDIR(filtro))
                );
            }

            actor.attemptsTo(
                    Scroll.to(CHK_FILTRO(valorFiltro)).andAlignToBottom()
            );
            actor.attemptsTo(
                    MoveMouse.to(CHK_FILTRO(valorFiltro)),
                    Click.on(CHK_FILTRO(valorFiltro))
            );


        }
    }
    public static Performable ir (String filtro,String valorFiltro) {
        return Instrumented.instanceOf(FiltrarProductosCatalaogoTask.class).withProperties(filtro,valorFiltro);
    }
}