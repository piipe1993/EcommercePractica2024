package eliteprofessional.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.OrdenRapidaUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarTipoOrdenRapidaTask implements Task {

    String tipoOrdenRapida;

    public SeleccionarTipoOrdenRapidaTask (String tipoOrdenRapida){
        this.tipoOrdenRapida = tipoOrdenRapida;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (tipoOrdenRapida){
            case "Buscar SKU":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        Click.on(OPCION_ORDEN_RAPIDA),
                        WaitUntil.the(OPCION_BUSCAR_SKU, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_BUSCAR_SKU),
                        Scroll.to(TITULO_ORDEN_RAPIDA).andAlignToTop()
                );
                break;

            case "Repetir Pedido":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        Click.on(OPCION_ORDEN_RAPIDA),
                        WaitUntil.the(OPCION_REPETIR_PEDIDO, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_REPETIR_PEDIDO),
                        Scroll.to(TITULO_ORDEN_RAPIDA).andAlignToTop()
                );
                break;

            case "Subir Plantilla":
                actor.attemptsTo(
                        WaitUntil.the(OPCION_MI_CUENTA, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_MI_CUENTA),
                        Click.on(OPCION_ORDEN_RAPIDA),
                        WaitUntil.the(OPCION_SUBIR_PLANTILLA, isClickable()).forNoMoreThan(2).seconds(),
                        Click.on(OPCION_SUBIR_PLANTILLA),
                        Scroll.to(TITULO_ORDEN_RAPIDA).andAlignToTop()
                );
                break;

        }

    }

    public static SeleccionarTipoOrdenRapidaTask conOpcion(String tipoOrdenRapida){
        return instrumented(SeleccionarTipoOrdenRapidaTask.class, tipoOrdenRapida);
    }
}