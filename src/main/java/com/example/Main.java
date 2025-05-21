package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Transmitter transmitter = new Transmitter(true);
        List<Cable> cables = new ArrayList<>();
        Cable cable;
        List<Relay> relays = new ArrayList<>();
        Relay repetidor;
        Receiver receiver = new Receiver();

        String mensaje;
        double longitud;
        double perdidaSenyal;
        String flag1;
        int bateria;

        System.out.println("Ingrese el mensaje a transferir: ");
        mensaje = sc.nextLine();

        System.out.println("Ingrese longitud del cable: ");
        longitud = sc.nextDouble();
        System.out.println("Ingrese perdida por Km del cable (ej. 0,9): ");
        perdidaSenyal = sc.nextDouble();

        cable = new Cable(longitud, perdidaSenyal);
        cables.add(cable);

        System.out.println("Cable añadido.");

        do {

            System.out.println("Quiere añadir un repetidor al sistema? (Si/No)");
            flag1 = sc.next();

            if (flag1.equalsIgnoreCase("no"))
                break;

            System.out.println("Ingrese la batería inicial: ");
            bateria = sc.nextInt();
            repetidor = new Relay(true, bateria);
            relays.add(repetidor);

            System.out.println("Repetidor añadido, es necesario añadir otro cable.");
            
            System.out.println("Ingrese longitud del cable: ");
            longitud = sc.nextDouble();
            System.out.println("Ingrese perdida por Km del cable (ej. 0.9): ");
            perdidaSenyal = sc.nextDouble();

            cable = new Cable(longitud, perdidaSenyal);
            cables.add(cable);

            System.out.println("Cable añadido.");

        } while (true);

        System.out.println("Transmitiendo mensaje...");
        TelegraphSystem tg = new TelegraphSystem(transmitter, cables, relays, receiver);
        tg.run(mensaje);

        sc.close();
    }
}