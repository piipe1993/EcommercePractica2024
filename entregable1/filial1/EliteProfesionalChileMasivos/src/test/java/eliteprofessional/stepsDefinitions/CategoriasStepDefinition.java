package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.CotizarProductoCategoriaTask;
import eliteprofessional.tasks.IngresarAlCatalogoCategoriaTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class CategoriasStepDefinition {

    @Cuando("el usuario selecciona {string} y {string} del producto de interes {string}")
    public void elUsuarioSeleccionaYDelProductoDeInteres(String categoria, String subCategoria, String SKU) {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCatalogoCategoriaTask.ir(categoria, subCategoria));
        OnStage.theActorInTheSpotlight().attemptsTo(CotizarProductoCategoriaTask.ir(SKU));
    }

    @Cuando("el usuario selecciona {string} y {string}")
    public void elUsuarioSeleccionaY(String categoria, String subCategoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCatalogoCategoriaTask.ir(categoria, subCategoria));

    }
}
