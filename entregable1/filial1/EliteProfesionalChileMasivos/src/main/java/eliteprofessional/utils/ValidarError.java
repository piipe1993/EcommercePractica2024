package eliteprofessional.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarError {

    public static final Target localizador = Target.the("PopUp Error").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");

    public static void validar () {
        Actor actor = theActorInTheSpotlight();
        if (localizador.isVisibleFor(actor)) {
            String error= localizador.resolveFor(actor).getText();
            Serenity.recordReportData().withTitle(" Error en el proceso: "+ error)
                    .andContents("Error en el proceso: "+ error );
            Assert.fail ("Error en el proceso:"+ error);
        }
    }

}
