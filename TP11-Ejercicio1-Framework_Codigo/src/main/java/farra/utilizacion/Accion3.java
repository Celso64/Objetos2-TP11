package farra.utilizacion;

import farra.framework.Accion;

public class Accion3 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 3");
    }

    @Override
    public String nombreItemMenu() {
	return "accion 3";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 3";
    }

}