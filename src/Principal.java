import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Cambista cambista = new Cambista();

        // Establecer tasas de ejemplo
        cambista.setTasaARS(350.0); // 1 USD = 350 ARS
        cambista.setTasaBOB(6.9);   // 1 USD = 6.9 BOB
        cambista.setTasaBRL(5.2);   // 1 USD = 5.2 BRL
        cambista.setTasaCLP(870.0); // 1 USD = 870 CLP
        cambista.setTasaCOP(4000.0); // 1 USD = 4000 COP
        cambista.setTasaUSD(1.0);    // Base para USD

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("                                               ");
            System.out.println("-----------------------------------------------");
            System.out.println("***********************************************");
            System.out.println("-----------Conversor de Monedas----------------");
            System.out.println("Elija la moneda que usted tiene");
            System.out.println("1. Peso Argentino (ARS)");
            System.out.println("2. Boliviano boliviano (BOB)");
            System.out.println("3. Real brasileño (BRL)");
            System.out.println("4. Peso chileno (CLP)");
            System.out.println("5. Peso colombiano (COP)");
            System.out.println("6. Dólar estadounidense (USD)");
            System.out.println("0. Salir");
            System.out.println("***********************************************");
            System.out.println("-----------------------------------------------");
            System.out.println("                                               ");
            int opcionBase = scanner.nextInt();

            if (opcionBase == 0) {
                continuar = false;
                break;
            }

            System.out.println("                                               ");
            System.out.println("Seleccione la moneda a la que desea convertir");
            System.out.println("                                               ");
            int opcionDestino = scanner.nextInt();

            if ( opcionDestino == 0) {
                continuar = false;
                break;
            }

            System.out.println("                                               ");
            System.out.println("Ingrese la cantidad que desea cambiar:");
            System.out.println("                                               ");
            double cantidad = scanner.nextDouble();

            double tasaBase = getTasaPorOpcion(cambista, opcionBase);
            double tasaDestino = getTasaPorOpcion(cambista, opcionDestino);

            if (tasaBase == 0 || tasaDestino == 0) {
                System.out.println("                                               ");
                System.out.println("Opción invalida, intente nuevamente");
                System.out.println("                                               ");
                continue;
            }

            //Realizar la conversión
            double resultado = cambista.convertirMoneda(cantidad, tasaBase, tasaDestino);
            System.out.println("                                               ");
            System.out.println("Resultado: " + cantidad + " en la moneda inicial equivale a " + resultado + " en la moneda convertida.\n");
            System.out.println("Gracias por usar el conversor de monedas, si desea seleccione otra opción");
            System.out.println("                                               ");
        }
        System.out.println("                                               ");
        System.out.println("Gracias por usar el conversor de monedas.");
        scanner.close();
    }

    private static double getTasaPorOpcion(Cambista cambista, int opcion) {
        switch (opcion) {
            case 1:
                return cambista.getTasaARS();
            case 2:
                return cambista.getTasaBOB();
            case 3:
                return cambista.getTasaBRL();
            case 4:
                return cambista.getTasaCLP();
            case 5:
                return cambista.getTasaCOP();
            case 6:
                return cambista.getTasaUSD();
            default:
                return 0; //opcion invalida
        }
    }
}
