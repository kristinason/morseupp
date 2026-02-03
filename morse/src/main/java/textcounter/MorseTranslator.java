package textcounter;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {

   
    private Map<Character, String> letterToMorse = new HashMap<>();
   
    private Map<String, Character> morseToLetter = new HashMap<>();

    
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
        String upper = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < upper.length(); i++) {
            char c = upper.charAt(i);

            if (c == ' ') {               // word break
                result.append(" / ");
                first = true;             // next letter starts a new “word”
                continue;
            }

            String morse = letterToMorse.get(c);
            if (morse == null) throw new IllegalArgumentException("Ogiltig bokstav i text: " + c);

            if (!first) result.append(" ");
            result.append(morse);
            first = false;
        }
        return result.toString().trim();
    }

    public String morseToText(String morseCode) {
        String[] words = morseCode.trim().split("\\s*/\\s*");
        StringBuilder out = new StringBuilder();

        for (int w = 0; w < words.length; w++) {
            if (w > 0) out.append(' ');
            for (String part : words[w].trim().split("\\s+")) {
                Character letter = morseToLetter.get(part);
                if (letter == null) throw new IllegalArgumentException("Ogiltig morsekod: " + part);
                out.append(letter);
            }
        }
        return out.toString();
    }
}


