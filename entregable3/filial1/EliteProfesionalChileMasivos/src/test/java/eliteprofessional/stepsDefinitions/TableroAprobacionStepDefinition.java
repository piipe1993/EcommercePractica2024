package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.AgregarSkuOrdenPendienteAprobacionTask;
import eliteprofessional.tasks.AprobarOrdenTask;
import eliteprofessional.tasks.ValidarPedidoAprobadoTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class TableroAprobacionStepDefinition {

    @Y("El usuario agrega un producto a la compra {string} {string}")
    public void elUsuarioAgregaUnProductoALaCompra(String SKU, String cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarSkuOrdenPendienteAprobacionTask.ir(cantidad,SKU));
    }
    @Cuando("el usuario apruebe la orden desde el tablero de aprobaciones {string} {string}")
    public void elUsuarioApruebeLaOrdenDesdeElTableroDeAprobaciones(String correoAprobador, String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(AprobarOrdenTask.enTablero(correoAprobador, clave));
    }
    @Entonces("el usuario visualizara el estado aprobado del pedido")
    public void elUsuarioVisualizaraElEstadoAprobadoDelPedido() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarPedidoAprobadoTask.enTablaPedidos());
    }
}
