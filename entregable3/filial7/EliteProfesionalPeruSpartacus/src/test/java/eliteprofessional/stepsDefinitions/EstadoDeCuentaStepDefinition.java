package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.EstadoCuentaTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class EstadoDeCuentaStepDefinition {

    @Cuando("el usuario ingresa a la opcion Estado de Cuenta desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionEstadoDeCuentaDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Estado de cuenta"));
    }


    @Entonces("el usuario visualiza el estado de cuenta {string}")
    public void elUsuarioVisualizaElEstadoDeCuenta(String nDocumento) {
        OnStage.theActorInTheSpotlight().attemptsTo(EstadoCuentaTask.ir(nDocumento));
    }

}
