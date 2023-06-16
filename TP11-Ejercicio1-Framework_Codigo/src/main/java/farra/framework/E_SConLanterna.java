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
    public void mostrarContenido(String contenido) {

	var array = contenido.toCharArray();

	for (char c : array) {
	    mostrarCaracter(c);
	}

	try {
	    this.terminal.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public List<Integer> leerEntero() {

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
	    e.printStackTrace();
	}

	return List.of();
    }

    private void mostrarCaracter(Character caracter) {
	try {
	    this.terminal.putCharacter(caracter);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private List<Integer> getNumeros(String cadena) {

	var arrayNumeros = cadena.split(",");
	var listNumeros = Arrays.asList(arrayNumeros);

	var numeros = listNumeros.stream().map(x -> x.replaceAll("\\s", "")).map(Integer::parseInt).toList();

	return numeros;
    }

}
