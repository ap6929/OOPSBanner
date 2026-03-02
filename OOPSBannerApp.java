class CharacterPatternMap {
    Character character;
    String[] pattern;

    // Constructor
    public CharacterPatternMap(Character character, String[] pattern) {
        this.character = character;
        this.pattern = pattern;
    }

    public Character getCharacter() {
        return character;
    }

    public String[] getPattern() {
        return pattern;
    }
}

public class BannerPrinter {

    // Create pattern mappings
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        String[] O = {
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                " *** "
        };

        String[] P = {
                "**** ",
                "*   *",
                "**** ",
                "*    ",
                "*    "
        };

        String[] S = {
                " ****",
                "*    ",
                " *** ",
                "    *",
                "**** "
        };

        String[] space = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };

        CharacterPatternMap[] characterPatternMap = new CharacterPatternMap[4];

        characterPatternMap[0] = new CharacterPatternMap('O', O);
        characterPatternMap[1] = new CharacterPatternMap('P', P);
        characterPatternMap[2] = new CharacterPatternMap('S', S);
        characterPatternMap[3] = new CharacterPatternMap(' ', space);

        return characterPatternMap;
    }

    // Get pattern for a character
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return null; // If character not found
    }

    // Print banner message
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        message = message.toUpperCase();

        for (int row = 0; row < 5; row++) {
            for (int i = 0; i < message.length(); i++) {
                String[] pattern = getCharacterPattern(message.charAt(i), charMaps);
                if (pattern != null) {
                    System.out.print(pattern[row] + "  ");
                }
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        printMessage("OPS", charMaps);
    }
}