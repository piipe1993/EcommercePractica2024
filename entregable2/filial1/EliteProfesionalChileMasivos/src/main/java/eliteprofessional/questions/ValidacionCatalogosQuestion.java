package eliteprofessional.questions;

import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Switch;

public class ValidacionCatalogosQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Switch.toNewWindow());
        UtilsWaits.wait(2);
        Serenity.takeScreenshot();
        actor.attemptsTo(Switch.toWindowTitled("Elite"));
        return true;
    }

    public static Question<Boolean> ir (){
        return new ValidacionCatalogosQuestion();
    }

}
