package eliteprofessional.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.InicioSesionUI.*;
import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class IniciarSesionTask implements Task {
    String correo;
    String clave;
    String idDestinatario;

    public IniciarSesionTask(String correo, String clave, String idDestinatario) {
        this.correo = correo;
        this.clave = clave;
        this.idDestinatario=idDestinatario;

    }
    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    WaitUntil.the(BTN_INICIAR_SESION, isClickable()).forNoMoreThan(30).seconds(),
                    Enter.theValue(correo).into(INPUT_EMAIL),
                    Enter.theValue(clave).into(INPUT_CONTRASENHA),
                    Click.on(BTN_INICIAR_SESION),
                    WaitUntil.the(BTN_INICIAR_SESION, isNotVisible()).forNoMoreThan(60).seconds()
            );

        if (BTN_ACEPTAR_COOKIES.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(BTN_ACEPTAR_COOKIES),
                    WaitUntil.the(POPUP_COOKIES, isNotVisible()).forNoMoreThan(30).seconds()
            );
        }

        if (POPUP_DESTINATARIO.isVisibleFor(actor)) {
            if (idDestinatario==null){
                Serenity.recordReportData().withTitle(" No se encontró un id de Destinatario ")
                        .andContents("Por favor ingrese el idDestinatario en el archivo de la Data ");
                Assert.fail ("No se encontró un id de Destinatario");
            }
            actor.attemptsTo(Enter.theValue(idDestinatario).into(INPUT_DESTINATARIO));
            if (LBL_DESTINATARIO.isVisibleFor(actor)) {
                actor.attemptsTo(
                        Click.on(LBL_DESTINATARIO),
                        Click.on(BTN_SELECCIONAR_DESTINATARIO),
                        WaitUntil.the(POPUP_DESTINATARIO, isNotVisible()).forNoMoreThan(30).seconds()
                );
            }else{
                Serenity.recordReportData().withTitle(" No se encuentra idDestinatario: "+idDestinatario +" Ingresado")
                        .andContents("Por favor ingrese un idDestinatario valido para esta sucursal en el archivo de la Data ");
                Assert.fail ("No se encuentra idDestinatario suministrado");
            }
        }





    }
    public static IniciarSesionTask onThePage(String correo, String clave, String idDestinatario) {
        return Instrumented.instanceOf(IniciarSesionTask.class).withProperties(correo, clave, idDestinatario);
    }
}