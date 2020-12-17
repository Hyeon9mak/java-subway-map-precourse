package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Section {

    private final Line line;
    private final List<Station> stations;

    private Section(Line line, Station start, Station end) {
        this.line = line;
        this.stations = Arrays.asList(start, end);
    }

    public static Section newSectionWithLineStations(Line line, Station start, Station end) {
        return new Section(line, start, end);
    }

}
