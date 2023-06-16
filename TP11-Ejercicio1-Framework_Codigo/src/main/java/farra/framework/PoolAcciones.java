package farra.framework;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PoolAcciones {

    private Integer limite;
    private Queue<Accion> acciones;
    private ExecutorService executor;

    public PoolAcciones(Integer limite) {
	this.limite = limite;
	this.executor = Executors.newFixedThreadPool(limite);
    }

    public void agregarAcciones(Queue<Accion> acciones) {
	while (cuposDisponibles() > 0 && !acciones.isEmpty())
	    this.acciones.add(acciones.poll());
    }

    public void ejecutar() {

	Collection<Callable<String>> callables = new LinkedList<>();

	this.acciones.stream().forEach(x -> callables.add(() -> {
	    x.ejecutar();
	    return "Listo";
	}));

	try {
	    this.executor.invokeAll(callables);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

    }

    private Integer cuposDisponibles() {
	return limite - this.acciones.size();
    }

}
