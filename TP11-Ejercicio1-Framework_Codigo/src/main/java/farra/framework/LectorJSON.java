package farra.framework;

import java.io.FileReader;
import java.util.Objects;
import java.util.Optional;

import com.google.gson.Gson;

final class LectorJSON extends LectorConfiguraciones {

    private final Gson gson;

    public LectorJSON(String pathFile) {
	super.pathFile = Objects.requireNonNull(pathFile);
	this.gson = new Gson();
    }

    @Override
    protected String[] leerArchivo(String pathFile) throws LectorConfiguracionExcepcion {
	Optional<ConfiguracionJSON> config = Optional.empty();

	try (FileReader reader = new FileReader(pathFile)) {
	    config = Optional.of(this.gson.fromJson(reader, ConfiguracionJSON.class));
	    super.cantidadDeHilos = config.get().getMax_threads();
	} catch (Exception e) {
	    throw new LectorConfiguracionExcepcion(e.getMessage());
	}
	return config.orElseThrow().getAcciones();
    }

}
