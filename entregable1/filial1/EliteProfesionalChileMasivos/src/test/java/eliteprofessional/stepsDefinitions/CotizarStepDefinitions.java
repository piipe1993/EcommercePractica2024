package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CotizacionExitosaQuestion;
import eliteprofessional.questions.ListarCotizacionesQuestion;
import eliteprofessional.tasks.DiligenciarFormularioCotizadorTask;
import eliteprofessional.tasks.IngresarAlMenuTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class CotizarStepDefinitions {

    @Cuando("el usuario ingresa a  la opcion Cotizar")
    public void el_usuario_ingresa_a_la_opcion_cotizar() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("cotizar Nueva Cotizacion"));
    }

    @Cuando("el usuario complete el formualrio de cotización")
    public void el_usuario_complete_el_formualrio_de_cotización(DataTable datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioCotizadorTask.ir(datos,true));
    }

    @Y("el usuario complete el formualrio de cotización sin agregar el producto")
    public void elUsuarioCompleteElFormualrioDeCotizaciónSinAgregarElProducto(DataTable datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioCotizadorTask.ir(datos,false));

    }

    @Cuando("el usuario ingresa a  la opcion Cotizar y listara la cotizaciones")
    public void elUsuarioIngresaALaOpcionCotizarYListaraLaCotizaciones() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("cotizar Listado Cotizaciones"));
    }

    @Y("el usuario visualizara las cotizaciones")
    public void elUsuarioVisualizaraLasCotizaciones() {
        OnStage.theActorInTheSpotlight().asksFor(ListarCotizacionesQuestion.ir());
    }


    @Entonces("el usuario visualizara el mensaje de cotizacion exitosa")
    public void elUsuarioVisualizaraElMensajeDeCotizacionExitosa() {
        OnStage.theActorInTheSpotlight().asksFor(CotizacionExitosaQuestion.ir());
    }


}
