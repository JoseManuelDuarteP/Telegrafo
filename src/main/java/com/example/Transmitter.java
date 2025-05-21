package com.example;

import java.util.Map;
import java.util.HashMap;

public class Transmitter {
    private boolean encendido;

    Transmitter(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean getEncendido() {
        return this.encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Encendido: " + this.encendido;
    }

    public Signal sendSignal(Signal s) {

        if (s.getMensaje() == null) {
            return null;
        }

        Map<String, String> traductor = new HashMap<>();
        traductor.put("a", "._");
        traductor.put("b", "_...");
        traductor.put("c", "_._.");
        traductor.put("d", "_..");
        traductor.put("e", ".");
        traductor.put("f", ".._.");
        traductor.put("g", "__.");
        traductor.put("h", "....");
        traductor.put("i", "..");
        traductor.put("j", ".___");
        traductor.put("k", "_._");
        traductor.put("l", "._..");
        traductor.put("m", "__");
        traductor.put("n", "_.");
        traductor.put("o", "___");
        traductor.put("p", ".__.");
        traductor.put("q", "__._");
        traductor.put("r", "._.");
        traductor.put("s", "...");
        traductor.put("t", "_");
        traductor.put("u", ".._");
        traductor.put("v", "..._");
        traductor.put("w", ".__");
        traductor.put("x", "_.._");
        traductor.put("y", "_.__");
        traductor.put("z", "__..");

        traductor.put("0", "_____");
        traductor.put("1", ".____");
        traductor.put("2", "..___");
        traductor.put("3", "...__");
        traductor.put("4", "...._");
        traductor.put("5", ".....");
        traductor.put("6", "_....");
        traductor.put("7", "__...");
        traductor.put("8", "___..");
        traductor.put("9", "____.");

        traductor.put(" ", " ");


        String[] letras = s.getMensaje().toLowerCase().split("");
        String mensaje = "";

        for(String letra : letras) {
            mensaje += traductor.get(letra) + "\n";
        }
        
        s.setMensaje(mensaje.toString());
        return s;
    }
}