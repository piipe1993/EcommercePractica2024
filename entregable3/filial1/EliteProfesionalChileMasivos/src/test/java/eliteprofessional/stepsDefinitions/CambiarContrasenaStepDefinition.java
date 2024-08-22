package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.ContrasenaModificadaQuestion;
import eliteprofessional.tasks.CambiarContrasenaTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.Assert;

public class CambiarContrasenaStepDefinition {
    @Cuando("el usuario ingresa a la opcion Cambiar Contrasena desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionCambiarContrasenaDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Cambiar contraseña")
        );
    }
    @Y("diligencia el formulario con la clave anterior y la nueva {string} {string}")
    public void diligenciaElFormularioConLaClaveAnteriorYLaNueva(String claveActual, String claveNueva) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CambiarContrasenaTask.ir(claveActual, claveNueva)
        );
    }
    @Entonces("el usuario visualizara el mensaje confirmando el cambio de contraseña")
    public void elUsuarioVisualizaraElMensajeConfirmandoElCambioDeContraseña() {
        Assert.assertTrue("Validacion Mensaje contraseña modificada Exitosamente",OnStage.theActorInTheSpotlight().asksFor(ContrasenaModificadaQuestion.validarMensaje()));
    }


}
