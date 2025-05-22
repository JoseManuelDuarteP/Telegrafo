package com.example;

import java.util.List;

public class TelegraphSystem {
    private Transmitter emisor;
    private List<Cable> cables;
    private List<Relay> repetidores;
    private Receiver receptor;
    
    public TelegraphSystem(Transmitter emisor, List<Cable> cables, List<Relay> repetidores, Receiver receptor) {
        this.emisor = emisor;
        this.cables = cables;
        this.repetidores = repetidores;
        this.receptor = receptor;
    }

    public Transmitter getEmisor() {
        return emisor;
    }

    public void setEmisor(Transmitter emisor) {
        this.emisor = emisor;
    }

    public List<Cable> getCables() {
        return cables;
    }

    public void addCable(Cable cable) {
        cables.add(cable);
    }

    public List<Relay> getRepetidores() {
        return repetidores;
    }

    public void addRepetidore(Relay repetidor) {
        repetidores.add(repetidor);
    }

    public Receiver getReceptor() {
        return receptor;
    }

    public void setReceptor(Receiver receptor) {
        this.receptor = receptor;
    }

    @Override
    public String toString() {
        return "TelegraphSystem [emisor=" + emisor + ", cables=" + cables + ", repetidores=" + repetidores
                + ", receptor=" + receptor + "]";
    }

    public void run(String mensaje) {
        Signal signal = new Signal(mensaje);
        boolean flag1 = true;
        boolean flag2 = true;

        this.emisor.sendSignal(signal);

        do {
            if (!cables.isEmpty()) {
                if (cables.get(0).transmit(signal) == null) {
                    System.out.println("Error, se perdió la señal");
                    flag1 = false;
                    break;
                }
                cables.get(0).transmit(signal);
                cables.remove(0);
                
                if(!repetidores.isEmpty()) {
                    if (repetidores.get(0).amplifySignal(signal) == null) {
                        System.out.println("Error, fallo en la batería");
                        flag2 = false;
                        break;
                    }
                    repetidores.get(0).amplifySignal(signal);
                    repetidores.remove(0);
                }
            }
        } while(!cables.isEmpty());

        if (flag1 && flag2) {
            this.receptor.displayMessage(signal);
        }
    }
}
