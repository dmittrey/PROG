package innerInterface;

public enum OpinionStatus {
    Sad("They really, really didn't want to think about it"),
    Boring("They were waiting for someone else to speak"),
    Motivation("It will motivate him"),
    Funny("He liked that no one interrupted him");

    private String name;

    OpinionStatus(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}

