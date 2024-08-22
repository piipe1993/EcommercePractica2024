package eliteprofessional.tasks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static eliteprofessional.userinterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SolicitudCorreoRecuperacionTask implements Task {

    String correo;
    public WebElement recuperarContrasenhaButton ;

    public SolicitudCorreoRecuperacionTask(String correo) {
        this.correo = correo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            JavascriptExecutor jscriptExecutor = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
            actor.attemptsTo(
                    WaitUntil.the(BTN_INICIAR_SESION, isClickable()).forNoMoreThan(30).seconds()
            );
            recuperarContrasenhaButton = (WebElement) jscriptExecutor.executeScript("return  document.querySelector(\"body > app-root > cx-storefront > main > cx-page-layout > div > div.d-flex.login-template__section2-container > div > div\")");
            recuperarContrasenhaButton.click();
            Serenity.takeScreenshot();

            actor.attemptsTo(
                    WaitUntil.the(INPUT_EMAIL_OLVIDE_CONTRASENHA, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(correo).into(INPUT_EMAIL_OLVIDE_CONTRASENHA),
                    Click.on(BTN_ENVIAR_CORREO_RECUPERACION)
            );
            actor.attemptsTo(
                WaitUntil.the(ALERTA_CORREO_ENVIADO, isVisible()).forNoMoreThan(30).seconds()
             );
    }
    public static SolicitudCorreoRecuperacionTask ir(String correo) {
        return Instrumented.instanceOf(SolicitudCorreoRecuperacionTask.class).withProperties(correo);
    }

}