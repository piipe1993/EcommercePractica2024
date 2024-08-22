package eliteprofessional.stepsDefinitions;

import eliteprofessional.questions.CompraRecibidaQuestion;
import eliteprofessional.questions.DetallePedidoQuestion;
import eliteprofessional.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class PedidosStepDefinition {

    @Cuando("el usuario ingresa a  Mis Productos")
    public void elUsuarioIngresaAMisProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCatalogoCategoriaTask.ir("MIS PRODUCTOS", ""));
    }


    @Y("el usuario agrega prodcutos a la compra {string} {string}")
    public void elUsuarioAgregaProdcutosALaCompraCantidad(String cantidad, String SKUPrimerProducto ) {
        OnStage.theActorInTheSpotlight().attemptsTo(ComprarAgregarProductoAlCarritoDesdeCatalogoTask.ir(cantidad,SKUPrimerProducto));

    }

    @Y("el usuario aplica filtros {string} {string}")
    public void elUsuarioAplicaFiltros(String filtro, String valorFiltro) {
        OnStage.theActorInTheSpotlight().attemptsTo(FiltrarProductosCatalaogoTask.ir(filtro,valorFiltro));

    }

    @Y("el usuario ingresa al producto a comprar {string} {string}")
    public void elUsuarioIngresaAlProdcutoAComprar(String SKUSegundoProducto,String cantidadSegundoProducto ) {
        OnStage.theActorInTheSpotlight().attemptsTo(ComprarAgregarProductoAlCarritoDesdeProductoTask.ir(cantidadSegundoProducto, SKUSegundoProducto));

    }

    @Y("el usuario se dirige al carrito de compras")
    public void elUsuarioSeDirigeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo( CarritoDeComprasTask.ir("Ir a pagar"));

    }

    @Y("el usuario finaliza el proceso de compra {string} {string} {string}")
    public void elUsuarioFinalizaElProcesoDeCompra(String numeroOC, String comentarios, String tipoEnvio ) {
        OnStage.theActorInTheSpotlight().attemptsTo( ComprarFinalizarCompraTask.ir(numeroOC, comentarios, tipoEnvio, false ));

    }

    @Y("el usuario finaliza el proceso de compra adjuntando OC{string} {string} {string}")
    public void elUsuarioFinalizaElProcesoDeCompraAdjuntandoOC(String numeroOC, String comentarios, String tipoEnvio ) {
        OnStage.theActorInTheSpotlight().attemptsTo( ComprarFinalizarCompraTask.ir(numeroOC, comentarios, tipoEnvio, true ));
    }

    @Cuando("el usuario Busca un Producto desde el Buscador {string} {string}")
    public void elUsuarioBuscaUnProductoDesdeElBuscador(String SKU, String cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(ComprarBarraBusquedaTask.ir(SKU, cantidad));
    }

    @Cuando("el usuario Busca Productos desde el Buscador {string} {string}")
    public void elUsuarioBuscaProductosDesdeElBuscador(String SKU, String cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(ComprarBarraBusquedaVariosTask.ir(SKU, cantidad));
    }

    @Cuando("el usuario Agrega Productos a Mis Favoritos {string}")
    public void elUsuarioAgregaProductosAMisFavoritos(String SKU) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarAFavoritosTask.ir(SKU));

    }


    @Y("el usuario agrega prodcutos a la compra {string} {string} en Mis Favoritos")
    public void elUsuarioAgregaProdcutosALaCompraEnMisFavoritos(String SKU, String cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Mis Favoritos"));
        OnStage.theActorInTheSpotlight().attemptsTo( ComprarAgreagarProductosDesdeMisFavoritosTask.ir(SKU, cantidad));


    }

    @Entonces("el usuario visualizara que su compra fue recibida exitosamente")
    public void elUsuarioVisualizaraQueSuCompraFueRecibidaExitosamente() {
        OnStage.theActorInTheSpotlight().asksFor(CompraRecibidaQuestion.ir());
    }


    @Cuando("el usuario ingresa a  la opcion Seguimiento Pedidos")
    public void elUsuarioIngresaALaOpcionSeguimientoPedidos() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlMenuTask.ir("Seguimiento pedidos"));

    }

    @Y("el usuario busca el pedido {string} para visualizar su estado")
    public void elUsuarioBuscaElPedidoParaVisualizarSuEstado(String numeroPedido) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarPedidoSeguimientoPedidoTask.ir(numeroPedido));
        OnStage.theActorInTheSpotlight().asksFor(DetallePedidoQuestion.ir(numeroPedido));
    }
}
