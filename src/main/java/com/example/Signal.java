package com.example;

public class Signal {
    private String mensaje;
    private double perdida;

    Signal(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public double getPerdida() {
        return perdida;
    }

    public void setPerdida(double perdida) {
        this.perdida = perdida;
    }

    @Override
    public String toString() {
        return "\nMensaje: \n" + this.mensaje +
        "\nPerdida: " + this.perdida + "%";
    }
}
