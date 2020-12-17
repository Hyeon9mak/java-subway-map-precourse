package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SectionTest {

    @Test
    public void testSectionInsert() {
        Line line = Line.newLineWithName("1호선");
        Station station1 = Station.newStationWithName("면목역");
        Station station2 = Station.newStationWithName("상봉역");
        Station station3 = Station.newStationWithName("중화역");
        Section section = Section.newSectionWithLineStations(line, station1, station2);
        Order order = Order.newOrder("3");
        assertThat(section.insertStation(station3, order)).isEqualTo(3);
    }
}
