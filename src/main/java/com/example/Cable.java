package com.example;

public class Cable {
    private double longitud;
    private double perdidaSenyal;

    Cable(double longitud, double perdidaSenyal) {
        this.longitud = longitud;
        this.perdidaSenyal = perdidaSenyal;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getPerdidaSenyal() {
        return perdidaSenyal;
    }

    public void setPerdidaSenyal(double perdidaSenyal) {
        this.perdidaSenyal = perdidaSenyal;
    }

    @Override
    public String toString() {
        return "Longitud: " + this.longitud + " - " +
        "Perdida: " + this.perdidaSenyal;
    }

    public Signal transmit(Signal senyal) {
        double largo = this.longitud;
        
        double perdidaTotal = (perdidaSenyal * largo) / 100;

        while (longitud > 10) {
            longitud -= 10;
            int random = (int) (Math.random() * 101);
            if (random <= 5) {
                System.out.println("Error, fallo inesperado."); //Fallo aleatorio cada 10 km
                return null;
            }
        }
        this.longitud = largo;

        if (perdidaTotal >= 95) {
            return null;
        } else {
            senyal.setPerdida(perdidaTotal);
            return senyal;
        }
    }
}
