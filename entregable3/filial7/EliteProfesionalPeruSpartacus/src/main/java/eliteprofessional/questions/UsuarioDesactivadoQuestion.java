package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.AccesosUI.TOGGLE_OFF_ACTIVACION_USUARIO;


public class UsuarioDesactivadoQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return TOGGLE_OFF_ACTIVACION_USUARIO.resolveFor(actor).isClickable();
    }

    public static Question<Boolean> validarEstado (){
        return new UsuarioDesactivadoQuestion();
    }

}
