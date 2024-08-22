package eliteprofessional.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import static eliteprofessional.userinterfaces.AccesosUI.MENSAJE_CONFIRMACION_RESET_PWD;

public class RestablecerContrasenaQuestion {

    public static Question<String> mensaje() {
        return actor -> TextContent.of(MENSAJE_CONFIRMACION_RESET_PWD).answeredBy(actor).toString().trim();
    }
}
