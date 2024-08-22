package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CompraRecibidaQuestion;
import eliteprofessional.tasks.CarritoDeComprasTask;
import eliteprofessional.tasks.ComprarFinalizarCompraTask;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class PedidosStepDefinition {



    @Y("el usuario se dirige al carrito de compras")
    public void elUsuarioSeDirigeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo( CarritoDeComprasTask.ir("Ir a pagar"));

    }

    @Y("el usuario finaliza el proceso de compra {string} {string} {string}")
    public void elUsuarioFinalizaElProcesoDeCompra(String numeroOC, String comentarios, String tipoEnvio ) {
        OnStage.theActorInTheSpotlight().attemptsTo( ComprarFinalizarCompraTask.ir(numeroOC, comentarios, tipoEnvio ));

    }


    @Entonces("el usuario visualizara que su compra fue recibida exitosamente")
    public void elUsuarioVisualizaraQueSuCompraFueRecibidaExitosamente() {
        OnStage.theActorInTheSpotlight().asksFor(CompraRecibidaQuestion.ir());
    }



}