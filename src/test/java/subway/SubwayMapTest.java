package subway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SubwayMapTest {

    @Test
    public void testCreate() {
        SubwayMap subwayMap = SubwayMap.newSubwayMap();
        subwayMap.start();
    }


}
