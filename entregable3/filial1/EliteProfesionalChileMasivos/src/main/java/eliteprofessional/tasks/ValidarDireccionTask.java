package eliteprofessional.tasks;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.DireccionesUI.*;

import static eliteprofessional.userinterfaces.MisDatosUI.CONTENIDO_LISTA_DATOS;
import static eliteprofessional.userinterfaces.PaginaInicioUI.OPCION_MI_CUENTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarDireccionTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();
    public static List<WebElementFacade> listaDirecciones = new ArrayList<>();
    public static List<WebElementFacade> listaBotonesSeleccionar = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LISTA_DIRECCIONES, isVisible()).forNoMoreThan(30).seconds()
        );

        if(!LISTA_DIRECCIONES.isVisibleFor(actor)){
            Serenity.recordReportData().withTitle(" No se encontró listado de direcciones del usuario - Por favor validar modulo Mi cuenta - Direcciones")
                    .andContents(" No se encontró listado de direcciones del usuario - Por favor validar modulo Mi cuenta - Direcciones");
            Assert.fail (" No se encontró listado de direcciones del usuario - Por favor validar modulo Mi cuenta - Direcciones");
        }

        listaDirecciones = LISTA_DIRECCIONES.resolveAllFor(actor);
        listaBotonesSeleccionar = LISTA_BOTONES_SELECCIONAR.resolveAllFor(actor);

        int sizeDirecciones = listaDirecciones.size();

        for (int d = 0 ; d < (sizeDirecciones-3); d++ ){
            String valorDireccion = listaDirecciones.get(d).getText();
            actor.attemptsTo(
                    WaitUntil.the(LISTA_DIRECCIONES, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(listaDirecciones.get(d)).andAlignToBottom(),
                    WaitUntil.the(LISTA_BOTONES_SELECCIONAR, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(listaBotonesSeleccionar.get(d))

            );
            utilsWaits.wait(3);

            String direccionActualPanel = DIRECCION_ACTUAL.resolveFor(actor).getText().replace(" ...", "");
            System.out.println("direccion " + direccionActualPanel);

            if(valorDireccion.contains(direccionActualPanel)){
                Serenity.takeScreenshot();
                Serenity.recordReportData().withTitle("Dirección fue modificada por = " + valorDireccion + " y Es igual a la dirección de entrega actual visualizada en el panel = " + direccionActualPanel )
                        .andContents("Dirección fue modificada por = " + valorDireccion + " y Es igual a la dirección de entrega actual visualizada en el panel = " + direccionActualPanel);
            } else{
                Serenity.takeScreenshot();
                Serenity.recordReportData().withTitle(" La Dirección fue modificada por = " + valorDireccion + " pero dirección de entrega actual visualizada en el panel  es diferente = " + direccionActualPanel)
                        .andContents(" La Dirección fue modificada por = " + valorDireccion + " pero dirección de entrega actual visualizada en el panel  es diferente = " + direccionActualPanel);
                Assert.fail(" La Dirección fue modificada por = " + valorDireccion + " pero dirección de entrega actual visualizada en el panel  es diferente = " + direccionActualPanel);
            }


        }

    }

    public static ValidarDireccionTask seleccionada() {
        return instrumented(ValidarDireccionTask.class);
    }
}
