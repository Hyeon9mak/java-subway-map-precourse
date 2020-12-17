package subway.domain;

public class Station {

    private static final String END_NAME = "역";
    private static final String WHITE_SPACE = " ";
    private static final int MINIMUM_LENGTH = 2;

    private final String name;

    private Station(String name) {
        validateEndName(name);
        validateWhiteSpace(name);
        validateLength(name);
        this.name = name;
    }

    public static Station newStationWithName(String name) {
        return new Station(name);
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 " + MINIMUM_LENGTH + "글자 이상이어야 합니다.");
        }
    }

    private void validateWhiteSpace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 역 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateEndName(String name) {
        if (!name.endsWith(END_NAME)) {
            throw new IllegalArgumentException("지하철 역 이름은 \"" + END_NAME + "\"으로 끝나야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
