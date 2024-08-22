package eliteprofessional.stepsDefinitions;

import eliteprofessional.tasks.CerrarSesionTask;
import io.cucumber.java.After;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;


public class CerrarSesionStepDefinition {

    @After("@EliteProfesional")
    @Entonces("el usuario cerrara la sesion")
    public static void el_usuario_cerrara_la_sesion() {
     OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesionTask.ir());

    }




  }
