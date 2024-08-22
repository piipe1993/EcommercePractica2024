package eliteprofessional.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static eliteprofessional.userinterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IniciarSesionAsmTask implements Task {

    String agentId;
    String clave;
    String correo;

    public IniciarSesionAsmTask(String agentId, String password, String correo) {

        this.agentId = agentId;
        this.clave = password;
        this.correo = correo;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_AGENTID, isClickable()).forNoMoreThan(8).seconds(),
                Enter.theValue(agentId).into(TXT_AGENTID),
                WaitUntil.the(TXT_PASSWORD, isClickable()).forNoMoreThan(2).seconds(),
                Enter.theValue(clave).into(TXT_PASSWORD).thenHit(Keys.TAB).thenHit(Keys.TAB).thenHit(Keys.ENTER),
               // Click.on(BTN_SIGIN),
                WaitUntil.the(TXT_CUSTOMER_EMAIL, isClickable()).forNoMoreThan(3).seconds(),
                Enter.theValue(correo).into(TXT_CUSTOMER_EMAIL),
                WaitUntil.the(RESULTADO_BUSQUEDA_CUSTOMER, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(RESULTADO_BUSQUEDA_CUSTOMER),
                Click.on(BTN_START_SESION)

        );
    }

    public static IniciarSesionAsmTask conUserAsm(String agentId, String clave, String correo) {
        return instrumented(IniciarSesionAsmTask.class, agentId, clave, correo);

    }
}
