package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.CerrarSesionMiCuentaTask;
import eliteprofessional.tasks.CerrarSesionTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.java.After;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class CerrarSesionStepDefinition {

    @After("@EliteProfesional")
    @Entonces("el usuario cerrara la sesion")
    public static void el_usuario_cerrara_la_sesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesionTask.ir());

    }

    @Y("el usuario se dirige a pedidos en Mi cuenta")
    public void elUsuarioSeDirigeAPedidosEnMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Mi Cuenta"));

    }
    @Entonces("el usuario cierra la sesion")
    public void el_usuario_cierra_la_sesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesionMiCuentaTask.ir());
    }

}
