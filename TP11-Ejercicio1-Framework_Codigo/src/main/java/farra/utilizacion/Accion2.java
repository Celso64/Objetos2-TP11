package farra.utilizacion;

import farra.framework.Accion;

public class Accion2 implements Accion {

    @Override
    public void ejecutar() {
	System.out.println("Soy la accion 2");
    }

    @Override
    public String nombreItemMenu() {
	return "Accion 2";
    }

    @Override
    public String descripcionItemMenu() {
	return "Es la accion 2";
    }

}
