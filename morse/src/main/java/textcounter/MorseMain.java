package textcounter;

import java.util.Scanner;

    public class MorseMain {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            MorseTranslator translator = new MorseTranslator();

            System.out.println("Välkommen till Morse-programmet!");
            System.out.println("Vad vill du göra?");
            System.out.println("1 = Text till morsekod");
            System.out.println("2 = Morskod till text");
            System.out.print("Skriv 1 eller 2: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // läs bort radbrytningen efter siffran

            try {
                if (choice == 1) {
                    System.out.print("Skriv text (A-Z och mellanslag): ");
                    String text = scanner.nextLine();
                    String morse = translator.textToMorse(text);
                    System.out.println("Morsekod: " + morse);

                } else if (choice == 2) {
                    System.out.print("Skriv morsekod (mellanslag mellan varje bokstav): ");
                    String morse = scanner.nextLine();
                    String text = translator.morseToText(morse);
                    System.out.println("Text: " + text);

                } else {
                   
                    System.out.println("Ogiltigt val. Avslutar programmet.");
                }

            } catch (IllegalArgumentException e) {
                
                System.out.println("Fel: " + e.getMessage());
            }

            scanner.close();
        }
    }

