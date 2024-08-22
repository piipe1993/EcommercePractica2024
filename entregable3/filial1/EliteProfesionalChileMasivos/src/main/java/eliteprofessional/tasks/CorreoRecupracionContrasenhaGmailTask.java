package eliteprofessional.tasks;



import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;


import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.GmailUI.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class CorreoRecupracionContrasenhaGmailTask implements Task {

    String correo;
    String clave;
    String asunto;
    public static List<WebElementFacade> elementosExpandir, linkRecuperacion = new ArrayList<>();

    public CorreoRecupracionContrasenhaGmailTask(String correo, String clave, String asunto) {
        this.correo = correo;
        this.clave = clave;
        this.asunto = asunto;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().navigate().to("https://www.google.com/intl/es-419/gmail/about/");

        actor.attemptsTo(
                WaitUntil.the(BTN_ACCEDER, isClickable()).forNoMoreThan(30).seconds(),
                Click.on( BTN_ACCEDER)
        );

        actor.attemptsTo(
                WaitUntil.the(INPUT_EMAIL, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(correo).into(INPUT_EMAIL),
                Click.on( BTN_SIGUIENTE)
        );
        UtilsWaits.wait(2);
        actor.attemptsTo(
                WaitUntil.the(INPUT_CLAVE, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(clave).into(INPUT_CLAVE),
                Click.on( BTN_SIGUIENTE_CLAVE)
        );

        actor.attemptsTo(
                WaitUntil.the(INPUT_BUSCAR, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(asunto).into(INPUT_BUSCAR),
                Hit.the(Keys.ENTER).keyIn(INPUT_BUSCAR)
        );
        UtilsWaits.wait(2);
        asunto=asunto.split(" ", 2)[0];
        actor.attemptsTo(
                WaitUntil.the(BTN_RESULTADO_BUSQUEDA(asunto), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_RESULTADO_BUSQUEDA(asunto))
        );
        UtilsWaits.wait(2);
        elementosExpandir=BTN_EXPANDIR_CONTENIDO.resolveAllFor(actor);
        int i= elementosExpandir.size();
        actor.attemptsTo(
                Scroll.to(elementosExpandir.get(i-1)).andAlignToBottom(),
                Click.on(elementosExpandir.get(i-1))
        );

        linkRecuperacion=LINK_RECUPERACION.resolveAllFor(actor);
        int j= linkRecuperacion.size();
        actor.attemptsTo(
                Scroll.to(linkRecuperacion.get(i-1)).andAlignToBottom(),
                Click.on(linkRecuperacion.get(i-1))
        );
    }
    public static CorreoRecupracionContrasenhaGmailTask ir(String correo, String clave, String asunto) {
        return Instrumented.instanceOf(CorreoRecupracionContrasenhaGmailTask.class).withProperties(correo, clave, asunto);
    }

}