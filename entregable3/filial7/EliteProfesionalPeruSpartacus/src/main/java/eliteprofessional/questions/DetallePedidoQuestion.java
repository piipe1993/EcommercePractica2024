package eliteprofessional.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static eliteprofessional.userinterfaces.PedidosUI.LBL_PEDIDO;
public class DetallePedidoQuestion implements Question<Boolean> {

    String pedido;


    public DetallePedidoQuestion(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_PEDIDO (pedido).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> ir (String pedido){
        return new DetallePedidoQuestion(pedido);
    }

}
