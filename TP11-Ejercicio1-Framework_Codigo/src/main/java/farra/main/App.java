package farra.main;

import farra.framework.Menu;

public class App {

    public static void main(String[] args) {

	Menu m = new Menu("./src/main/resources/configuracion.json");

	m.runApp();

    }

}
