package eliteprofessional.tasks;


import eliteprofessional.interactions.EsperaExplicita;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class CotizarProductoCategoriaTask implements Task {

    public final String SKU;
    public static List<WebElementFacade> listaProductos=new ArrayList<>();
    public static List<WebElementFacade> listaBotonesProductos=new ArrayList<>();
    public static int sizelistaProductos, i;


    public CotizarProductoCategoriaTask(String SKU) {
        this.SKU = SKU;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_PRODUCTOS, isClickable()).forNoMoreThan(30).seconds()
        );

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

        if ((BTN_COMPRAR_PRODUCTO(SKU).resolveFor(actor).isVisible()) || (BTN_COMPRAR_PRODUCTO_SIN_STOCK(SKU).resolveFor(actor).isVisible())) {
            Serenity.recordReportData().withTitle(" El SKU Ingresado cuenta con precio por favor verificar")
                    .andContents(" El SKU Ingresado cuenta con precio");
            Assert.fail (" El SKU Ingresado cuenta con precio");
        }
        if (BTN_COTIZAR_PRODUCTO(SKU).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Scroll.to(BTN_COTIZAR_PRODUCTO(SKU)).andAlignToBottom()
            );

            actor.attemptsTo(
                    MoveMouse.to(BTN_COTIZAR_PRODUCTO(SKU)),
                    Click.on(BTN_COTIZAR_PRODUCTO(SKU))
            );

        }

        if (BTN_COTIZAR_PRODUCTO_SIN_STOCK(SKU).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Scroll.to(BTN_COTIZAR_PRODUCTO_SIN_STOCK(SKU)).andAlignToBottom()
            );

            actor.attemptsTo(
                    MoveMouse.to(BTN_COTIZAR_PRODUCTO_SIN_STOCK(SKU)),
                    Click.on(BTN_COTIZAR_PRODUCTO_SIN_STOCK(SKU))
            );

        }

        actor.attemptsTo(
                WaitUntil.the(BTN_IR_ALCOTIZADOR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_IR_ALCOTIZADOR)
        );

    }
    public static Performable ir (String SKU) {
        return Instrumented.instanceOf(CotizarProductoCategoriaTask.class).withProperties(SKU);
    }
}