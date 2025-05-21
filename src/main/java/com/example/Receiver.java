package com.example;

import java.util.HashMap;
import java.util.Map;

public class Receiver {
    private Signal mensajeRecibido;

    public Signal getMensajeRecibido() {
        return mensajeRecibido;
    }

    public void setMensajeRecibido(Signal mensajeRecibido) {
        this.mensajeRecibido = mensajeRecibido;
    }

    @Override
    public String toString() {
        return "Mensaje Recibido: " + mensajeRecibido;
    }

   private String recieveSignal(Signal senyal) {
        String[] morses = senyal.getMensaje().split("\n");
        String mensaje = "";
        
        Map<String, String> traductor = new HashMap<>();
        traductor.put("._", "a");
        traductor.put("_...", "b");
        traductor.put("_._.", "c");
        traductor.put("_..", "d");
        traductor.put(".", "e");
        traductor.put(".._.", "f");
        traductor.put("__.", "g");
        traductor.put("....", "h");
        traductor.put("..", "i");
        traductor.put(".___", "j");
        traductor.put("_._", "k");
        traductor.put("._..", "l");
        traductor.put("__", "m");
        traductor.put("_.", "n");
        traductor.put("___", "o");
        traductor.put(".__.", "p");
        traductor.put("__._", "q");
        traductor.put("._.", "r");
        traductor.put("...", "s");
        traductor.put("_", "t");
        traductor.put(".._", "u");
        traductor.put("..._", "v");
        traductor.put(".__", "w");
        traductor.put("_.._", "x");
        traductor.put("_.__", "y");
        traductor.put("__..", "z");

        traductor.put("_____", "0");
        traductor.put(".____", "1");
        traductor.put("..___", "2");
        traductor.put("...__", "3");
        traductor.put("...._", "4");
        traductor.put(".....", "5");
        traductor.put("_....", "6");
        traductor.put("__...", "7");
        traductor.put("___..", "8");
        traductor.put("____.", "9");

        traductor.put(" ", " ");


        for (String morse : morses) {
            mensaje += traductor.get(morse);
        }

        return "\nMensaje: " + mensaje + "\nPerdida: " + senyal.getPerdida() + "%";
    }

    public void displayMessage(Signal mensajeRecibido) {
        System.out.println(recieveSignal(mensajeRecibido));
    }
}
