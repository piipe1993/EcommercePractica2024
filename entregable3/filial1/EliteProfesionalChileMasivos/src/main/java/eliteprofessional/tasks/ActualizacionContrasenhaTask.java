package eliteprofessional.tasks;



import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;


import java.util.Set;

import static eliteprofessional.userinterfaces.ActualizacionContrasenhaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ActualizacionContrasenhaTask implements Task {

    String nuevaClave;


    public ActualizacionContrasenhaTask(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        int j=0;
        while ((windowHandles.size()<2) & (j<10)){
            windowHandles = getDriver().getWindowHandles();
            j=j+1;
        }
        if (j >10) {
            Serenity.recordReportData().withTitle("Existe un problemaal cargar la pagina de recuperacion de contraseña" )
                    .andContents("Existe un problemaal cargar la pagina de recuperacion de contraseña");
            Assert.fail ("Existe un problemaal cargar la pagina de recuperacion de contraseña" );
        }
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[2].toString());
            actor.attemptsTo(
                    WaitUntil.the(INPUT_NUEVA_CONTRASENHA, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(nuevaClave).into(INPUT_NUEVA_CONTRASENHA),
                    Enter.theValue(nuevaClave).into(INPUT_CONFIRMAR_CONTRASENHA),
                    Click.on(BTN_ACTUALIZAR)
            );

    }
    public static ActualizacionContrasenhaTask ir(String nuevaClave) {
        return Instrumented.instanceOf(ActualizacionContrasenhaTask.class).withProperties(nuevaClave);
    }

}