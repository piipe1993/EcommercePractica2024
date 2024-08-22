package eliteprofessional.tasks;


import eliteprofessional.interactions.EsperaExplicita;
import eliteprofessional.utils.UtilsWaits;
import eliteprofessional.utils.ValidarError;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class ComprarAgregarProductoAlCarritoDesdeProductoTask implements Task {

    UtilsWaits utilsWaits= new UtilsWaits();

    public final String cantidad,SKU;
    public static List<WebElementFacade> listaProductos=new ArrayList<>();
    public static List<WebElementFacade> listaBotonesProductos=new ArrayList<>();
    public static int sizelistaProductos, i;


    public ComprarAgregarProductoAlCarritoDesdeProductoTask(String cantidad, String SKU) {
        this.cantidad = cantidad;
        this.SKU = SKU;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_PRODUCTOS, isClickable()).forNoMoreThan(30).seconds()
        );

        utilsWaits.wait(5);

        listaProductos= LBL_SKU.resolveAllFor(actor);
        listaBotonesProductos=BTN_PRODUCTOS.resolveAllFor(actor);
        sizelistaProductos=listaProductos.size();
        boolean SKUexiste = false;
        i=0;

        while ((!SKUexiste) && (i!=sizelistaProductos)){
            i=sizelistaProductos;
            for (int j = 0; j < (sizelistaProductos); j++) {
                String textSKUTarget=listaProductos.get(j).getText();
                if(textSKUTarget.contains(SKU)){
                    SKUexiste = true;
                    j=sizelistaProductos;
                }
           }
            if  (!SKUexiste){
                actor.attemptsTo(
                        Scroll.to(listaBotonesProductos.get(sizelistaProductos-1))
               );
                actor.attemptsTo(
                        EsperaExplicita.enSegundos(5)
                );
                if (CONTAINER_LOADER.isVisibleFor(actor)) {
                    actor.attemptsTo(
                            WaitUntil.the(CONTAINER_LOADER, isNotVisible()).forNoMoreThan(30).seconds()
                    );
                }
                listaBotonesProductos=BTN_PRODUCTOS.resolveAllFor(actor);
                listaProductos= LBL_SKU.resolveAllFor(actor);
                sizelistaProductos=listaProductos.size();

            }
        }
        if  (!SKUexiste){
            Serenity.recordReportData().withTitle(" No se encontró SKU por favor verificar")
                    .andContents("No se encontró SKU por favor verificar");
            Assert.fail ("No se encontró SKU por favor verificar");

        }
        actor.attemptsTo(
                Scroll.to(IMG_PRODUCTO_STOCK(SKU)).andAlignToBottom()
        );


        actor.attemptsTo(
                MoveMouse.to(IMG_PRODUCTO_STOCK(SKU)),
                Click.on(IMG_PRODUCTO_STOCK(SKU))
        );

        actor.attemptsTo(
                WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(30).seconds()
        );
        utilsWaits.wait(5);
        int cantidadN= Integer.parseInt(cantidad);
        if (cantidadN >= 2) {
            if (cantidadN >2) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_AGREGAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                        MoveMouse.to(BTN_AGREGAR_PRODUCTO),
                        Click.on(BTN_AGREGAR_PRODUCTO)
                );
            }
            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );

            actor.attemptsTo(
                    Enter.theValue(String.valueOf(cantidadN-1)).into(INPUT_CANTIDAD_PRODUCTOS)
            );

            actor.attemptsTo(
                    WaitUntil.the(BTN_QUITAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    MoveMouse.to(BTN_QUITAR_PRODUCTO ),
                    Click.on(BTN_QUITAR_PRODUCTO )
            );

            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );


        } else {

            actor.attemptsTo(
                    WaitUntil.the(BTN_COMPRAR_PRODUCTO, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_COMPRAR_PRODUCTO)
            );
        }
        ValidarError.validar();
    }
    public static Performable ir (String cantidad,String SKU) {
        return Instrumented.instanceOf(ComprarAgregarProductoAlCarritoDesdeProductoTask.class).withProperties(cantidad,SKU);
    }
}