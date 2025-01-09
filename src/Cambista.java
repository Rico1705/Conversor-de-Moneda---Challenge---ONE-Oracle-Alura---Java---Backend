public class Cambista {

    private double tasaARS;
    private double tasaBOB;
    private double tasaBRL;
    private double tasaCLP;
    private double tasaCOP;
    private double tasaUSD;

    // Getters y Setters para cada tasa
    public double getTasaARS() { return tasaARS; }
    public void setTasaARS(double tasaARS) { this.tasaARS = tasaARS; }

    public double getTasaBOB() { return tasaBOB; }
    public void setTasaBOB(double tasaBOB) { this.tasaBOB = tasaBOB; }

    public double getTasaBRL() { return tasaBRL; }
    public void setTasaBRL(double tasaBRL) { this.tasaBRL = tasaBRL; }

    public double getTasaCLP() { return tasaCLP; }
    public void setTasaCLP(double tasaCLP) { this.tasaCLP = tasaCLP; }

    public double getTasaCOP() { return tasaCOP; }
    public void setTasaCOP(double tasaCOP) { this.tasaCOP = tasaCOP; }

    public double getTasaUSD() { return tasaUSD; }
    public void setTasaUSD(double tasaUSD) { this.tasaUSD = tasaUSD; }

    // Método para convertir monedas
    public double convertirMoneda(double cantidad, double tasaBase, double tasaDestino) {
        return cantidad * (tasaDestino / tasaBase);
    }
}
