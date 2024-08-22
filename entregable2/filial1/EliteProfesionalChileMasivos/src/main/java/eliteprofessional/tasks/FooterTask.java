package eliteprofessional.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static eliteprofessional.userinterfaces.FooterUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class FooterTask implements Task {

    String opcionFooter;

    public FooterTask(String opcionFooter) {
        this.opcionFooter = opcionFooter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(FOOTER).andAlignToBottom() );

        switch(opcionFooter) {
            case "Quienes Somos":
                actor.attemptsTo(
                        WaitUntil.the(LINK_QUIENES_SOMOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_QUIENES_SOMOS)
                );
                break;

            case "Servicio de Atencion":
                actor.attemptsTo(
                        WaitUntil.the(LINK_SERVICIO_DE_ATENCION, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_SERVICIO_DE_ATENCION)
                );
                break;

            case "Certificaciones":
                actor.attemptsTo(
                        WaitUntil.the(LINK_CERTIFICACIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_CERTIFICACIONES)
                );
                break;
            case "Novedades":
                actor.attemptsTo(
                        WaitUntil.the(LINK_NOVEDADES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_NOVEDADES)
                );
                break;

            case "Elite Profissional":
                actor.attemptsTo(
                        WaitUntil.the(LINK_CATALOGO_ELITE_PROFESIONAL, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_CATALOGO_ELITE_PROFESIONAL)
                );
                break;
            case "Terminos y Condiciones":
                actor.attemptsTo(
                        WaitUntil.the(LINK_TERMINOS_Y_CONDICIONES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_TERMINOS_Y_CONDICIONES)
                );
                break;

            case "Politica Proteccion de Datos Personales y Privacidad":
                actor.attemptsTo(
                        WaitUntil.the(LINK_POLITICA_DE_PROTECCION_DE_DATOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_POLITICA_DE_PROTECCION_DE_DATOS)
                );
                break;


            case "Politica de Cookies":
                actor.attemptsTo(
                        WaitUntil.the(LINK_POLITICA_DE_COOKIES, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_POLITICA_DE_COOKIES)
                );
                break;


            case "Centro de Ayuda":
                actor.attemptsTo(
                        WaitUntil.the(LINK_CENTRO_DE_AYUDA, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(LINK_CENTRO_DE_AYUDA)
                );
                break;
        }
    }
    public static Performable ir (String opcionFooter) {
        return Instrumented.instanceOf(FooterTask.class).withProperties(opcionFooter);
    }
}
