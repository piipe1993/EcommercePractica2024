package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class OrdenRapidaStepDefinition {


    @Cuando("el usuario ingrese a la opcion orden rapida realizando la busqueda de producto por {string} con {string}")
    public void elUsuarioIngreseALaOpcionOrdenRapidaRealizandoLaBusquedaDeProductoPorCon(String SKU, String Cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoOrdenRapidaTask.conOpcion("Buscar SKU"),
                IngresarOrdenRapidaPorSkuTask.conDatos(SKU, Cantidad));

    }

    @Cuando("el usuario ingrese a la opcion orden rapida repitiendo la orden {string}")
    public void elUsuarioIngreseALaOpcionOrdenRapidaRepitiendoLaOrden(String pedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoOrdenRapidaTask.conOpcion("Repetir Pedido"),
                IngresarOrdenRapidaRepetirPedidoTask.conPedido(pedido));
    }


    @Cuando("el usuario crea un pedido a traves de una plantilla en Orden Rapida")
    public void elUsuarioCreaUnPedidoATravesDeUnaplantillaEnOrdenRapida() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoOrdenRapidaTask.conOpcion("Subir Plantilla"),
                IngresarOrdenRapidaPorPlantillaTask.ir(true));
    }

    @Entonces("el usuario verifica los detalles del pedido importado")
    public void elUsuarioVerificaLosDetallesDelPedidoImportado() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarPedidoPlantillaTask.ir());
    }


}
