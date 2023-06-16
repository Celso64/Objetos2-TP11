package farra.framework;

final class ConfiguracionJSON {

    private String[] acciones;
    private Integer max_threads;

    public ConfiguracionJSON() {
    }

    public String[] getAcciones() {
	return acciones;
    }

    public void setAcciones(String[] acciones) {
	this.acciones = acciones;
    }

    public Integer getMax_threads() {
	return max_threads;
    }

    public void setMax_threads(Integer max_threads) {
	this.max_threads = max_threads;
    }

}
