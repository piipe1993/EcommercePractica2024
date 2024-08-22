package eliteprofessional.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static eliteprofessional.userinterfaces.CatalogoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IngresarAlCatalogoCategoriaTask implements Task {

    String categoria;
    String subCategoria;

    public IngresarAlCatalogoCategoriaTask(String categoria, String subCategoria) {
        this.categoria = categoria;
        this.subCategoria = subCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch(categoria) {
            case "MIS PRODUCTOS":
                actor.attemptsTo(
                        WaitUntil.the(BTN_MIS_PPODUCTOS, isClickable()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_MIS_PPODUCTOS)
                );
                break;

            case "Papeles":
                actor.attemptsTo(
                        WaitUntil.the(BTN_PAPELES, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_PAPELES)
                );

                switch(subCategoria) {

                    case "Pañuelos Desechables":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PANHUELOS_DESECHABLES, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_PANHUELOS_DESECHABLES)
                        );
                        break;

                    case "Papel Higienico":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PAPEL_HIGIENICO, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_PAPEL_HIGIENICO)
                        );
                        break;

                    case "Servilletas":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SERVILLETAS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SERVILLETAS)
                        );
                        break;


                    case "Toallas papel":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TOALLAS_PAPEL, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TOALLAS_PAPEL)
                        );
                        break;

                    case "Trapero Humedo":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TRAPERO_HUMEDO, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TRAPERO_HUMEDO)
                        );
                        break;


                    case "Wipes":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_WIPES, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_WIPES)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );

                }

                break;


            case "Cuidado Bebé":
                actor.attemptsTo(
                        WaitUntil.the(BTN_CUIDADO_BEBE, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_CUIDADO_BEBE)
                );

                switch(subCategoria) {

                    case "Pañales":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PANHALES_BEBES, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_PANHALES_BEBES)
                        );
                        break;

                    case "Toallas húmedas":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TOALLAS_HUMEDAS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TOALLAS_HUMEDAS)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );
                }

                break;

            case "Higiene":
                actor.attemptsTo(
                        WaitUntil.the(BTN_HIGIENE, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_HIGIENE)
                );

                switch(subCategoria) {

                    case "Alcohol Gel":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_ALCOHOL_GEL, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_ALCOHOL_GEL)
                        );
                        break;

                    case "Jabon Barra":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_JABON_BARRA, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_JABON_BARRA)
                        );
                        break;

                    case "Jabon Liquido":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_JABON_LIQUIDO, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_JABON_LIQUIDO)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );

                }

                break;



            case "Protección Adultos":
                actor.attemptsTo(
                        WaitUntil.the(BTN_PROTECCCION_ADULTOS, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_PROTECCCION_ADULTOS)
                );

                switch(subCategoria) {

                    case "Apositos":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_APOSITOS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_APOSITOS)
                        );
                        break;

                    case "Pants":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PANTS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_PANTS)
                        );
                        break;

                    case "Sabanillas y Toallas Humedas":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SABANILLAS_TOALLAS_HUMEDAS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SABANILLAS_TOALLAS_HUMEDAS)
                        );
                        break;

                    case "Toallas para Incontinencia Urinaria":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TOALLAS_INCONTINENCIA_URINARIA, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TOALLAS_INCONTINENCIA_URINARIA)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );

                }

                break;

            case "Protección Femenina":
                actor.attemptsTo(
                        WaitUntil.the(BTN_PROTECCION_FEMENINA, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_PROTECCION_FEMENINA)
                );
                switch(subCategoria) {

                    case "Protectores Diarios":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_PROTECTORES_DIARIOS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_PROTECTORES_DIARIOS)
                        );
                        break;

                    case "Tampones":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TAMPONES, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TAMPONES)
                        );
                        break;

                    case "Sabanillas y Toallas Humedas":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SABANILLAS_TOALLAS_HUMEDAS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SABANILLAS_TOALLAS_HUMEDAS)
                        );
                        break;

                    case "Toallas Higiénicas":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_TOALLAS_HIGIENICAS, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_TOALLAS_HIGIENICAS)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );

                }
                break;


            case "Marcas":
                actor.attemptsTo(
                        WaitUntil.the(BTN_MARCAS, isClickable()).forNoMoreThan(30).seconds(),
                        MoveMouse.to(BTN_MARCAS)
                );
                switch(subCategoria) {

                    case "Elite":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_ELITE, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_ELITE)
                        );
                        break;

                    case "Baby Sec":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_BABYSEC, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_BABYSEC)
                        );
                        break;

                    case "Nova":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_NOVA, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_NOVA)
                        );
                        break;


                    case "Confort":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_COMFORT , isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_COMFORT )
                        );
                        break;

                    case "Lady Soft":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_LADYSOFT, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_LADYSOFT)
                        );
                        break;


                    case "Abolengo":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_ABOLENGO, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_ABOLENGO)
                        );
                        break;

                    case "Cotidian":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_COTIDIAN, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_COTIDIAN)
                        );
                        break;

                    case "Noble":
                        actor.attemptsTo(
                                WaitUntil.the(BTN_NOBLE, isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_NOBLE)
                        );
                        break;

                    default:
                        actor.attemptsTo(
                                WaitUntil.the(BTN_SUBMENU(subCategoria,1), isClickable()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SUBMENU(subCategoria,1))
                        );
                }
                break;

            default:
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

       }




    }

    public static Performable ir (String categoria, String subCategoria) {
        return Instrumented.instanceOf(IngresarAlCatalogoCategoriaTask.class).withProperties(categoria, subCategoria);
    }
}
