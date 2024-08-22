package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class ProductosUI extends PageObject {

    public static final Target LBL_SKU = Target.the("Label SKU").locatedBy("//div[@class='skuCode'][ancestor::main]");
    public static final Target CONTAINER_LOADER = Target.the("Loader Cargar").locatedBy("//div[@class='loader'][ancestor::main]");
    public static final Target BTN_MIS_PPODUCTOS = Target.the("Boton Menu MIS PRODUCTOS").locatedBy("//span[contains(text(),'MIS PRODUCTOS')][ancestor::div[@class='menu']]");
    public static final Target BTN_PRODUCTOS = Target.the("Botones Productos").locatedBy("//button[contains(text(),'Co')][ancestor::main]");
    public static final Target BTN_IR_ALCOTIZADOR= Target.the("Boton ir al cotizador").locatedBy("//button[contains(text(),'ir al cotizador')][ancestor::main]");

    public static final Target LBL_MIS_PRODUSTOS = Target.the("Label Mis Productos").locatedBy("//div[@class='skuCode'][ancestor::main]");


    public static Target BTN_COTIZAR_PRODUCTO (String SKU){
        return Target.the("Cotizar Producto con SKU:  "+ SKU).locatedBy("//button[contains(text(),'Cotizar')][(preceding::div[2][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target BTN_COMPRAR_PRODUCTO (String SKU){
        return Target.the("Comprar Producto con SKU: "+ SKU).locatedBy("//button[contains(text(),'Comprar')][(preceding::div[3][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }
    public static Target BTN_COMPRAR_PRODUCTO_SIN_STOCK (String SKU){
        return Target.the("Comprar Producto sin Stock con SKU: "+ SKU).locatedBy("//button[contains(text(),'Comprar')][(preceding::div[5][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target BTN_AGREGAR_PRODUCTO(String SKU){
        return Target.the("Agregar Producto con SKU: "+ SKU).locatedBy("//button[contains(text(),'+')][(preceding::div[2][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target BTN_AGREGAR_PRODUCTO_SIN_STOCK(String SKU){
        return Target.the("Agregar Producto sin Stock con SKU: "+ SKU).locatedBy("//button[contains(text(),'+')][(preceding::div[4][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target BTN_QUITAR_PRODUCTO(String SKU){
        return Target.the("Quitar Producto con SKU: "+ SKU).locatedBy("//button[contains(text(),'-')][(preceding::div[2][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target BTN_QUITAR_PRODUCTO_SIN_STOCK(String SKU){
        return Target.the("Quitar Producto sin Stock con SKU: "+ SKU).locatedBy("//button[contains(text(),'-')][(preceding::div[4][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target INPUT_CANTIDAD_PRODUCTO(String SKU){
        return Target.the("Input Cantidad Producto con SKU: "+ SKU).locatedBy("//input[@type='number'][(preceding::div[2][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target INPUT_CANTIDAD_PRODUCTO_SIN_STOCK(String SKU){
        return Target.the("Agregar Cantidad Producto sin Stock con SKU: "+ SKU).locatedBy("//input[@type='number'][(preceding::div[4][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static Target LBL_PRODUCTO_AGREGADOO_AL_CARRITO = Target.the("Label Producto Agregado al Carrito").locatedBy("//p[contains(text(),'El producto se ha agregado al carrito correctamente.')][ancestor::*[@class='MiniCart has-components']]");


    public static Target BTN_FILTRO_CONTRAER(String filtro){
        return Target.the("Boton Contraer  Filtro:  "+ filtro).locatedBy("(//button[contains(text(),'"+ filtro +"')][(child::*[@ng-reflect-type='COLLAPSE'])and(ancestor::main)])[1]");
    }

    public static Target BTN_FILTRO_EXPANDIR(String filtro){
        return Target.the("Boton Expandir Filtro:  "+ filtro).locatedBy("(//button[contains(text(),'"+ filtro +"')][(child::*[@ng-reflect-type='EXPAND'])and(ancestor::main)])[1]");
    }

    public static Target CHK_FILTRO (String valorFiltro){
        return Target.the("Check Box Valor Filtro:  "+ valorFiltro).locatedBy("(//div[@class='boxgreen ng-star-inserted'][(parent::div[contains(text(),'"+ valorFiltro +"')])and(ancestor::main)])[1]");
    }

    public static Target IMG_PRODUCTO_STOCK(String SKU){
        return Target.the("Ingresar a Producto con SKU: "+ SKU).locatedBy("//img[@class='product-img cursor-pointer ng-star-inserted'][(following::div[3][contains(text(),'"+ SKU +"')])and(ancestor::main)]");
    }

    public static final Target BTN_COMPRAR_PRODUCTO = Target.the("Boton Comprar Producto").locatedBy("//button[contains(text(),'Comprar')][ancestor::main]");
    public static final Target BTN_AGREGAR_PRODUCTO= Target.the("Boton Agregar Producto").locatedBy("//button[contains(text(),'+')][ancestor::main]");
    public static final Target BTN_QUITAR_PRODUCTO= Target.the("Boton Quitar Producto").locatedBy("//button[contains(text(),'-')][ancestor::main]");
    public static final Target BTN_AGREGAR_A_FAVORITOS= Target.the("Boton Agregar a Favoritos").locatedBy("//*[(@class='heart-fav-icon cursor-pointer ng-star-inserted') and (@height='21')]");
    public static final Target BTN_QUITAR_DE_FAVORITOS= Target.the("Boton Quitar de  Favoritos").locatedBy("//*[(@class='heart-fav-icon cursor-pointer ng-star-inserted') and (@height='22')]");
    public static final Target DETALLE_PRODUCTO= Target.the("Detalle Producto").locatedBy("//*[@class='ng-star-inserted ProductDetailsPageTemplate']");
    public static final Target BTN_CARRITO_COMPRAS = Target.the("Boton Carrito de Compras").locatedBy("//a[@type='button'][(preceding::p[contains(text(),'CARRITO')])and(ancestor::app-shopping-cart)]");
    public static final Target BTN_IR_PAGAR = Target.the("Boton Ir a Pagar").locatedBy("//button[@class='pagarBtn'][ancestor::mat-sidenav[@style='transform: none; visibility: visible;']]");
    public static final Target CHK_DECLARACION_TERMINOS_CONDICIONES= Target.the("CheckBox Terminos y Condiciones").locatedBy("//span[@class='mat-checkbox-inner-container'][ancestor::mat-checkbox[@id='mat-checkbox-1']]");
    public static final Target BTN_FINALIZAR_COMPRA = Target.the("Boton Finalizar Compra").locatedBy("//button[@class='pagarBtn'][ancestor::*[@class='purchaseSummaryContainer2']]");

    public static final Target localizador = Target.the("PopUp Error").locatedBy("//span[contains(text(),' ')][ancestor::*[@class='alert alert-danger ng-star-inserted']]");
    public static Target INPUT_CANTIDAD_PRODUCTOS= Target.the("Input Cantidad Productos").locatedBy("//input[@type='number'][ancestor::app-custom-product-summary]");


}

