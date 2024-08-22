package eliteprofessional.tasks;


import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

import static eliteprofessional.userinterfaces.CotizarUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class DiligenciarFormularioCotizadorTask implements Task {

    private final DataTable datos;
    private final boolean agregarProducto;

    public DiligenciarFormularioCotizadorTask(DataTable datos, boolean agregarProducto) {

        this.datos = datos;
        this.agregarProducto=agregarProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, String>> rows = datos.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);
        String nombre = data.get("nombre");
        String apellido = data.get("apellido");
        String email= data.get("email");
        String telefono = data.get("telefono");
        String descripcion = data.get("descripcion");
        String productoInteres  = data.get("productoInteres");

        actor.attemptsTo(
                Enter.theValue(nombre).into(INPUT_NOMBRE),
                Enter.theValue(apellido).into(INPUT_APELLIDO),
                Enter.theValue(email).into(INPUT_EMAIL),
                Enter.theValue(telefono).into(INPUT_TELEFONO),
                Enter.theValue(descripcion).into(INPUT_DESCRIPCION)
        );
        if (agregarProducto) {
            actor.attemptsTo(
                    Enter.theValue(productoInteres).into(INPUT_PRODUCTO_INTERES),
                    SendKeys.of(Keys.ENTER).into(INPUT_PRODUCTO_INTERES)
            );

            actor.attemptsTo(
                    Click.on(BTN_PRODUCTO_INTERES(productoInteres))
            );
        }
            actor.attemptsTo(
                WaitUntil.the(LBL_PRODUCTO_SELECCIONADO, isVisible()).forNoMoreThan(60).seconds()
            );

        actor.attemptsTo(
                Click.on(BTN_ENVIAR),
                WaitUntil.the(POPPUP_COTIZACION_EXITOSA, isVisible()).forNoMoreThan(30).seconds()

        );



    }
    public static Performable ir (DataTable datos, boolean agregarProducto) {
        return Instrumented.instanceOf(DiligenciarFormularioCotizadorTask.class).withProperties(datos, agregarProducto );
    }
}