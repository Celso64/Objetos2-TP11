package farra.framework;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

class E_SConLanterna implements E_SPorPantalla {

    private Terminal terminal;

    public E_SConLanterna() {
	try {
	    this.terminal = new DefaultTerminalFactory().createTerminal();
	} catch (IOException e) {
	    this.terminal = null;
	    e.printStackTrace();
	}
    }

    @Override
    public void mostrarContenido(String contenido) throws EntradaSalidaException {

	var array = contenido.toCharArray();

	for (char c : array) {
	    mostrarCaracter(c);
	}

	try {
	    this.terminal.flush();
	} catch (Exception e) {
	    throw new EntradaSalidaException(e.getMessage());
	}
    }

    @Override
    public List<Integer> leerEnteros() throws EntradaSalidaException {

	try {
	    StringBuilder buffer = new StringBuilder();
	    KeyStroke tecla;
	    Character letraActual;

	    do {
		tecla = this.terminal.readInput();
		letraActual = tecla.getCharacter();
		buffer.append(letraActual);
		mostrarCaracter(letraActual);
		this.terminal.flush();
	    } while (tecla.getKeyType() != KeyType.Enter);

	    buffer.deleteCharAt(buffer.length() - 1);

	    List<Integer> res;

	    try {
		res = getNumeros(buffer.toString());
	    } catch (Exception e) {
		return List.of();
	    }
	    return res;

	} catch (Exception e) {
	    throw new EntradaSalidaException(e.getMessage());
	}
    }

    @Override
    public void limpiarPantalla() throws EntradaSalidaException {
	try {
	    this.terminal.clearScreen();
	} catch (Exception e) {
	    throw new EntradaSalidaException(e.getMessage());
	}
    }

    @Override
    public void cerrarPantalla() throws EntradaSalidaException {
	try {
	    this.terminal.close();
	} catch (Exception e) {
	    throw new EntradaSalidaException(e.getMessage());
	}
    }

    private void mostrarCaracter(Character caracter) throws EntradaSalidaException {
	try {
	    this.terminal.putCharacter(caracter);
	} catch (IOException e) {
	    throw new EntradaSalidaException(e.getMessage());
	}
    }

    private List<Integer> getNumeros(String cadena) {

	var arrayNumeros = cadena.split(",");
	var listNumeros = Arrays.asList(arrayNumeros);

	var numeros = listNumeros.stream().map(x -> x.replaceAll("\\s", "")).map(Integer::parseInt).toList();

	return numeros;
    }

}
