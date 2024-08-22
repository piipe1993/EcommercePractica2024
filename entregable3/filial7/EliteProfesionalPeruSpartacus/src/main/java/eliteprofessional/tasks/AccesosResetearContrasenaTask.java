package eliteprofessional.tasks;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.AccesosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccesosResetearContrasenaTask implements Task {


    UtilsWaits utilsWaits = new UtilsWaits();
    public final String email;
    public static List<WebElementFacade> listaUsuarios = new ArrayList<>();


    public AccesosResetearContrasenaTask(String email) {

        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LISTA_USUARIOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LBL_BUSCAR_USUARIO, isVisible()).forNoMoreThan(10).seconds()
        );


        actor.attemptsTo(
                Enter.theValue(email).into(LBL_BUSCAR_USUARIO),
                WaitUntil.the(LISTA_USUARIOS, isVisible()).forNoMoreThan(15).seconds()
        );


        if (!LISTA_USUARIOS.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontraron resultados luego de realizar la busqueda del usuario por el email: " + email)
                    .andContents(" No se encontraron resultados luego de realizar la busqueda del usuario por el email: " + email);
            Assert.fail(" No se encontraron resultados luego de realizar la busqueda del usuario por el email: " + email);
        }


        listaUsuarios = LISTA_USUARIOS.resolveAllFor(actor);

        boolean usuarioExiste = false;

        while ((!usuarioExiste)) {
            int sizeUsuarios = listaUsuarios.size();
            for (int j = 0; j < (sizeUsuarios); j++) {
                actor.attemptsTo(Scroll.to(LISTA_USUARIOS).andAlignToTop());
                String EmailUsuario = listaUsuarios.get(j).getText();

                if (EmailUsuario.equalsIgnoreCase(email)) {
                    usuarioExiste = true;
                    actor.attemptsTo(
                            Scroll.to(listaUsuarios.get(j)).andAlignToBottom()
                    );
                    utilsWaits.wait(2);

                    j = sizeUsuarios;

                }
            }

        }

        if ((!usuarioExiste)) {
            Serenity.recordReportData().withTitle(" No se encontró el email del usuario en el listado: " + email)
                    .andContents(" No se encontró el email del usuario en el listado: " + email);
            Assert.fail(" No se encontró el email del usuario en el listado: " + email);
        }

        actor.attemptsTo(
                Click.on(OPCION_REESTABLECER_CONTRASENA),
                WaitUntil.the(MENSAJE_CONFIRMACION_RESET_PWD, isVisible()).forNoMoreThan(15).seconds()
        );

        String mensaje= MENSAJE_CONFIRMACION_RESET_PWD.resolveFor(actor).getText();
        if (mensaje.contains("error")) {
            actor.attemptsTo(
                    Click.on(BTN_CERRAR_MENSAJE_RESET_PWD)
            );
            Serenity.recordReportData().withTitle(" El usuario esta Desactivado - "+ mensaje)
                    .andContents(" El usuario esta Desactivado - "+ mensaje);
            Assert.fail (" El usuario esta Desactivado - "+ mensaje);

        }

    }


    public static AccesosResetearContrasenaTask paraEmail(String email) {
        return instrumented(AccesosResetearContrasenaTask.class, email);
    }
}
