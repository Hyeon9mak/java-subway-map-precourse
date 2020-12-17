package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Section {

    private final Line line;
    private final List<Station> stations;

    private Section(Line line, Station start, Station end) {
        validateDuplicate(start, end);
        this.line = line;
        this.stations = Arrays.asList(start, end);
    }

    private void validateDuplicate(Station start, Station end) {
        if (start.getName().equals(end.getName())){
            throw new IllegalArgumentException("상행, 하행 종점역이 같을 수 없습니다.");
        }
    }

    public static Section newSectionWithLineStations(Line line, Station start, Station end) {
        return new Section(line, start, end);
    }

}
