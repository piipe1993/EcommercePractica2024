package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.FooterUI.LBL_VALIDACION;

public class ValidacionLinksFooterQuestion implements Question<Boolean> {

    String label, localizador;

    public ValidacionLinksFooterQuestion(String label, String localizador) {
        this.label = label;
        this.localizador = localizador;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_VALIDACION(label,localizador).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> ir (String label,String localizador){
        return new ValidacionLinksFooterQuestion(label,localizador);
    }

}
