package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static eliteprofessional.userinterfaces.PedidosUI.ALERT_PROCESANDO_CANCELACION;

public class PedidoCanceladoQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ALERT_PROCESANDO_CANCELACION.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> validar (){return new PedidoCanceladoQuestion();
    }
}
