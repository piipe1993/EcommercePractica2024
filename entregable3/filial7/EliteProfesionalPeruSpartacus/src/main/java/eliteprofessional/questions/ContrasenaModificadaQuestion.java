package eliteprofessional.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.Serenity;

import static eliteprofessional.userinterfaces.CambiarContrasenaUI.MSJ_CAMBIO_EXITOSO;


public class ContrasenaModificadaQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Serenity.takeScreenshot();
        return MSJ_CAMBIO_EXITOSO.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> validarMensaje() {
        return new ContrasenaModificadaQuestion();
    }
}
