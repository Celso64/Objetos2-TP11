package farra.framework;

abstract class LectorFactory {

    private static final String JSON_PATTERN = ".json";

    public static LectorConfiguraciones getLectorConfiguraciones(String pathFile) {

	if (pathFile.endsWith(JSON_PATTERN))
	    return new LectorJSON(pathFile);

	return new LectorProperties(pathFile);
    }

}
