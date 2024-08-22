package eliteprofessional.tasks;

import eliteprofessional.utils.PaginaStateRedy;
import eliteprofessional.utils.StringToMap;
import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.text.Collator;
import java.util.List;
import java.util.Map;

import static eliteprofessional.userinterfaces.CatalogoUI.BTN_MENU;
import static eliteprofessional.userinterfaces.CatalogoUI.BTN_SUBMENU;
import static eliteprofessional.userinterfaces.PaginaInicioUI.LBL_CATEGORIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ExplorarCategoriasYSubCategoriasTask implements Task {

    String categorias;

    public ExplorarCategoriasYSubCategoriasTask(String categorias) {
        this.categorias = categorias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String subCategoriaResult;
        Map<String, List<String>> categoriasySubCategoriasMap = StringToMap.convertir(categorias);
        for (Map.Entry<String, List<String>> entry : categoriasySubCategoriasMap.entrySet()) {
            String categoria = entry.getKey();
            List<String> subCategorias = entry.getValue();
            for (String subCategoria : subCategorias) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_MENU(categoria), isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_MENU(categoria))
                );
                boolean clickSubCategoria=false;
                int i=1;
                while ((!clickSubCategoria)&& (i<5)) {
                    if (BTN_SUBMENU(subCategoria,i).isVisibleFor(actor)) {
                        actor.attemptsTo(
                                Click.on(BTN_SUBMENU(subCategoria,i))
                        );
                        clickSubCategoria = true;
                    }
                    i=i+1;
                }

                if (!clickSubCategoria){
                    Serenity.recordReportData().withTitle(" No se encontro el subMenu:"+subCategoria)
                            .andContents(" No se encontro el subMenu:"+subCategoria);
                    Assert.fail (" No se encontro el subMenu:"+subCategoria);
                }
                PaginaStateRedy.completed();
                Collator comparador = Collator.getInstance();
                comparador.setStrength(Collator.PRIMARY);
                actor.attemptsTo(WaitUntil.the(LBL_CATEGORIA, isEnabled()).forNoMoreThan(30).seconds());
                subCategoriaResult= LBL_CATEGORIA.resolveFor(actor).getText().trim();
                if (comparador.compare(subCategoriaResult,subCategoria)==0) {
                    actor.attemptsTo(
                    Scroll.to(LBL_CATEGORIA).andAlignToBottom()
                    );
                    Serenity.takeScreenshot();
                    Serenity.recordReportData().withTitle(" SubCategoria Validada " + subCategoriaResult+" dentro de la Categoria: "+categoria)
                            .andContents(" SubCategoria Validada " + subCategoriaResult+" dentro de la Categoria: "+categoria);
                } else{
                Serenity.recordReportData().withTitle("Advertencia: La SubCategoria: "+subCategoria+" fue Validada con otro nombre: "+subCategoriaResult+" dentro de la Categoria: "+categoria)
                        .andContents("Advertencia: La SubCategoria: "+subCategoria+" fue Validada con otro nombre: "+subCategoriaResult+" dentro de la Categoria: "+categoria);
            }
                UtilsWaits.wait(2);
        }
      }
    }


    public static Performable ir (String categorias) {
        return Instrumented.instanceOf(ExplorarCategoriasYSubCategoriasTask.class).withProperties(categorias);
    }
}


