package eliteprofessional.tasks;


import eliteprofessional.utils.ValidarError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Path;


import static eliteprofessional.userinterfaces.OrdenRapidaUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class IngresarOrdenRapidaPorPlantillaTask implements Task {


    private final boolean adjuntarOC;

    public IngresarOrdenRapidaPorPlantillaTask(boolean adjuntarOC) {
        this.adjuntarOC=adjuntarOC;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(INPUT_PLANILLA, isEnabled()).forNoMoreThan(60).seconds()
        );

        Path fileToUploadPedido = Path.of("Data\\Pedido.xls");
        actor.attemptsTo(Upload.theFile(fileToUploadPedido).to(INPUT_PLANILLA));

        ValidarError.validar(POPUP_ERROR);

        actor.attemptsTo(
                WaitUntil.the(LBL_PLANILLA_FILE, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_CONFIRMAR_PLANILLA).andAlignToBottom()
        );

        if (adjuntarOC) {
            Path fileToUploadOC = Path.of("Data\\OC.zip");
            actor.attemptsTo(Upload.theFile(fileToUploadOC).to(INPUT_OC_FILE));


        ValidarError.validar(POPUP_ERROR);

        actor.attemptsTo(
                WaitUntil.the(LBL_OC_FILE, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_CONFIRMAR_PLANILLA).andAlignToBottom()
        );
        }


        actor.attemptsTo(
                WaitUntil.the(CHK_TERMINOS_CONDICIONES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(CHK_TERMINOS_CONDICIONES),
                Click.on(BTN_CONFIRMAR_PLANILLA)
        );

        actor.attemptsTo(
                WaitUntil.the(LOADING_BTN, isNotVisible()).forNoMoreThan(30).seconds()
        );

        ValidarError.validar(POPUP_ERROR);

        actor.attemptsTo(
                WaitUntil.the(LBL_PEDIDO_EXITOSO, isNotVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LINK_HISTORIAL_PEDIDOS , isClickable()).forNoMoreThan(60).seconds(),
                Scroll.to(LINK_HISTORIAL_PEDIDOS).andAlignToBottom(),
                Click.on(LINK_HISTORIAL_PEDIDOS)
        );

        ValidarError.validar(POPUP_ERROR);

    }
    public static IngresarOrdenRapidaPorPlantillaTask ir(boolean adjuntarOC){
        return instrumented(IngresarOrdenRapidaPorPlantillaTask.class, adjuntarOC);
    }
}