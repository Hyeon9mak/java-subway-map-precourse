package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Section {

    private final Line line;
    private final List<Station> stations = new ArrayList<>();;

    private Section(Line line, Station start, Station end) {
        validateDuplicate(start, end);
        this.line = line;
        this.stations.addAll(Arrays.asList(start, end));
    }

    private void validateDuplicate(Station start, Station end) {
        if (start.getName().equals(end.getName())){
            throw new IllegalArgumentException("상행, 하행 종점역이 같을 수 없습니다.");
        }
    }

    public static Section newSectionWithLineStations(Line line, Station start, Station end) {
        return new Section(line, start, end);
    }

    public Line getLine() {
        return line;
    }

    public int insertStation(Station station, Order order) {
        validateDuplicate(station);
        validateRange(order);
        stations.add(order.getOrder(), station);
        return stations.size();
    }

    private void validateRange(Order order) {
        if (order.getOrder() < 0 || stations.size() < order.getOrder()){
            throw new IllegalArgumentException("입력 가능한 순서 범위를 벗어났습니다.");
        }
    }

    private void validateDuplicate(Station station) {
        if(stations.contains(station)){
            throw new IllegalArgumentException("이미 구간으로 등록된 역 이름 입니다.");
        }
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
