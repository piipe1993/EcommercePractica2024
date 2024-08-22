package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CotizacionExitosaQuestion;
import eliteprofessional.questions.RestablecerContrasenaQuestion;
import eliteprofessional.questions.UsuarioDesactivadoQuestion;
import eliteprofessional.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.AccesosUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.CoreMatchers.equalTo;

public class AccesosStepDefinition {

    @Cuando("el usuario ingresa a la opcion Accesos desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionAccesosDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Accesos")
        );
    }
    @Y("Agrega un nuevo usuario llenando el formulario con los datos {string} {string} {string} {string}")
    public void agregaUnNuevoUsuarioLlenandoElFormularioConLosDatos(String nombre, String apellido, String email, String rol) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccesosCrearUsuarioTask.conDatos(nombre, apellido, email, rol)
        );
    }
    @Entonces("el usuario visualizara el {string} disponible en el listado")
    public void elUsuarioVisualizaraElDisponibleEnElListado(String email) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarUsuarioCreadoTask.porEmail(email)
        );
    }

    @Y("haga uso de la opcion restablecer contrasena para el {string}")
    public void hagaUsoDeLaOpcionRestablecerContrasenaParaEl(String email) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccesosResetearContrasenaTask.paraEmail(email)
        );
    }
    @Entonces("el usuario visualizara el mensaje confirmando el envio del correo")
    public void elUsuarioVisualizaraElMensajeConfirmandoElEnvioDelCorreo() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Mensaje confirmación envio correo, Reseteo contraseña:", RestablecerContrasenaQuestion.mensaje(),equalTo("¡Se ha enviado un correo electrónico para resetear su contraseña!"))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_CERRAR_MENSAJE_RESET_PWD, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CERRAR_MENSAJE_RESET_PWD)
        );
    }

    @Y("haga uso de la opcion desactivar usuario para el {string}")
    public void hagaUsoDeLaOpcionDesactivarUsuarioParaEl(String email) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccesosDesactivarUsuarioTask.paraEmail(email)
        );
    }
    @Entonces("se visualizara el usuario desactivado")
    public void seVisualizaraElUsuarioDesactivado() {
        Assert.assertTrue("Validacion Estado desactivado del usuario",OnStage.theActorInTheSpotlight().asksFor(UsuarioDesactivadoQuestion.validarEstado()));
    }

}
