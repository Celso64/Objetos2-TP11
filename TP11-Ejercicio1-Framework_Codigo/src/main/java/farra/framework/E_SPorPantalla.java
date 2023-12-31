package farra.framework;

import java.util.List;

interface E_SPorPantalla {

    void mostrarContenido(String contenido) throws EntradaSalidaException;

    List<Integer> leerEnteros() throws EntradaSalidaException;

    void limpiarPantalla() throws EntradaSalidaException;

    void cerrarPantalla() throws EntradaSalidaException;
}
