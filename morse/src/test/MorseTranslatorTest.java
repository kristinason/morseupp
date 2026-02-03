package textcounter;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {

    
    private final Map<Character, String> letterToMorse = new HashMap<>();
   
    private final Map<String, Character> morseToLetter = new HashMap<>();

    public MorseTranslator() {
        initMaps();
    }

    private void initMaps() {
        add('A', ".-");
        add('B', "-...");
        add('C', "-.-.");
        add('D', "-..");
        add('E', ".");
        add('F', "..-.");
        add('G', "--.");
        add('H', "....");
        add('I', "..");
        add('J', ".---");
        add('K', "-.-");
        add('L', ".-..");
        add('M', "--");
        add('N', "-.");
        add('O', "---");
        add('P', ".--.");
        add('Q', "--.-");
        add('R', ".-.");
        add('S', "...");
        add('T', "-");
        add('U', "..-");
        add('V', "...-");
        add('W', ".--");
        add('X', "-..-");
        add('Y', "-.--");
        add('Z', "--..");
    }

    private void add(char letter, String morse) {
        letterToMorse.put(letter, morse);
        morseToLetter.put(morse, letter);
    }

    
    public String textToMorse(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Texten får inte vara tom.");
        }

        String upper = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < upper.length(); i++) {
            char c = upper.charAt(i);

            if (c == ' ') {
                // mellanslag ignoreras
                continue;
            }

            String morse = letterToMorse.get(c);
            if (morse == null) {
                throw new IllegalArgumentException("Otillåtet tecken i texten: '" + c + "'");
            }

            result.append(morse).append(" ");
        }

        return result.toString().trim();
    }

   
    public String morseToText(String morseCode) {
        if (morseCode == null || morseCode.isBlank()) {
            throw new IllegalArgumentException("Morse-strängen får inte vara tom.");
        }

     
        for (int i = 0; i < morseCode.length(); i++) {
            char ch = morseCode.charAt(i);
            if (ch != '.' && ch != '-' && !Character.isWhitespace(ch)) {
                throw new IllegalArgumentException("Otillåtet tecken i morsekoden: '" + ch + "'");
            }
        }

        String[] tokens = morseCode.trim().split("\\s+");
        StringBuilder out = new StringBuilder();

        for (String token : tokens) {
            Character letter = morseToLetter.get(token);
            if (letter == null) {
                throw new IllegalArgumentException("Ogiltig morsekod-sekvens: '" + token + "'");
            }
            out.append(letter);
        }

        return out.toString();
    }
}
