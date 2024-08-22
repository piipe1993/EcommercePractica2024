package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CotizacionExitosaQuestion;
import eliteprofessional.questions.ListarCotizacionesQuestion;
import eliteprofessional.tasks.DiligenciarFormularioCotizadorTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.CotizarUI.BTN_CERRAR_COTIZACION_EXITOSA;

public class CotizacionesStepDefinition {

    @Cuando("el usuario ingresa a la opcion Cotizaciones desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionCotizacionesDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Cotizaciones listado")
        );
    }
    @Entonces("el usuario visualizara el listado de cotizaciones")
    public void elUsuarioVisualizaraElListadoDeCotizaciones() {
        Assert.assertTrue("Validacion Listado Cotizaciones",OnStage.theActorInTheSpotlight().asksFor(ListarCotizacionesQuestion.ir()));
    }

    @Cuando("el usuario ingresa a la opcion nueva cotizacion desde menu mi cuenta")
    public void elUsuarioIngresaALaOpcionNuevaCotizacionDesdeMenuMiCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlMenuTask.ir("Cotizaciones Nueva cotizacion")
        );
    }

    @Y("el usuario complete el formulario de cotización")
    public void el_usuario_complete_el_formulario_de_cotización(DataTable datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioCotizadorTask.ir(datos,true));
    }

    @Entonces("el usuario visualizara el mensaje de cotizacion exitosa")
    public void elUsuarioVisualizaraElMensajeDeCotizacionExitosa() {
        Assert.assertTrue("Validacion PopUp Cotizacion exitosa",OnStage.theActorInTheSpotlight().asksFor(CotizacionExitosaQuestion.ir()));
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CERRAR_COTIZACION_EXITOSA)
        );
    }
}
