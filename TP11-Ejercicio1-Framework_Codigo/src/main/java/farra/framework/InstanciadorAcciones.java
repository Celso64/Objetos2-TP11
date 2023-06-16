package farra.framework;

class InstanciadorAcciones {

    private String clase;

    public InstanciadorAcciones(String clase) {
	this.clase = clase;
    }

    @SuppressWarnings("unchecked")
    public Accion getInstancia() {
	Accion accion = null;
	try {
	    Class<Accion> claseRes = (Class<Accion>) Class.forName(this.clase);
	    accion = (Accion) claseRes.getDeclaredConstructor().newInstance();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return accion;
    }

}
