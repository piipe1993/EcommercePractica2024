package eliteprofessional.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;


import static eliteprofessional.userinterfaces.CambiarContrasenaUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CambiarContrasenaTask implements Task {

    String claveActual;
    String claveNueva;

    public CambiarContrasenaTask(String claveActual, String claveNueva) {

        this.claveActual = claveActual;
        this.claveNueva = claveNueva;

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_CONTRASENA_ACTUAL, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(claveActual).into(LBL_CONTRASENA_ACTUAL),
                Enter.theValue(claveNueva).into(LBL_CONTRASENA_NUEVA),
                Enter.theValue(claveNueva).into(LBL_CONFIRMAR_CONTRASENA_NUEVA),
                WaitUntil.the(BTN_GUARDAR,isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_GUARDAR)
        );
        Serenity.takeScreenshot();

        if(ALERT_CAMPO_VACIO.isVisibleFor(actor)){
            Serenity.recordReportData().withTitle(" Campos requeridos vacios - Por favor verificar reporte y Data en Excel ")
                    .andContents(" Campos requeridos vacios - Por favor verificar reporte y Data en Excel ");
            Assert.fail (" Campos requeridos vacios - Por favor verificar reporte y Data en Excel ");
        }

        if(ALERT_CONTRASENA_INVALIDA.isVisibleFor(actor)){
            actor.attemptsTo(
                    Click.on(OPCION_MOSTRAR_CONTRASENA)
            );
            Serenity.takeScreenshot();
            Serenity.recordReportData().withTitle(" Contraseña Nueva = '" + claveNueva + "' NO es valida - Por favor verificar y modificarla en el Excel por una clave valida para el sistema ")
                    .andContents(" Contraseña Nueva = '" + claveNueva + "' NO es valida - Por favor verificar y modificarla en el Excel por una clave valida para el sistema ");
            Assert.fail (" Contraseña Nueva = '" + claveNueva + "' NO es valida - Por favor verificar y modificarla en el Excel por una clave valida para el sistema ");
        }
        Serenity.takeScreenshot();

    }

    public static CambiarContrasenaTask ir(String claveActual, String claveNueva) {
        return instrumented(CambiarContrasenaTask.class, claveActual, claveNueva);
    }
}
