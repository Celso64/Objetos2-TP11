package farra.framework;

import java.util.Queue;

public interface EjecutadorAcciones {

    void agregarAcciones(Queue<Accion> acciones);

    void ejecutar() throws PoolAccionesExcepcion;

}
