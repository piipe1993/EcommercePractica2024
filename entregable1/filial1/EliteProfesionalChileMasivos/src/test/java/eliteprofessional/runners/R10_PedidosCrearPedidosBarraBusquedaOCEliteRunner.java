package eliteprofessional.runners;


import eliteprofessional.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@crearPedidoBarraBusquedaOC",
        glue = "eliteprofessional.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class R10_PedidosCrearPedidosBarraBusquedaOCEliteRunner {
    @utils.BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
      DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
