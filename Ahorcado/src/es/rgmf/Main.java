package es.rgmf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String frase;
        String[] frases;
        String solucion = "";
        char[] fraseOculta;
        Scanner entrada = new Scanner(System.in);
        Path path;

        // Carga el fichero con las frases
        path = Paths.get("Ahorcado/src/es/rgmf/frases.txt");
        try {
            frases = Files.lines(path).toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            frases = new String[]{"Hola Amigo"};
        }

        // Prepara la frase
        frase = frases[(int) (Math.random() * frases.length)];
        fraseOculta = new char[frase.length()];

        // Construye la frase oculta.
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                fraseOculta[i] = ' ';
            } else {
                fraseOculta[i] = '_';
            }
        }

        // Muestra la frase oculta.
        System.out.println(fraseOculta);

        // TODO Completa el programa.

        char opcion;
        do {
            System.out.print("Dame una letra: ");
            char letra = entrada.nextLine().charAt(0);
            System.out.println();

            // "Levantamos" la letra en la frase oculta.
            for (int i = 0; i < frase.length(); i++) {
                if (frase.toLowerCase().charAt(i) == letra || frase.toUpperCase().charAt(i) == letra) {
                    fraseOculta[i] = frase.charAt(i);
                }
            }

            System.out.println(fraseOculta);

            System.out.print("¿Quieres resolver la frase? [S/N] ");
            opcion = entrada.nextLine().charAt(0);

        } while (opcion != 'S' && opcion != 's');

        System.out.print("Intenta resolver la frase: ");
        solucion = entrada.nextLine();

        if (solucion.equalsIgnoreCase(frase)) {
            System.out.println("Has adivinado la frase");
        } else {
            System.out.println("No has acertado, la frase era: " + frase);
        }

        entrada.close();
    }
}
