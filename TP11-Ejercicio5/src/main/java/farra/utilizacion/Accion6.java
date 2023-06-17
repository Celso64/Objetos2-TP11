package farra.utilizacion;

import farra.framework.Accion;

public class Accion6 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 6");
    }

    @Override
    public String nombreItemMenu() {
	return "accion 6";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 6";
    }

}