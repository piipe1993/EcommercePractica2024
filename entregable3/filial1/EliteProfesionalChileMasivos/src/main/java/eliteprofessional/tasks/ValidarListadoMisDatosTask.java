package eliteprofessional.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


import static eliteprofessional.userinterfaces.AccesosUI.LISTA_USUARIOS;
import static eliteprofessional.userinterfaces.MisDatosUI.CONTENIDO_LISTA_DATOS;
import static eliteprofessional.userinterfaces.MisDatosUI.LISTA_TITULOS_DATOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarListadoMisDatosTask implements Task {

    public static List<WebElementFacade> listaValoresDatos = new ArrayList<>();
    public static List<WebElementFacade> listaTitulosDatos = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CONTENIDO_LISTA_DATOS, isVisible()).forNoMoreThan(30).seconds()
        );

        listaValoresDatos = CONTENIDO_LISTA_DATOS.resolveAllFor(actor);
        listaTitulosDatos = LISTA_TITULOS_DATOS.resolveAllFor(actor);

        int sizeDatos = listaTitulosDatos.size();

        for (int j = 0; j < (sizeDatos); j++) {
            String valoresDatos = listaValoresDatos.get(j).getText();
            String TitulosDatos = listaTitulosDatos.get(j).getText();

            if(!CONTENIDO_LISTA_DATOS.isVisibleFor(actor)){
                Serenity.recordReportData().withTitle(" No se encontraron Datos del usuario - Por favor validar registro completo")
                        .andContents(" No se encontraron Datos del usuario - Por favor validar registro completo");
                Assert.fail (" No se encontraron Datos del usuario - Por favor validar registro completo");
            }

            if (valoresDatos.equals(" ") || valoresDatos.equals("-")) {
                Serenity.takeScreenshot();
                Serenity.recordReportData().withTitle("el campo " + TitulosDatos + " No Contiene informacion - Revisar Valor actual = " + valoresDatos)
                        .andContents("el campo " + TitulosDatos + " No Contiene informacion - Revisar Valor actual = " + valoresDatos);
            }
            Serenity.recordReportData().withTitle("Valor campo " + TitulosDatos + " = " + valoresDatos)
                    .andContents("Valor campo " + TitulosDatos + " = " + valoresDatos);

        }
    }

    public static ValidarListadoMisDatosTask ir() {
        return instrumented(ValidarListadoMisDatosTask.class);
    }
}
