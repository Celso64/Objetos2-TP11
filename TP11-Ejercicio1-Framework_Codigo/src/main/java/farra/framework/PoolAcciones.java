package farra.framework;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PoolAcciones implements EjecutadorAcciones {

    private Queue<Accion> acciones;
    private ExecutorService executor;

    public PoolAcciones(Integer limite) {
	this.executor = Executors.newFixedThreadPool(limite);
	this.acciones = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void agregarAcciones(Queue<Accion> acciones) {
	this.acciones = new ConcurrentLinkedQueue<>();
	acciones.stream().forEach(x -> this.acciones.add(x));
	// this.acciones.add(acciones.poll());
    }

    @Override
    public void ejecutar() throws PoolAccionesExcepcion {
	try {
	    Collection<Callable<String>> callables = new LinkedList<>();

	    this.acciones.stream().forEach(x -> callables.add(() -> {
		x.ejecutar();
		return "Listo";
	    }));
	    this.executor.invokeAll(callables);
	} catch (Exception e) {
	    throw new PoolAccionesExcepcion(e.getMessage());
	}
    }

}
