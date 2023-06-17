package farra.utilizacion;

import farra.framework.Accion;

public class Accion4 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 4");
    }

    @Override
    public String nombreItemMenu() {
	return "accion 4";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 4";
    }

}