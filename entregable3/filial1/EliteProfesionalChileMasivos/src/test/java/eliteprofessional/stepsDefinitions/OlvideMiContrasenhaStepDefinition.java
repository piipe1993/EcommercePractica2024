package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class OlvideMiContrasenhaStepDefinition {


    @Dado("que el usuario se encuentra en la pagina {string}")
    public void queElUsuarioSeEncuentraEnLaPagina(String url) {
        theActorCalled("Test").wasAbleTo(Open.url(url));

    }

    @Cuando("el usuario Solicita correo de recuperacion en el Link Olvide Mi Contraseña {string}")
    public void elUsuarioSolicitaCorreoDeRecuperacionEnElLinkOlvideMiContraseña(String correo) {
        OnStage.theActorInTheSpotlight().attemptsTo(SolicitudCorreoRecuperacionTask.ir(correo));
    }

    @Y("el usuario ingresa a Gmail para acceder al correo de recuperacion {string} {string} {string}")
    public void elUsuarioIngresaAGmailParaAccederAlCorreoDeRecuperacion(String correo, String clave, String asunto) {
        OnStage.theActorInTheSpotlight().attemptsTo(CorreoRecupracionContrasenhaGmailTask.ir(correo,clave,asunto));
    }

    @Y("el usuario cambia la contraseña {string}")
    public void elUsuarioCambiaLaContrasenha(String nuevaClave) {
        OnStage.theActorInTheSpotlight().attemptsTo(ActualizacionContrasenhaTask.ir(nuevaClave));

    }

    @Entonces("el usuario inicia sesion con la nueva contraseña {string} {string} {string} {string}")
    public void elUsuarioIniciaSesionConLaNuevaContraseña(String url, String clave, String correo, String idDestinatario) {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirPaginalTask.ir(url));
        OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesionTask.onThePage(correo, clave, idDestinatario));
    }
}
