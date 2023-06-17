package farra.framework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

abstract class LectorConfiguraciones {

    protected String pathFile;
    protected Integer cantidadDeHilos = 1;

    final List<Accion> leerConfiguraciones() throws LectorConfiguracionExcepcion {

	List<Accion> res = new LinkedList<>();

	var acciones = this.leerArchivo(this.pathFile);

	Arrays.stream(acciones).map(x -> new InstanciadorAcciones(x).getInstancia()).forEach(res::add);

	return res;
    }

    public final Integer cantidadDeHilos() {
	return this.cantidadDeHilos;
    }

    protected abstract String[] leerArchivo(String pathFile) throws LectorConfiguracionExcepcion;

}
