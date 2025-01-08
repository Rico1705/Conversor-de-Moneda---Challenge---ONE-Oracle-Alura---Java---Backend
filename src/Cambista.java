public class Cambista {
    private double tasaARS;
    private double tasaBOB;
    private double tasaBRL;
    private double tasaCLP;
    private double tasaCOP;
    private double tasaUSD;

    //Métodos para establecer las tasas(set)

    public void setTasaARS(double valor){
        this.tasaARS = valor;
    }

    public void setTasaBOB(double valor){
        this.tasaBOB = valor;
    }

    public void setTasaBRL(double valor){
        this.tasaBRL = valor;
    }

    public void setTasaCLP(double valor){
        this.tasaCLP = valor;
    }

    public void setTasaCOP(double valor){
        this.tasaCOP = valor;
    }

    public void setTasaUSD(double valor){
        this.tasaUSD = valor;
    }

    // Métodos para obtener las tasas(get)

    public double getTasaARS(){
        return this.tasaARS;
    }

    public double getTasaBOB(){
        return this.tasaBOB;
    }

    public double getTasaBRL() {
        return this.tasaBRL;
    }

    public double getTasaCLP() {
        return this.tasaCLP;
    }

    public double getTasaCOP() {
        return this.tasaCOP;
    }

    public double getTasaUSD() {
        return this.tasaUSD;
    }
    // Métodos para convertir moneda
    public double convertirMoneda(double cantidad, double tasaBase, double tasaDestino){
        return (cantidad*tasaDestino) / tasaBase;
    }
}
