package mastermind.models;

public enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p');

    private char initial;

    Color(char initial) {
        this.initial = initial;
    }

    static String allInitials() {
        StringBuilder result = new StringBuilder();
        for(Color color: Color.values()) {
            result.append(color.initial);
        }
        return result.toString();
    }

    public static Color getInstance(char character) {
        for (Color color : Color.values()) {
            if (color.initial == character) {
                return color;
            }
        }
        return null;
    }

    public String toString() {
        return String.valueOf(this.initial);
    }

}