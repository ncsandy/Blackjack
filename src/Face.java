public enum Face {
    KING("King"),
    QUEEN("Queen"),
    JACK("Jack");

    private final String faceName;

    Face(String faceName) {
        this.faceName = faceName;
    }

    public String getFaceName() {
        return faceName;
    }
}
