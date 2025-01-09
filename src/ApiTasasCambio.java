import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ApiTasasCambio {

    // Método para obtener tasas de cambio filtradas desde el JSON
    public static Map<String, Double> obtenerTasasFiltradas(String json) {
        Map<String, Double> tasas = new HashMap<>();
        JSONObject objetoJson = new JSONObject(json);
        JSONObject conversionRates = objetoJson.getJSONObject("conversion_rates");

        tasas.put("ARS", conversionRates.getDouble("ARS"));
        tasas.put("BOB", conversionRates.getDouble("BOB"));
        tasas.put("BRL", conversionRates.getDouble("BRL"));
        tasas.put("CLP", conversionRates.getDouble("CLP"));
        tasas.put("COP", conversionRates.getDouble("COP"));
        tasas.put("USD", conversionRates.getDouble("USD"));

        return tasas;
    }

    // Método para conectarse a una API y obtener tasas reales (opcional)
    public static String obtenerTasasDesdeApi() {
        // Ejemplo con tasas reales (comentar si no se usa)
        return "{"
                + "\"conversion_rates\": {"
                + "\"ARS\": 1036.25,"
                + "\"BOB\": 6.9297,"
                + "\"BRL\": 6.0908,"
                + "\"CLP\": 1011.6460,"
                + "\"COP\": 4349.5581,"
                + "\"USD\": 1.0"
                + "}"
                + "}";
    }
}
