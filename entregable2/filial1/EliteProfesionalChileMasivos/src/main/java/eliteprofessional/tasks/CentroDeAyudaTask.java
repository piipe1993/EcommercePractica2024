package eliteprofessional.tasks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static eliteprofessional.userinterfaces.FooterUI.BTN_PREGUNTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class CentroDeAyudaTask implements Task {

    public List<WebElementFacade> preguntas;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(BTN_PREGUNTAS, isClickable()).forNoMoreThan(30).seconds());
        preguntas = BTN_PREGUNTAS.resolveAllFor(actor);
        int i=0;
        for (WebElementFacade pregunta : preguntas) {
            i=+1;
            try {
                actor.attemptsTo(
                        Scroll.to(pregunta).andAlignToBottom(),
                        Click.on(pregunta)
                );
            }catch (Exception e){
                Serenity.recordReportData().withTitle("Existe un problema al expandir la pregunta "+i )
                        .andContents("Existe un problema al expandir la pregunta "+i );

            }

        }


    }
    public static Performable ir ( ){
        return Instrumented.instanceOf(CentroDeAyudaTask.class).withProperties();
    }
}