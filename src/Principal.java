import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Cambista cambista = new Cambista();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Formateador para mostrar valores numéricos con 4 decimales
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");

        // Simulación del JSON (puedes reemplazarlo con datos reales)
        String jsonSimulado = ApiTasasCambio.obtenerTasasDesdeApi();

        // Obtenemos las tasas de cambio
        Map<String, Double> tasasFiltradas = ApiTasasCambio.obtenerTasasFiltradas(jsonSimulado);

        // Configuramos las tasas en el Cambista
        cambista.setTasaARS(tasasFiltradas.get("ARS"));
        cambista.setTasaBOB(tasasFiltradas.get("BOB"));
        cambista.setTasaBRL(tasasFiltradas.get("BRL"));
        cambista.setTasaCLP(tasasFiltradas.get("CLP"));
        cambista.setTasaCOP(tasasFiltradas.get("COP"));
        cambista.setTasaUSD(tasasFiltradas.get("USD"));

        while (continuar) {
            System.out.println("----------- Conversor de Monedas -----------");
            System.out.println("1. Peso Argentino (ARS)");
            System.out.println("2. Boliviano boliviano (BOB)");
            System.out.println("3. Real brasileño (BRL)");
            System.out.println("4. Peso chileno (CLP)");
            System.out.println("5. Peso colombiano (COP)");
            System.out.println("6. Dólar estadounidense (USD)");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------------");

            System.out.println("Seleccione la moneda que usted tiene:");
            int opcionBase = scanner.nextInt();

            if (opcionBase == 0) {
                continuar = false;
                break;
            }

            System.out.println("Seleccione la moneda que desea:");
            int opcionDestino = scanner.nextInt();

            if (opcionDestino == 0) {
                continuar = false;
                break;
            }

            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = scanner.nextDouble();

            double tasaBase = getTasaPorOpcion(cambista, opcionBase);
            double tasaDestino = getTasaPorOpcion(cambista, opcionDestino);

            if (tasaBase == 0 || tasaDestino == 0) {
                System.out.println("Opción inválida, intente nuevamente.");
                continue;
            }

            // Realizar la conversión
            double resultado = cambista.convertirMoneda(cantidad, tasaBase, tasaDestino);

            String nombreMonedaBase = obtenerNombreMoneda(opcionBase);
            String nombreMonedaDestino = obtenerNombreMoneda(opcionDestino);
            double tasaConversion = tasaDestino / tasaBase;

            // Formateamos los resultados para que incluyan 4 decimales
            System.out.printf("Resultado: %.4f %s equivale a %.4f %s.\n", cantidad, nombreMonedaBase, resultado, nombreMonedaDestino);
            System.out.printf("Tasa de conversión: 1 %s = %.4f %s.\n\n", nombreMonedaBase, tasaConversion, nombreMonedaDestino);
            System.out.println("Elija nuevamente la moneda que desea cambiar");
        }

        System.out.println("Gracias por usar el conversor de monedas.");
        scanner.close();
    }

    private static double getTasaPorOpcion(Cambista cambista, int opcion) {
        switch (opcion) {
            case 1: return cambista.getTasaARS();
            case 2: return cambista.getTasaBOB();
            case 3: return cambista.getTasaBRL();
            case 4: return cambista.getTasaCLP();
            case 5: return cambista.getTasaCOP();
            case 6: return cambista.getTasaUSD();
            default: return 0;
        }
    }

    private static String getMonedaPorOpcion(int opcion) {
        switch (opcion) {
            case 1: return "ARS";
            case 2: return "BOB";
            case 3: return "BRL";
            case 4: return "CLP";
            case 5: return "COP";
            case 6: return "USD";
            default: return "Desconocida";
        }
    }

    private static String obtenerNombreMoneda(int opcion) {
        switch (opcion) {
            case 1:
                return "ARS";
            case 2:
                return "BOB";
            case 3:
                return "BRL";
            case 4:
                return "CLP";
            case 5:
                return "COP";
            case 6:
                return "USD";
            default:
                return "Desconocida"; // Para casos no válidos
        }
    }

}
