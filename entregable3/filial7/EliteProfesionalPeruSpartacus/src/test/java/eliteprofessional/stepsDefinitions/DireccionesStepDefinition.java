package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.IngresarAlMenuTask;
import eliteprofessional.tasks.ValidarDireccionTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class DireccionesStepDefinition {

    @Cuando("el usuario ingresa a la opcion Direcciones desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionDireccionesDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Direcciones")
        );
    }
    @Entonces("el usuario podra visualizar el listado de direcciones y modificarlas")
    public void elUsuarioPodraVisualizarElListadoDeDireccionesYModificarlas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarDireccionTask.seleccionada()
        );
    }
}
