package eliteprofessional.runners;

import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@crearPedidoBonificadoMisProductosOC",
        glue = "eliteprofessional.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class R13_PedidoMisProductosProductoBonificadoRunner {

    @utils.BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        eliteprofessional.utils.DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
