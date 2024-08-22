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

import static eliteprofessional.userinterfaces.AccesosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarUsuarioCreadoTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();
    public final String email;
    public static List<WebElementFacade> listaUsuarios =new ArrayList<>();
    public static List<WebElementFacade> listaRoles =new ArrayList<>();


    public BuscarUsuarioCreadoTask(String email) {

        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LISTA_USUARIOS, isVisible()).forNoMoreThan(30).seconds()
        );

        if (!LISTA_USUARIOS.isVisibleFor(actor)) {
            Serenity.recordReportData().withTitle(" No se encontró la lista de usuarios para realizar la busqueda ")
                    .andContents(" No se encontró la lista de usuarios para realizar la busqueda ");
            Assert.fail(" No se encontró la lista de usuarios para realizar la busqueda");
        }


        listaUsuarios = LISTA_USUARIOS.resolveAllFor(actor);
        listaRoles = LISTA_ROLES.resolveAllFor(actor);

        boolean usuarioExiste = false;

        while ((!usuarioExiste)) {
            int sizeUsuarios = listaUsuarios.size();
            for (int j = 0; j < (sizeUsuarios); j++) {
                actor.attemptsTo(  Scroll.to(LISTA_USUARIOS).andAlignToTop());
                String EmailUsuario = listaUsuarios.get(j).getText();

                if (EmailUsuario.contains(email)) {
                    usuarioExiste = true;
                    actor.attemptsTo(
                            Scroll.to(listaUsuarios.get(j)).andAlignToBottom(),
                            Click.on(listaUsuarios.get(j)),
                            Click.on(listaUsuarios.get(j)),
                            Click.on(listaRoles.get(j)),
                            Click.on(listaRoles.get(j))
                    );
                    utilsWaits.wait(2);

                    j = sizeUsuarios;

                }
            }

        }

        if ((!usuarioExiste) ) {
            Serenity.recordReportData().withTitle(" No se encontró el email del usuario en el listado: "+ email)
                    .andContents(" No se encontró el email del usuario en el listado: "+ email);
            Assert.fail(" No se encontró el email del usuario en el listado: "+ email);
        }

    }


    public static BuscarUsuarioCreadoTask porEmail(String email) {
        return instrumented(BuscarUsuarioCreadoTask.class, email);
    }
}
