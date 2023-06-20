package farra.utilizacion;

import farra.framework.Accion;

public class Accion5 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 5");
    }

    @Override
    public String nombreItemMenu() {
	return "accion 5";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 5";
    }

}