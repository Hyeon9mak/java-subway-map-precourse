package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationDisplay;
import subway.view.UserInput;

public class StationService {

    public static void save() {
        String name = UserInput.getStationNameForSave();
        Station station = Station.newStationWithName(name);
        StationRepository.addStation(station);
        StationDisplay.printSaveSuccess();
    }

    public static void print() {
    }

    public static void delete() {
    }
}
