package eliteprofessional.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.EstadoDeCuentaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class EstadoCuentaTask implements Task {

    public final String nDocumento;

    public EstadoCuentaTask(String nDocumento) {
        this.nDocumento = nDocumento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


          actor.attemptsTo(
                  WaitUntil.the(LBL_ESTADO_DE_CUENTA, isVisible()).forNoMoreThan(60).seconds(),
                  WaitUntil.the(TBL_RESULTADOS, isVisible()).forNoMoreThan(60).seconds()
          );

          Ensure.that(LBL_CREDITO_DISPONIBLE).isDisplayed();
          Ensure.that(LBL_TOTAL_A_PAGAR).isDisplayed();
          Ensure.that(LBL_SIGUIENTE_VENCIMIENTO).isDisplayed();

          actor.attemptsTo(
                  Scroll.to(BTN_DESCARGAR_EXCEL).andAlignToBottom(),
                  Click.on(BTN_DESCARGAR_EXCEL)
          );

        if ((!LBL_SIN_FACTURAS.isVisibleFor(actor))&&(nDocumento!=null)){
        actor.attemptsTo(
                Scroll.to(SLT_FILTRAR_POR).andAlignToBottom(),
                SelectFromOptions.byVisibleText("N° DOCUMENTO").from(SLT_FILTRAR_POR),
                Enter.keyValues(nDocumento).into(INPUT_DOCUMENTO),
                Click.on(BTN_BUSCAR)
        );

        actor.attemptsTo(
                WaitUntil.the(LBL_DOCUMENTO_RESULTADO(nDocumento), isVisible()).forNoMoreThan(60).seconds()
        );

        actor.attemptsTo(
                Scroll.to(LBL_DOCUMENTO_RESULTADO(nDocumento)).andAlignToBottom()
        );
        }
    }
    public static Performable ir (String nDocuemnto) {
        return Instrumented.instanceOf(EstadoCuentaTask.class).withProperties(nDocuemnto);
    }
}