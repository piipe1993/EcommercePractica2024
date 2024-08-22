package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.IniciarSesionAsmTask;
import eliteprofessional.tasks.IniciarSesionTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class InicioSesionStepDefinition {

    @Before
    public void setStage() { setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentra logueado en la pagina {string} {string} {string} {string} {string}")
    public void queElUsuarioSeEncuentraLogueadoEnLaPagina(String url, String correo, String clave, String idDestinatario, String AgentId) {
        theActorCalled("Test").wasAbleTo(Open.url(url));
        if (!url.contains("asm")) {
            OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesionTask.onThePage(correo, clave, idDestinatario));
        } else {
            OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesionAsmTask.conUserAsm(AgentId, clave, correo));
        }
    }

}
