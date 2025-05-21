package com.example;

public class Relay {
    private boolean enActivo;
    private int bateria;

    Relay(boolean enActivo, int bateria) {
        this.enActivo = enActivo;
        this.bateria = bateria;
    }

    public boolean isEnActivo() {
        return enActivo;
    }

    public void setEnActivo(boolean enActivo) {
        this.enActivo = enActivo;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "En activo: " + this.enActivo;
    }

    public Signal amplifySignal(Signal senyal) {
        int largo = senyal.getMensaje().trim().length();

        for (int i = 0; i < largo; i++) {
            this.bateria--;
        }

        if (bateria < 0)
            return null;

        senyal.setPerdida(0);
        return senyal;
    }
}
