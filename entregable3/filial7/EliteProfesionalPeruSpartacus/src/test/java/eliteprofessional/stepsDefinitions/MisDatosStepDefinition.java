package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.IngresarAlMenuTask;
import eliteprofessional.tasks.ValidarListadoMisDatosTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class MisDatosStepDefinition {

    @Cuando("el usuario ingresa a la opcion Mis Datos desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionMisDatosDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Mis datos")
        );
    }
    @Entonces("el usuario visualizara todos sus datos")
    public void elUsuarioVisualizaraTodosSusDatos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarListadoMisDatosTask.ir()
        );
    }
}
