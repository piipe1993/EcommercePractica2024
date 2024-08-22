package eliteprofessional.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class EsperaExplicita implements Interaction {
    private int segundos;
    public EsperaExplicita(int segundos) {
        this.segundos = segundos;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos*1000);
        } catch (Exception e) {
        }
    }
    public static Performable enSegundos(int segundos){
        return Instrumented.instanceOf(EsperaExplicita.class).withProperties(segundos);
    }
}
