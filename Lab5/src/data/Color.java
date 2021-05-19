package data;

/**
 * Enum for study group admin eyes color
 */
public enum Color {
    BLACK,
    BLUE,
    YELLOW,
    WHITE,
    BROWN;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Color color: Color.values()) {
            stringBuilder.append(color).append("\n");
        }
        return stringBuilder.toString();
    }
}
