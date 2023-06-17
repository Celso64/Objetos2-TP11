package farra.framework;

class LectorConfiguracionExcepcion extends Exception {

    private static final long serialVersionUID = 1L;

    public LectorConfiguracionExcepcion(String message) {
	super("Error en el lector de configuraciones: " + message);
    }

}
