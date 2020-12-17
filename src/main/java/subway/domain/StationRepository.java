package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        validateEmpty();
        return Collections.unmodifiableList(stations);
    }

    private static void validateEmpty() {
        if (stations.isEmpty()) {
            throw new IllegalArgumentException("지하철 역 목록이 비어있습니다.");
        }
    }

    public static void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    private static void validateDuplicate(Station station) {
        if (stations.stream().anyMatch(s -> s.getName().equals(station.getName()))) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
