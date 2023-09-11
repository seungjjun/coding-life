public enum Color {
    RED("빨강", "#331111"),
    GREEN("초록", "#25781c"),
    BLUE("파랑", "#1c1f78");

    private String name;
    private String hex;

    Color(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public String getHex() {
        return hex;
    }
}
