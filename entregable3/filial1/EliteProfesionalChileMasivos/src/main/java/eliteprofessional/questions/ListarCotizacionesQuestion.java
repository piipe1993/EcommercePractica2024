package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.CotizarUI.BTN_LISTADO_COTIZACIONES_NUEVA;

public class ListarCotizacionesQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return BTN_LISTADO_COTIZACIONES_NUEVA.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> ir (){
        return new ListarCotizacionesQuestion();
    }

}
