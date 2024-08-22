package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.IngresarOrdenRapidaPorSku;
import eliteprofessional.tasks.IngresarOrdenRapidaRepetirPedido;
import eliteprofessional.tasks.SeleccionarTipoOrdenRapidaTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class OrdenRapidaStepDefinition {


    @Cuando("el usuario ingrese a la opcion orden rapida realizando la busqueda de producto por {string} con {string}")
    public void elUsuarioIngreseALaOpcionOrdenRapidaRealizandoLaBusquedaDeProductoPorCon(String SKU, String Cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoOrdenRapidaTask.conOpcion("Buscar SKU"),
                IngresarOrdenRapidaPorSku.conDatos(SKU, Cantidad));

    }

    @Cuando("el usuario ingrese a la opcion orden rapida realizando la busqueda de producto por {string}")
    public void elUsuarioIngreseALaOpcionOrdenRapidaRealizandoLaBusquedaDeProductoPor(String pedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoOrdenRapidaTask.conOpcion("Repetir Pedido"),
                IngresarOrdenRapidaRepetirPedido.conPedido(pedido));

    }



}
