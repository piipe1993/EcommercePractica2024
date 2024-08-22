package eliteprofessional.stepsDefinitions;
import eliteprofessional.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class ExplorarCarruselesStepDefinition {

    @Cuando("el usuario Explora las Categorias y Subcategorias {string}")
    public void elUsuarioExploraLasCategoriasYSubcategorias(String categorias) {
        OnStage.theActorInTheSpotlight().attemptsTo(ExplorarCategoriasYSubCategoriasTask.ir(categorias));

    }


    @Entonces("el usuario Explora el Carrusel de Categorias {string}")
    public void elUsuarioExploraElCarruselDeCategorias(String categorias) {
        OnStage.theActorInTheSpotlight().attemptsTo(FuncionamientoCarruselCategoriasTask.ir(categorias));

    }

    @Entonces("el usuario Explora el Primer Carrusel {string}")
    public void elUsuarioExploraElPrimerCarrusel(String SKU) {
        OnStage.theActorInTheSpotlight().attemptsTo(FuncionamientoPrimerCarruselTask.ir(SKU));

    }


    @Entonces("el usuario Explora el Segundo Carrusel {string}")
    public void elUsuarioExploraElSegundoCarrusel(String SKU) {
        OnStage.theActorInTheSpotlight().attemptsTo(FuncionamientoSegundoCarruselTask.ir(SKU));

    }

    @Entonces("el usuario Explora el Carrusel Segmentos")
    public void elUsuarioExploraElCarruselSegmentos() {
        OnStage.theActorInTheSpotlight().attemptsTo(FuncionamientoCarruselSegmentosTask.ir());

    }

    @Entonces("el usuario Explora el Carrusel de Marcas")
    public void elUsuarioExploraElCarruselDeMarcas() {
        OnStage.theActorInTheSpotlight().attemptsTo(FuncionamientoCarruselMarcasTask.ir());


    }


}
