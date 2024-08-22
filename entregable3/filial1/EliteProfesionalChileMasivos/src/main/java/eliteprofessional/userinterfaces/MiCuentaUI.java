package eliteprofessional.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MiCuentaUI {

    public static final Target OPCION_MIS_DATOS = Target.the("Opcion 'Mis datos' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/profile'])[3]");
    public static final Target OPCION_DIRECCIONES = Target.the("Opcion 'Direcciones' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/addresses'])[3]");
    public static final Target OPCION_ACCESOS = Target.the("Opcion 'Accesos' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/organization'])[3]");
    public static final Target OPCION_ESTADO_CUENTA = Target.the("Opcion 'Estado de cuenta' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/account-status'])[3]");
    public static final Target OPCION_COTIZACIONES = Target.the("Opcion 'Cotizaciones' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/quotes'])[3]");
    public static final Target OPCION_PEDIDOS = Target.the("Opcion 'Pedidos' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/my-orders'])[3]");
    public static final Target OPCION_CAMBIAR_CONTRASENA = Target.the("Opcion 'Cambiar contrasena' dentro de Menu mi cuenta").locatedBy("(//a[@href='/my-account/update-password'])[3]");
    public static final Target OPCION_APROBACIONES = Target.the("Opcion 'Aprobaciones' dentro de Menu mi cuenta -Perfil Aprobador").locatedBy("(//a[@href='/my-account/dashboard'])[3]");

}
