package farra.framework;

class EntradaSalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public EntradaSalidaException(String message) {
	super("Error de Entrada/Salida: " + message);
    }

}
