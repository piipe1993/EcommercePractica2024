package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.DetallePedidoQuestion;
import eliteprofessional.tasks.BuscarPedidoMiCuentaTask;
import eliteprofessional.tasks.CancelarPedidoMiCuentaTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class MiCuentaStepDefinition {

    @Y("el usuario se dirige a pedidos en Mi cuenta")
    public void elUsuarioSeDirigeAPedidosEnMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Mi Cuenta"));

    }

    @Y("el usuario busca el pedido {string}")
    public void elUsuarioBuscaElPedido(String pedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarPedidoMiCuentaTask.ir(pedido));

    }

    @Entonces("el usuario visualizara el estado de su Pedido {string}")
    public void elUsuarioVisualizaraElEstadoDeSuPedido(String pedido) {
        OnStage.theActorInTheSpotlight().asksFor(DetallePedidoQuestion.ir(pedido));

    }

    @Entonces("el usuario solicita la cancelacion del pedido")
    public void elUsuarioSolicitaLaCancelacionDelPedido() {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarPedidoMiCuentaTask.ir());

    }
}
