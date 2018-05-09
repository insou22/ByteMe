package co.insou.byteme.util;

public enum Strings {

    ;

    public static boolean isBlank(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }

        for (char character : string.toCharArray()) {
            if (!Strings.isWhitespace(character)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isWhitespace(char character) {
        return Character.isWhitespace(character);
    }

}
