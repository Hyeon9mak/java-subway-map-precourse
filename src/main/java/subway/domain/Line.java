package subway.domain;

public class Line {

    private static final String END_NAME = "선";
    private static final String WHITE_SPACE = " ";
    private static final int MINIMUM_LENGTH = 2;

    private final String name;

    private Line(String name) {
        validateLength(name);
        validateWhiteSpace(name);
        validateEndName(name);
        this.name = name;
    }

    public static Line newLineWithName(String name) {
        return new Line(name);
    }

    private void validateEndName(String name) {
        if (!name.endsWith(END_NAME)) {
            throw new IllegalArgumentException("지하철 노선 이름은 \"" + END_NAME + "\"으로 끝나야 합니다.");
        }
    }

    private void validateWhiteSpace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 노선 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 " + MINIMUM_LENGTH + "글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
