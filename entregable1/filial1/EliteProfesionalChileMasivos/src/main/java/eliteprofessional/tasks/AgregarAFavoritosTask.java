package eliteprofessional.tasks;


import eliteprofessional.utils.TextoAList;
import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static eliteprofessional.userinterfaces.PaginaInicioUI.BTN_PRODUCTO_BUSCADO;
import static eliteprofessional.userinterfaces.PaginaInicioUI.INPUT_BUSCADOR;
import static eliteprofessional.userinterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class AgregarAFavoritosTask implements Task {

    public final String SKU;
    UtilsWaits utilsWaits= new UtilsWaits();
    TextoAList textoALista= new TextoAList();

    public AgregarAFavoritosTask( String SKU) {
        this.SKU = SKU;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Object> listSKU = textoALista.convertir(SKU) ;
            for (int i = 0; i < (listSKU.size()); i++) {
                String SKUIterar = (String) listSKU.get(i);
                actor.attemptsTo(
                        WaitUntil.the(INPUT_BUSCADOR, isEnabled()).forNoMoreThan(30).seconds()
                );

                actor.attemptsTo(
                        Enter.theValue(SKUIterar).into(INPUT_BUSCADOR)
                );
                actor.attemptsTo(
                        WaitUntil.the(BTN_PRODUCTO_BUSCADO, isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(BTN_PRODUCTO_BUSCADO)
                );

                actor.attemptsTo(
                        WaitUntil.the(BTN_PRODUCTOS, isClickable()).forNoMoreThan(60).seconds()
                );
                utilsWaits.wait(5);
                if (BTN_AGREGAR_A_FAVORITOS.isVisibleFor(actor)) {
                    actor.attemptsTo(
                            Click.on(BTN_AGREGAR_A_FAVORITOS),
                            WaitUntil.the(BTN_QUITAR_DE_FAVORITOS, isClickable()).forNoMoreThan(60).seconds()

                    );

                }
            }
    }



    public static Performable ir (String SKU) {
        return Instrumented.instanceOf(AgregarAFavoritosTask.class).withProperties(SKU);
    }
}