package subway;

import subway.view.MainDisplay;

public class SubwayMap {

    private SubwayMap() {
    }

    public static SubwayMap newSubwayMap() {
        return new SubwayMap();
    }

    public void start() {
        MainDisplay.loadMenu();
    }
}
