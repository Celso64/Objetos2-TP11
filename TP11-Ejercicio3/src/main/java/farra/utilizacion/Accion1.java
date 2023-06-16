package farra.utilizacion;

import farra.framework.Accion;

public class Accion1 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 1");
    }

    @Override
    public String nombreItemMenu() {
	return "Accion 1";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 1";
    }

}
