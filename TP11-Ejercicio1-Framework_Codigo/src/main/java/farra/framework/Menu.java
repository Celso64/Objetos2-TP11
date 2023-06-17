package farra.framework;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Menu {

    private static final E_SPorPantalla E_S = new E_SConLanterna();

    private List<Accion> acciones;
    private final String opciones;
    private final EjecutadorAcciones poolAcciones;

    public Menu(String configuracionPath) {
	var configuracion = Objects.requireNonNull(configuracionPath);
	var configuraciones = LectorFactory.getLectorConfiguraciones(configuracion);
	try {
	    this.acciones = configuraciones.leerConfiguraciones();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	this.opciones = this.setupOpciones();
	this.poolAcciones = new PoolAcciones(configuraciones.cantidadDeHilos);
    }

    public void runApp() {

	List<Integer> opcion = List.of();

	try {

	    while (true) {
		opcion = this.mostrarMenu();

		this.poolAcciones.agregarAcciones(this.setupAcciones(opcion));
		this.poolAcciones.ejecutar();

		if (opcion.contains(0))
		    break;

		E_S.mostrarContenido("\n\n");

	    }
	    E_S.mostrarContenido("\nFIN DEL PROGRAMA");
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    private List<Integer> mostrarMenu() throws EntradaSalidaException {
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

    private Queue<Accion> setupAcciones(List<Integer> numerosAcciones) {

	Queue<Accion> res = new ConcurrentLinkedQueue<>();

	for (Integer numeroAccion : numerosAcciones) {
	    if (numeroAccion > 0 && numeroAccion <= this.acciones.size()) {
		try {
		    res.add(this.acciones.get(numeroAccion - 1).getClass().getDeclaredConstructor().newInstance());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}

	return res;
    }

}
