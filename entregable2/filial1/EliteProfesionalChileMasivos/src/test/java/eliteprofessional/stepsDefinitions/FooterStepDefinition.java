package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.ValidacionCatalogosQuestion;
import eliteprofessional.questions.ValidacionLinksFooterQuestion;
import eliteprofessional.questions.ValidacionLinksFooterStrongTitleQuestion;
import eliteprofessional.questions.ValidacionLinksFooterTitlesQuestion;
import eliteprofessional.tasks.CentroDeAyudaTask;
import eliteprofessional.tasks.FooterTask;
import eliteprofessional.tasks.RedesSocialesTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.Assert;

public class FooterStepDefinition {

    @Cuando("el usuario se dirige a Quienes Somos")
    public void elUsuarioSeDirigeAQuienesSomos() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Quienes Somos"));

    }

    @Entonces("el usuario valida el landing page de la informacion de la empresa")
    public void elUsuarioValidaElLandingPageDeLaInformacionDeLaEmpresa() {
        Assert.assertTrue("Validacion Titulo Landing Page Quienes Somos",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterTitlesQuestion.ir("Quienes Somos","Quienes Somos")));
    }


    @Cuando("el usuario se dirige al Servicio de Atencion")
    public void elUsuarioSeDirigeAlServicioDeAtencion() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Servicio de Atencion"));
    }

    @Entonces("el usuario valida el landing page de Servicio de Atencion de la empresa")
    public void elUsuarioValidaElLandingPageDeServicioDeAtencionDeLaEmpresa() {
        Assert.assertTrue("Validacion Titulo Landing Page Servicio de Atencion",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterQuestion.ir("Servicio de Atencion","Servi")));


    }

    @Cuando("el usuario se dirige a Certificaciones")
    public void elUsuarioSeDirigeACertificaciones() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Certificaciones"));
    }

    @Entonces("el usuario valida el landing page de Certificaciones")
    public void elUsuarioValidaElLandingPageDeCertificaciones() {
        Assert.assertTrue("Validacion Titulo Landing Page Certificaciones",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterTitlesQuestion.ir("Certificaciones","CERTIFI")));
    }

    @Cuando("el usuario se dirige a Novedades")
    public void elUsuarioSeDirigeANovedades() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Novedades"));
    }

    @Entonces("el usuario valida el landing page de Novedades")
    public void elUsuarioValidaElLandingPageDeNovedades() {
        Assert.assertTrue("Validacion Titulo Landing Page Novedades",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterStrongTitleQuestion.ir("Novedades","Nov")));

    }

    @Cuando("el usuario se dirige a Catalogo")
    public void elUsuarioSeDirigeACatalogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Elite Profissional"));

    }

    @Entonces("el usuario valida que se muestra el Catalogo Elite Profesional")
    public void elUsuarioValidaQueSeMuestraElCatalogoEliteProfesional() {
        Assert.assertTrue("Validacion Catalogo Elite Profesional",OnStage.theActorInTheSpotlight().asksFor(ValidacionCatalogosQuestion.ir()));

    }

    @Cuando("el usuario se dirige a Terminos y Condiciones")
    public void elUsuarioSeDirigeATerminosYCondiciones() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Terminos y Condiciones"));
    }

    @Entonces("el usuario valida el landing page de Terminos y Condiciones")
    public void elUsuarioValidaElLandingPageDeTerminosYCondiciones() {
        Assert.assertTrue("Validacion Titulo Landing Page Terminos y Condiciones",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterQuestion.ir("Terminos y Condiciones","CONDI")));
    }

    @Cuando("el usuario se dirige a la Politica Proteccion de Datos Personales y Privacidad")
    public void elUsuarioSeDirigeALaPoliticaProteccionDeDatosPersonalesYPrivacidad() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Politica Proteccion de Datos Personales y Privacidad"));

    }

    @Entonces("el usuario valida el landing page de Politica Proteccion de Datos Personales y Privacidad")
    public void elUsuarioValidaElLandingPageDePoliticaProteccionDeDatosPersonalesYPrivacidad() {
        Assert.assertTrue("Validacion Titulo Landing Page Politica Proteccion de Datos Personales y Privacidad",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterQuestion.ir("Politica Proteccion de Datos Personales y Privacidad","Política de Protección de Datos Personales y Privacidad")));

    }

    @Cuando("el usuario se dirige a la Politica de Cookies")
    public void elUsuarioSeDirigeALaPoliticaDeCookies() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Politica de Cookies"));

    }

    @Entonces("el usuario valida el landing page de la Cookies")
    public void elUsuarioValidaElLandingPageDeLaCookies() {
        Assert.assertTrue("Validacion Titulo Landing Page Politica de Cookies",OnStage.theActorInTheSpotlight().asksFor(ValidacionLinksFooterStrongTitleQuestion.ir("Politica de Cookies","POLÍTICA DE COOKIES")));
    }

    @Cuando("el usuario se dirige al Centro de Ayuda")
    public void elUsuarioSeDirigeAlCentroDeAyuda() {
        OnStage.theActorInTheSpotlight().attemptsTo(FooterTask.ir("Centro de Ayuda"));

    }

    @Entonces("el usuario valida el landing page del Centro de Ayuda")
    public void elUsuarioValidaElLandingPageDelCentroDeAyuda() {
        OnStage.theActorInTheSpotlight().attemptsTo(CentroDeAyudaTask.ir());
    }

    @Entonces("el usuario valida cada una de la redes Sociales")
    public void elUsuarioValidaCadaUnaDeLaRedesSociales() {
        OnStage.theActorInTheSpotlight().attemptsTo(RedesSocialesTask.ir());

    }

}
