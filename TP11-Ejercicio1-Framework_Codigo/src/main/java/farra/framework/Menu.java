package farra.framework;

import java.util.List;
import java.util.Objects;

public final class Menu {

    private static final E_SPorPantalla E_S = new E_SConLanterna();

    private final List<Accion> acciones;
    private final String opciones;
    private final PoolAcciones poolAcciones;

    public Menu(String configuracionPath) {
	var configuracion = Objects.requireNonNull(configuracionPath);
	var configuraciones = LectorFactory.getLectorConfiguraciones(configuracion);
	this.acciones = configuraciones.leerConfiguraciones();
	this.opciones = this.setupOpciones();
	this.poolAcciones = new PoolAcciones(configuraciones.cantidadDeHilos);
    }

    public void runApp() {

	Integer opcion = -1;

	while (true) {
	    opcion = this.mostrarMenu();

	    if (opcion == 0)
		break;

	    if (opcion > this.acciones.size() || opcion < 0) {
		E_S.mostrarContenido("\nOpcion Invalida\n");
		continue;
	    }

	    this.acciones.get(opcion - 1).ejecutar();
	    E_S.mostrarContenido("\n\n");

	}
	E_S.mostrarContenido("\nFIN DEL PROGRAMA");
    }

    private List<Integer> mostrarMenu() {
	E_S.mostrarContenido("Bienvenido, estas son sus opciones: \n");
	E_S.mostrarContenido(this.opciones);
	E_S.mostrarContenido("Ingrese su opción:");
	List<Integer> opcion = leerAccion();
	return opcion;
    }

    private static List<Integer> leerAccion() {
	try {
	    List<Integer> res = E_S.leerEnteros();
	    return res;
	} catch (Exception e) {
	    return List.of();
	}
    }

    private String setupOpciones() {
	StringBuilder buffer = new StringBuilder();
	Integer i = 1;
	for (Accion accion : acciones) {
	    buffer.append(i++);
	    buffer.append(". ");
	    buffer.append(accion.nombreItemMenu());
	    buffer.append("\n");
	}
	return buffer.toString();
    }

}
