package eliteprofessional.tasks;


import eliteprofessional.utils.TextoAList;
import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.junit.Assert;

import java.util.List;


public class ComprarBarraBusquedaVariosTask implements Task {

    public final String cantidad, SKU;
    UtilsWaits utilsWaits= new UtilsWaits();
    TextoAList textoALista= new TextoAList();

    public ComprarBarraBusquedaVariosTask(String cantidad, String SKU) {
        this.cantidad = cantidad;
        this.SKU = SKU;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Object> listCantidad = textoALista.convertir(cantidad) ;
        List<Object> listSKU = textoALista.convertir(SKU) ;


        if (listCantidad.size()!=listSKU.size()){
            Serenity.recordReportData().withTitle(" La cantidad de Producots (SKU) a buscar debe ser igual a la cantidad de productos ")
                    .andContents("La cantidad de Producots (SKU) a buscar debe ser igual a la cantidad de productos  ");
            Assert.fail ("La cantidad de Producots (SKU) a buscar debe ser igual a la cantidad de productos ");
        }else{

            for (int i = 0; i < (listCantidad.size()); i++) {
                String cantidadIterar = (String) listCantidad.get(i);
                String SKUIterar = (String) listSKU.get(i);
                actor.attemptsTo(
                ComprarBarraBusquedaTask.ir(SKUIterar, cantidadIterar)
                );
            }
        }


    }
    public static Performable ir (String SKU, String cantidad) {
        return Instrumented.instanceOf(ComprarBarraBusquedaVariosTask.class).withProperties(SKU, cantidad);
    }
}