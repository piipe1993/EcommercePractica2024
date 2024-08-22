package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CompraRecibidaQuestion;
import eliteprofessional.questions.PedidoCanceladoQuestion;
import eliteprofessional.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.Assert;

public class PedidosStepDefinition {


    @Cuando("el usuario ingresa a la opcion Pedidos desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionPedidosDesdeMenuMiCuenta() {
  OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Pedidos"));
    }

    @Cuando("el usuario busca el pedido {string} y solicita repetirlo")
    public void elUsuarioBuscaElPedidoYSolicitaRepetirlo(String pedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarPedidoMiCuentaTask.ir(pedido),
                RepetirPedidoMiCuentaTask.ir()
        );
    }

    @Y("el usuario busca el pedido {string}")
    public void elUsuarioBuscaElPedido(String pedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarPedidoMiCuentaTask.ir(pedido));

    }

    @Y("el usuario solicita la cancelacion del pedido")
    public void elUsuarioSolicitaLaCancelacionDelPedido() {
        OnStage.theActorInTheSpotlight().attemptsTo(CancelarPedidoMiCuentaTask.ir());

    }

    @Y("el usuario se dirige al carrito de compras")
    public void elUsuarioSeDirigeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo( CarritoDeComprasTask.ir("Ir a pagar"));

    }

    @Y("el usuario finaliza el proceso de compra {string} {string} {string}")
    public void elUsuarioFinalizaElProcesoDeCompra(String numeroOC, String comentarios, String tipoEnvio ) {
        OnStage.theActorInTheSpotlight().attemptsTo( ComprarFinalizarCompraTask.ir(numeroOC, comentarios, tipoEnvio,false ));

    }


    @Entonces("el usuario visualizara que su compra fue recibida exitosamente")
    public void elUsuarioVisualizaraQueSuCompraFueRecibidaExitosamente() {
        Assert.assertTrue("Validacion Compra Recibida",OnStage.theActorInTheSpotlight().asksFor(CompraRecibidaQuestion.ir()));
    }

    @Entonces("el usuario visualizara el mensaje confirmando la cancelacion")
    public void elusuariovisualizaraelmensajeconfirmandolacancelacion() {
        Assert.assertTrue("Validacion Pedido Cancelado",OnStage.theActorInTheSpotlight().asksFor(PedidoCanceladoQuestion.validar()));
    }


}
