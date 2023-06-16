package farra.framework;

import java.util.Properties;
import java.util.ResourceBundle;

class LectorProperties extends LectorConfiguraciones {

    public LectorProperties(String pathFile) {
	super.pathFile = pathFile;
    }

    @Override
    protected String[] leerArchivo(String pathFile) {
	return leerPropiedades(pathFile).split("; ");
    }

    private String leerPropiedades(String fileName) {
	Properties prop = new Properties();
	try {
	    ResourceBundle infoDataBase = ResourceBundle.getBundle(fileName);
	    prop.setProperty("acciones", infoDataBase.getString("acciones"));
	    return prop.getProperty("acciones");
	} catch (Exception e1) {
	    throw new RuntimeException("Ocurrio un error al leer la configuracion desde el archivo");
	}
    }

}
