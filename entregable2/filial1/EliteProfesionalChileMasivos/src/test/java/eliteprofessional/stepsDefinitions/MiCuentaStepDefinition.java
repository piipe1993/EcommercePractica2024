package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.CrearPedidoPlanillaTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import eliteprofessional.tasks.ValidarPedidoPlanillaTask;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class MiCuentaStepDefinition {

    @Y("el usuario se dirige a Mi cuenta")
    public void elUsuarioSeDirigeAPedidosEnMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Mi Cuenta"));

    }

    @Y("el usuario crea un pedido a traves de una planilla en Orden Rapida")
    public void elUsuarioCreaUnPedidoATravesDeUnaPlanillaEnOrdenRapida() {
        OnStage.theActorInTheSpotlight().attemptsTo(CrearPedidoPlanillaTask.ir(true));
    }

    @Entonces("el usuario verifica los detalles del pedido importado")
    public void elUsuarioVerificaLosDetallesDelPedidoImportado() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarPedidoPlanillaTask.ir());
    }
}
