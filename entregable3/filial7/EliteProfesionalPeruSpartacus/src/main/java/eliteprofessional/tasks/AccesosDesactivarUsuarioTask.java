package eliteprofessional.tasks;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
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

public class AccesosDesactivarUsuarioTask implements Task {


    UtilsWaits utilsWaits = new UtilsWaits();
    public final String email;
    public static List<WebElementFacade> listaUsuarios = new ArrayList<>();


    public AccesosDesactivarUsuarioTask(String email) {

        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LISTA_USUARIOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LBL_BUSCAR_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
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

        if (TOGGLE_OFF_ACTIVACION_USUARIO.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" El usuario ya se encuentra desactivado y/o bloqueado: " + email)
                    .andContents(" El usuario ya se encuentra desactivado y/o bloqueado: " + email);
            Assert.fail(" El usuario ya se encuentra desactivado y/o bloqueado: " + email);
        } else {
            actor.attemptsTo(
                    Click.on(TOGGLE_ON_ACTIVACION_USUARIO)
            );

            utilsWaits.wait(5);

            actor.attemptsTo(
                    WaitUntil.the(LBL_BUSCAR_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                    Clear.field(LBL_BUSCAR_USUARIO),
                    Enter.theValue(email).into(LBL_BUSCAR_USUARIO),
                    WaitUntil.the(LISTA_USUARIOS, isVisible()).forNoMoreThan(15).seconds()
            );
        }

    }


    public static AccesosDesactivarUsuarioTask paraEmail(String email) {
        return instrumented(AccesosDesactivarUsuarioTask.class, email);
    }
}
