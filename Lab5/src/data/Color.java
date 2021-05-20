package data;

/**
 * Enum for study group admin eyes color
 */
public enum Color {
    BLACK("BLACK"),
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    WHITE("WHITE"),
    BROWN("BROWN");

    private final String stringRepresentation;

    Color(String aStringRepresentation){
        stringRepresentation = aStringRepresentation;
    }

    private String getStringRepresentation(){
        return stringRepresentation;
    }

    public static boolean isIncludeElement(String aColor){

        for (Color currentColor: Color.values()){
            if (aColor.equals(currentColor.getStringRepresentation())) return true;
        }

        return false;
    }
}
