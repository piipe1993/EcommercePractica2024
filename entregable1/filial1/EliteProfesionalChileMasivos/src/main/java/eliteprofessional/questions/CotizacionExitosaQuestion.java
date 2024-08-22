package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.CotizarUI.POPPUP_COTIZACION_EXITOSA;

public class CotizacionExitosaQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return POPPUP_COTIZACION_EXITOSA.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> ir (){
        return new CotizacionExitosaQuestion();
    }

}
