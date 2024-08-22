package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.FinalizacionCompraUI.LBL_COMPRA_RECIBIDA;

public class CompraRecibidaQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_COMPRA_RECIBIDA.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> ir (){
        return new CompraRecibidaQuestion();
    }

}
