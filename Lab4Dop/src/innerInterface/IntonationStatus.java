package innerInterface;

public enum IntonationStatus {
    calm("They were calm"),
    sad("somehow sad and uneasy"),
    panic("They wanted to displace a weak person"),
    sorry("He was sorry");

    private String name;

    IntonationStatus(String string){
        name = string;
    }

    @Override
    public String toString() {
        return name;
    }
}
