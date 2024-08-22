package eliteprofessional.tasks;


import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.AccesosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccesosCrearUsuarioTask implements Task {

    public final String nombre;
    public final String apellido;
    public final String email;
    public final String rol;

    public AccesosCrearUsuarioTask (String nombre, String apellido, String email, String rol){
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.rol=rol;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_AGREGAR_USUARIO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_AGREGAR_USUARIO),
                WaitUntil.the(LBL_NOMBRE_USUARIO, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(nombre).into(LBL_NOMBRE_USUARIO),
                Enter.theValue(apellido).into(LBL_APELLIDO_USUARIO),
                Enter.theValue(email).into(LBL_EMAIL_USUARIO),
                SelectFromOptions.byVisibleText(rol).from(SELECT_ROL_USUARIO),
                Click.on(BTN_AGREGAR_USUARIO_FORMULARIO)

        );

        if (ALERTA_EMAIL_INVALIDO.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" El email ingresado no es valido por favor validarlo y/o modificarlo: " + email)
                    .andContents(" El email ingresado no es valido por favor validarlo y/o modificarlo: " + email);
            Assert.fail(" El email ingresado no es valido por favor validarlo y/o modificarlo: " + email);
        }


        if (ALERTA_USUARIO_EXISTENTE.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" El usuario ya existe en nuestra base de datos, por favor confirmar Email: " + email)
                    .andContents(" El usuario ya existe en nuestra base de datos, por favor confirmar Email: " + email);
            Assert.fail(" El usuario ya existe en nuestra base de datos, por favor confirmar Email: " + email);
        }
    }


    public static AccesosCrearUsuarioTask conDatos(String nombre, String apellido, String email, String rol){
        return instrumented(AccesosCrearUsuarioTask.class, nombre, apellido, email, rol );
    }
}
