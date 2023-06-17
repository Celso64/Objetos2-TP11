package farra.framework;

class PoolAccionesExcepcion extends Exception {

    private static final long serialVersionUID = 1L;

    public PoolAccionesExcepcion(String message) {
	super("Error en el Pool de Acciones: " + message);
    }

}
